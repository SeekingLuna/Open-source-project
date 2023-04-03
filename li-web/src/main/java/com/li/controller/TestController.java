package com.li.controller;


import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.li.dao.UserMapper;
import com.li.domain.Result;
import com.li.domain.Tasks;
import com.li.domain.User;
import com.li.domain.User02;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

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
        List<User> users = userMapper.selectList(
                new QueryWrapper<User>().lambda()
                        .like(!StringUtils.isNullOrEmpty(user.getUsername()), User::getUsername, user.getUsername())
                        .like(!StringUtils.isNullOrEmpty(user.getEmail()), User::getEmail, user.getEmail())
                        .like(!StringUtils.isNullOrEmpty(user.getAddress()), User::getAddress, user.getAddress())
        );
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
}

