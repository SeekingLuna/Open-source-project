package com.li.domain;

import lombok.Data;

@Data
public class User_info {
    private int id;
    private String account;
    private String user_name;
    private String password;

    public User_info(int id, String user_name) {
        this.id = id;
        this.user_name = user_name;
    }
}
