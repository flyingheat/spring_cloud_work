package com.jingrui.class_manage.controller;

import com.jingrui.class_manage.pojo.Classes;
import com.jingrui.class_manage.service.ClassesService;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/classes")
public class ClassesController {

    @Autowired
    private ClassesService classesService;

    @ResponseBody
    @GetMapping("{classId}")
    public Classes findClassById(@PathVariable Integer classId){
        return classesService.findClassById(classId);
    }

    @ResponseBody
    @RequestMapping("/findAllClasses")
    public List<Classes> findAllClasses(){
        return classesService.findAllClasses();
    }

}
