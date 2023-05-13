package com.li;

import com.li.dao.DAO_user_info;
import com.li.utils.GetRandomNumber;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@SpringBootTest(classes = ApplicationWeb.class)
@RunWith(SpringRunner.class)
@Slf4j
public class Test1 {

    @Test

    public void testJWT() {


        Map<String, Object> map = new HashMap<>();
        map.put("id", GetRandomNumber.getRandom());
        map.put("name", "Mike");

        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "chaogeyyds").setClaims(map).setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)).compact();
        System.out.println(jwt);

    }

    @Test


    public void verifyJWT() {
        Claims claims = Jwts.parser().setSigningKey("chaogeyyds").parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiTWlrZSIsImlkIjoxMDg0LCJleHAiOjE2ODM5Mjc5NTN9.moPnE69dAPDuQDirNy30K7DRroLWgnRa1FDQNAc_AYE").getBody();
        System.out.println(claims);

    }

    @Autowired
    private DAO_user_info dao_user_info;

    @Test
    public void DAO_user_info_test() {
        log.info("dao_user_info: {}",dao_user_info);
        System.out.println(dao_user_info.selectName("user1", "password1"));
        System.out.println(dao_user_info.selectUserInfo("user1","password1").toString());

    }



}
