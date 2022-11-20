package com.example.school.Service;

import com.example.school.entity.Student;

import java.util.List;

public interface Activity {

    Student getStudentById(long id);

    Student createStudent(Student student);

    void deleteStudent(final long id);

    List<Student> getStudentsByIds(final List<Long> ids);

}
