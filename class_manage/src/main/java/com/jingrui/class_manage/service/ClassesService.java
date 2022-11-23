package com.jingrui.class_manage.service;

import com.jingrui.class_manage.mapper.ClassesMapper;
import com.jingrui.class_manage.pojo.Classes;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesService {

    @Autowired
    private ClassesMapper classesMapper;

    public Classes findClassById(Integer classId) {

        return classesMapper.findClassById(classId);
    }

    public List<Classes> findAllClasses() {
        return classesMapper.findAllClasses();
    }
}
