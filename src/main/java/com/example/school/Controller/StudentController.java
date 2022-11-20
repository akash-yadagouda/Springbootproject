package com.example.school.Controller;

import com.example.school.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/Student")
public class StudentController {
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") final int id){

    }


}
