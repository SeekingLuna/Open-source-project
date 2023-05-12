package com.li.utils;

import java.util.Random;

public class GetRandomNumber {
    public static int getRandom(){

        Random random=new Random();
        return random.nextInt(10000);


    }
}
