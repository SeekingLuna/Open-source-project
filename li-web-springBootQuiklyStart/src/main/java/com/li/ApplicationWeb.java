package com.li;

import com.li.dao.impl.EmpDaoA;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan(value = "com.li.dao")
public class ApplicationWeb {
    public static void main(String[] args) {
//        容器
        ConfigurableApplicationContext context = SpringApplication.run(ApplicationWeb.class, args);

        EmpDaoA bean = context.getBean(EmpDaoA.class);
        System.out.println("EmpDaoA::" + bean);
    }
}
