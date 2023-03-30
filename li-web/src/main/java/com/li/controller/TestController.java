package com.li.controller;


import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.li.dao.UserMapper;
import com.li.domain.User;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
