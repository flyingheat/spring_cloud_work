package com.jingrui.student_manage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@MapperScan("com.jingrui.student_manage.mapper")
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.cloud.client")
public class StudentManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentManageApplication.class, args);
    }

    /**
     * 远程调用
     *  @LoadBalanced  用于负载均衡 默认情况下是轮询 多个留个一个一个执行
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){

        return new RestTemplate();

    }

}
