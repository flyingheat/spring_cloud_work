package com.jingrui.student_manage.mapper;

import com.cloud.pojo.Student;
import com.cloud.pojo.User;
import com.jingrui.student_manage.service.StudentService;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface StudentMapper {

    @Select("select * from tb_user where username = #{username} and password = #{password}")
    User userLogin(User user);

    @Select("select * from tb_student")
    List<Student> getStudentList();

    @Insert("insert into tb_student(name,age,hobby,classId,province,city,district)" +
            "values (#{name},#{age},#{hobby},#{classId},#{province},#{city},#{district})")
    int addStudent(Student student);
}
