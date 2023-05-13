package com.li.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MyJWT {


    public void setJWT(){


        Map<String, Object> map=new HashMap<>();
        map.put("id", GetRandomNumber.getRandom());
        map.put("name","Mike");

        String jwt= Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"chaogeyyds")
                .setClaims(map)
                .setExpiration(new Date(System.currentTimeMillis()+3600*1000))
                .compact();
        System.out.println(jwt);

    }


    public void verifyJWT(){
        Claims claims=Jwts.parser()
                .setSigningKey("chaogeyyds")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiTWlrZSIsImlkIjoxMDg0LCJleHAiOjE2ODM5Mjc5NTN9.moPnE69dAPDuQDirNy30K7DRroLWgnRa1FDQNAc_AYE")
                .getBody();
        System.out.println(claims);

    }

}
