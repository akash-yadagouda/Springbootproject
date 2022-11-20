package com.example.school.Service.Impl;

import com.example.school.Repository.StudentRepository;
import com.example.school.Service.StudentService;
import com.example.school.entity.Student;
import com.example.school.enums.StudentStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getStudent(long id) {
        return this.studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Student> getStudentByStatus(StudentStatus status) {
        List<Student> byStatus = this.studentRepository.findByStatus(status);
        if(byStatus == null || byStatus.isEmpty()){
            log.info("student not found ");
            return null;
        }
        return byStatus;
    }
}
