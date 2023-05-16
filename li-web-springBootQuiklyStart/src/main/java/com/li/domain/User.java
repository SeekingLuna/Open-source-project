package com.li.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhengkai.blog.csdn.net
 * @description user
 * @date 2023-03-30
 */
@Data
@TableName("user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {


    @TableId(type = IdType.AUTO)
    /**
     * id
     */
    private Integer id;

    /**
     * username
     */
    private String username;

    /**
     * password
     */
    private String password;

    /**
     * email
     */
    private String email;

    /**
     * age
     */
    private int age;

    /**
     * gender
     */
    private String gender;

    /**
     * height
     */
    private BigDecimal height;

    /**
     * weight
     */
    private BigDecimal weight;

    /**
     * country
     */
    private String country;

    /**
     * province
     */
    private String province;

    /**
     * city
     */
    private String city;

    /**
     * address
     */
    private String address;

    /**
     * phone
     */
    private String phone;

    /**
     * last_login_time
     */
    private Date lastLoginTime;

    /**
     * register_time
     */
    private Date registerTime;


}