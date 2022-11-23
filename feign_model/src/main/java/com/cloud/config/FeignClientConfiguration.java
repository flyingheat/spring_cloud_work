package com.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class FeignClientConfiguration {

    /**
     * 设置日志级别
     */
    @Bean
    public Logger.Level feignLevel(){
        return Logger.Level.BASIC;
    }

}
