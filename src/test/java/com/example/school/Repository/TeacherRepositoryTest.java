package com.example.school.Repository;

import com.example.school.entity.Course;
import com.example.school.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    void testSaveTeacher() {

        Course course = Course.builder()
                .courseTitle("Java For Starter")
                .credit(10).build();


        Teacher teacher = Teacher.builder()
                .firstName("Akash")
                .lastName("Yadagouda")
                .courseList(List.of(course)).build();

        this.teacherRepository.save(teacher);

    }
}