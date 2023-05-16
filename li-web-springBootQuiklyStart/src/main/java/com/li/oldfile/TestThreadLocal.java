package com.li.oldfile;

import com.li.domain.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class TestThreadLocal {
    private ThreadLocal<Object> threadLocal = new ThreadLocal();

    public static void main(String[] args) {
        ArrayList<User> integerArrayList = new ArrayList<User>();
        adds(integerArrayList);

        //找出最大id
        int max=0;
        for (User user : integerArrayList) {
            max= user.getId()>max? user.getId(): max;
        }
        System.out.println(max);

        System.out.println(integerArrayList.stream().max(Comparator.comparing(User::getId)).get().getId());



    }



















    private static void adds(List<User> integerArrayList) {
        integerArrayList.add(User.builder().id(1).gender("男").username("李哥").build());
        integerArrayList.add(User.builder().id(2).gender("女").username("王哥").build());
        integerArrayList.add(User.builder().id(3).gender("男").username("郭哥").build());
        integerArrayList.add(User.builder().id(4).gender("男").username("刘哥").build());
        integerArrayList.add(User.builder().id(5).gender("女").username("大哥").build());
        integerArrayList.add(User.builder().id(6).gender("男").username("超弟").build());
    }
}
