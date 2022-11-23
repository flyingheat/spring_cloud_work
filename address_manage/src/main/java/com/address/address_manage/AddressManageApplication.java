package com.address.address_manage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.address.address_manage.controller.mapper")
public class AddressManageApplication {

    public static void main(String[]  args) {
        SpringApplication.run(AddressManageApplication.class, args);
    }

}
