package com.jingrui.class_manage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jingrui.class_manage.mapper")
public class ClassManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClassManageApplication.class, args);
    }

}
