package com.jingrui.student_manage.controller;

import com.cloud.pojo.Address;
import com.cloud.pojo.Classes;
import com.cloud.pojo.Student;
import com.cloud.pojo.User;
import com.jingrui.student_manage.service.StudentService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/userLogin")
    @ResponseBody
    public String login(User user, HttpServletRequest request){

        User u = studentService.userLogin(user);

        System.out.println(u);

        HttpSession session = null;

        if(u != null){

            session=request.getSession();
            session.setAttribute("user",u);

        }

        return session.getAttribute("user") != null ? "true" : " false";

    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/list")
    public String getStudentList(Model model){

        List<Student> studentList = studentService.getStudentList();

        model.addAttribute("studentList", studentList);

        return "student_list";

    }

    @RequestMapping("/findCityById")
    @ResponseBody
    public List<Address> findCityById(Integer pid){

        return studentService.findCityById(pid);

    }

    @RequestMapping("/findAllClasses")
    @ResponseBody
    public List<Classes> findAllClasses(){

        return studentService.findAllClasses();

    }

    @RequestMapping("/add")
    public String toAdd(){

        return "add";
    }

    @RequestMapping("/addStudent")
    @ResponseBody
    public String addStudent(Student student){

        return studentService.addStudent(student);

    }



}
