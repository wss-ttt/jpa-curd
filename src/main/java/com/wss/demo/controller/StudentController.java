package com.wss.demo.controller;

import com.wss.demo.entity.Student;
import com.wss.demo.repository.StudentReporitory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.spring5.util.SpringContentTypeUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentReporitory studentReporitory = null;

    // 返回所有的数据
    @GetMapping("/list")
    @ResponseBody
    public List<Student> list(){
        return studentReporitory.findAll();
    }

    // 通过id返回单条数据
    @GetMapping("/info/{id}")
    @ResponseBody
    public  Student info(@PathVariable("id") int id){
        Optional<Student> op = studentReporitory.findById(id);
        Student student = null;
        if(op.isPresent())
            student = op.get();
        return  student;
    }
    // 通过id进行删除数据
    @PostMapping("/delete/{id}")
    @ResponseBody
    public boolean delete(@PathVariable("id") int id){
       Student student = studentReporitory.findById(id).get();
        studentReporitory.delete(student);
        return true;
    }

    // 新增数据
    @PostMapping("/add")
    @ResponseBody
    public boolean add(Student student){
        studentReporitory.save(student);
        return true;
    }

    // 修改数据
    @PostMapping("/update")
    @ResponseBody
    public boolean update(Student s){
        Student student = studentReporitory.findById(s.getId()).get();
        student.setAge(s.getAge());
        student.setName(s.getName());
        studentReporitory.save(student);
        return true;
    }
    @GetMapping("/index")
    public ModelAndView index(){
        List<Student> lst =studentReporitory.findAll();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("students",lst);
        return mav;
    }


}
