package com.li;

import com.li.utils.GetRandomNumber;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Test1 {

@Test

public void testJWT(){


    Map<String, Object> map=new HashMap<>();
    map.put("id", GetRandomNumber.getRandom());
    map.put("name","Mike");

    String jwt=Jwts.builder()
            .signWith(SignatureAlgorithm.HS256,"chaogeyyds")
            .setClaims(map)
            .setExpiration(new Date(System.currentTimeMillis()+3600*1000))
            .compact();
    System.out.println(jwt);

}
@Test
public void verifyJWT(){
    Claims claims=Jwts.parser()
            .setSigningKey("chaogeyyds")
            .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiTWlrZSIsImlkIjoxMDg0LCJleHAiOjE2ODM5Mjc5NTN9.moPnE69dAPDuQDirNy30K7DRroLWgnRa1FDQNAc_AYE")
            .getBody();
    System.out.println(claims);

}




}
