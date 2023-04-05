package com.li.controller;


import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.li.dao.UserMapper;
import com.li.dao.impl.JDBC;
import com.li.domain.*;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ResponseBody
//设置web根路径映射
@RequestMapping
//加入到Context上下文容器 并表明属于处理器
@RestController
public class TestController {

    @Autowired
    private UserMapper userMapper;


    //    指定子映射端点
    @GetMapping("/getName")
    @Transactional //事务管理器
    public String getName(@ModelAttribute User user) {
        System.out.println(user);
        List<User> users = userMapper.selectList(new QueryWrapper<User>().lambda().like(!StringUtils.isNullOrEmpty(user.getUsername()), User::getUsername, user.getUsername()).like(!StringUtils.isNullOrEmpty(user.getEmail()), User::getEmail, user.getEmail()).like(!StringUtils.isNullOrEmpty(user.getAddress()), User::getAddress, user.getAddress()));
        String jsonString = JSON.toJSONString(users);
        return jsonString;
    }

    /**
     * 需要响应HTTP GET请求，你应该使用@GetMapping注解，它只会响应HTTP GET请求。
     * 需要处理POST请求，你应该使用@PostMapping或@RequestMapping注解，并将method属性设置为RequestMethod.POST。
     * 如果你需要同时响应HTTP GET请求和HTTP POST请求，你可以使用@RequestMapping注解，
     * 并指定method属性为RequestMethod.GET和RequestMethod.POST。
     **/
    @RequestMapping(value = "/getOwnName", method = {RequestMethod.GET, RequestMethod.POST})
    public Result getOwnName(@RequestParam("name") String ownName, @RequestParam("age") int ownAge) {
        return new Result(0, "success", ownName + ownAge);

    }


    @RequestMapping(value = "/dateTimeTest", method = {RequestMethod.GET, RequestMethod.POST})

    public Result dataTimeTest(@RequestParam("dateAndTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime dateTime) {


        System.out.println(dateTime);
        return new Result(0, "success", dateTime);
    }

    @RequestMapping(value = "jsonTest", method = {RequestMethod.GET, RequestMethod.POST})

    public Result jsonTest(@RequestBody User02 user02, HttpServletRequest request) throws IOException {
        System.out.println(request.getMethod());
        System.out.println(request.getRequestURL());
        System.out.println(user02.toString());


        return new Result(0, "success", user02);

    }

    @RequestMapping(value = "/path/{pathId}/{name}", method = {RequestMethod.GET, RequestMethod.POST})

    public Result path(@PathVariable String pathId, @PathVariable String name) {
        System.out.println(pathId);
        System.out.println(name);


        return new Result(0, "success", pathId + name);
    }

    @ResponseBody
    @RequestMapping(value = "/tasks", method = {RequestMethod.GET, RequestMethod.POST})
    public Result tasks(@RequestBody Tasks tasks) {

        System.out.println(tasks.toString());
        return new Result(0, "success", tasks);
    }


    /**
     * 对于分页接口，前端一般需要传递以下参数：
     * 页码（page）：表示当前需要显示的页码，一般从1开始。
     * 每页记录数（pageSize）：表示每页需要显示的记录数。
     * 排序字段（sortField）：表示需要按照哪个字段进行排序，可以为空。
     * 排序方式（sortOrder）：表示排序的方式，可以为升序（ASC）或降序（DESC），可以为空。
     */
    @ResponseBody
    @RequestMapping(value = "/getPage", method = {RequestMethod.GET, RequestMethod.POST})
    public Result getPage(@RequestParam("pageIndex") int pageIndex, @RequestParam("pageSize") int pageSize) {
        JDBC jdbc = new JDBC();
        ArrayList<User03> arrayList = jdbc.extracted();
        int arraySize = arrayList.size();

//        int result1 = arraySize % pageSize;// 取余数 5
        int result2 = arraySize / pageSize;// 取商数 10
        if (pageIndex > result2 + 1) {
            return new Result(1, "Error", null);
        } else {
            List<User03> subList = arrayList.subList(((pageIndex - 1) * pageSize), Math.min(((pageIndex) * pageSize), arraySize));//超哥妙笔生花
            return new Result(0, "succses", new Pages(subList, result2 + 1, pageSize, pageIndex));

        }
    }

    @ResponseBody
    @RequestMapping(value = "/getPage2", method = {RequestMethod.GET, RequestMethod.POST})
    public Result getPage2(@RequestParam("pageIndex") int pageIndex, @RequestParam("pageSize") int pageSize) {
        List<User03> userList = new JDBC().extracted();
        int total = userList.size();
        int totalPages = (int) Math.ceil((double) total / pageSize);
        if (pageIndex > totalPages) {
            return new Result(1, "Error", null);
        }
        List<User03> subList = userList.stream().skip((pageIndex - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
        return new Result(0, "success", new Pages(subList, totalPages, pageSize, pageIndex));
    }

}

