package com.example.school.Controller;


import com.example.school.Service.Activity;
import com.example.school.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class ActivityController {

    @Autowired
    private Activity activity;

    @GetMapping(value = "/{id}")
    public Student getStudent(@PathVariable("id") int id){
        return activity.getStudentById(id);
    }

    @PutMapping
    public Student createStudent(@RequestBody final Student student){
        return this.activity.createStudent(student);
    }

    @DeleteMapping(value = "{id}")
    public void deleteStudent(@PathVariable long id){
        this.activity.deleteStudent(id);
    }

    @GetMapping
    List<Student> getStudentsByIds(@RequestBody List<Long> ids){
        return this.activity.getStudentsByIds(ids);
    }

}
