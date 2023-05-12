package com.li.utils;

import java.util.Random;

public class GetRandomNumber {
    public static Integer getRandom(){

        Random random=new Random();
        return random.nextInt(10000);


    }
}
