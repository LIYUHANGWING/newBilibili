package com.example.biliE;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.ymzting_dm_web.Dao")
@SpringBootApplication
public class bilibiliEApplication {

    public static void main(String[] args) {
        SpringApplication.run(bilibiliEApplication.class, args);
    }

}
