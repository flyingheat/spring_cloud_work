package com.jingrui.class_manage.mapper;

import com.jingrui.class_manage.pojo.Classes;
import org.apache.ibatis.annotations.Select;
import org.apache.tomcat.jni.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassesMapper {
    @Select("select * from tb_class where classId = #{classId}")
    Classes findClassById(Integer classId);

    @Select("select * from tb_class")
    List<Classes> findAllClasses();

}
