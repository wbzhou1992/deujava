package com.wbzhou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.wbzhou.dao")
@SpringBootApplication
public class EdujavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EdujavaApplication.class, args);
    }

}
