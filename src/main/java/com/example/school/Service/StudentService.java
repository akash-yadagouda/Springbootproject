package com.example.school.Service;

import com.example.school.entity.Student;
import com.example.school.enums.StudentStatus;

import java.util.List;

public interface StudentService {

    Student getStudent(final long id);
    List<Student> getStudentByStatus(final StudentStatus status);
}
