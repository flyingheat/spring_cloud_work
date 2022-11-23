package com.cloud.client;

import com.cloud.config.FeignClientConfiguration;
import com.cloud.pojo.Classes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value="classesServer",configuration = FeignClientConfiguration.class)
public interface ClassesClient {

    @GetMapping("/classes/{classId}")
    Classes findClassById(@PathVariable Integer classId);

    @RequestMapping("/classes/findAllClasses")
    List<Classes> findAllClasses();

}
