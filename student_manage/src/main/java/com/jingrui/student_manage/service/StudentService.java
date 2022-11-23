package com.jingrui.student_manage.service;

import com.cloud.client.AddressClient;
import com.cloud.client.ClassesClient;
import com.cloud.pojo.Address;
import com.cloud.pojo.Classes;
import com.cloud.pojo.Student;
import com.cloud.pojo.User;
import com.jingrui.student_manage.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AddressClient addressClient;

    @Autowired
    private ClassesClient classesClient;

    public User userLogin(User user){

        return studentMapper.userLogin(user);

    }


    public List<Student> getStudentList() {

        List<Student> studentList = studentMapper.getStudentList();

        for (Student student : studentList) {
/*            Integer classId = student.getClassId();
            Integer sheng = student.getProvince();
            Integer shi = student.getCity();
            Integer qu = student.getDistrict();*/
            /*String shengName = restTemplate.getForObject("http://addressServer/address/sheng/" + student.getProvince(), String.class);
            String shiName = restTemplate.getForObject("http://addressServer/address/shi/" + student.getCity(), String.class);
            String quName = restTemplate.getForObject("http://addressServer/address/qu/" + student.getDistrict(), String.class);
            Classes className = restTemplate.getForObject("http://classesServer/classes/" + student.getClassId(), Classes.class);
            */
            String shengName = addressClient.getShengAddress(student.getProvince());
            String shiName = addressClient.getShengAddress(student.getCity());
            String quName = addressClient.getShengAddress(student.getDistrict());
            Classes className = classesClient.findClassById(student.getClassId());

            student.setSheng(shengName);
            student.setShi(shiName);
            student.setQu(quName);
            student.setClassName(className.getClassName());
            System.out.println(student);

        }
        return studentList;
    }
    public List<Address> findCityById(Integer pid) {

        /*List<Address> addressList = restTemplate.getForObject("http://addressServer/address/" + pid, List.class);*/
        List<Address> addressList = addressClient.findCityById(pid);
        System.out.println(addressList.size());

        return addressList;
    }

    public List<Classes> findAllClasses() {

        /*List<Classes> classes = restTemplate.getForObject("http://classesServer/classes/findAllClasses", List.class);*/

        List<Classes> classes = classesClient.findAllClasses();

        return classes;
    }

    public String addStudent(Student student) {
        return studentMapper.addStudent(student) == 1 ? "true":"false";
    }
}
