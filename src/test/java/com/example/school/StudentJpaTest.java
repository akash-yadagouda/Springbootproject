package com.example.school;

import com.example.school.Repository.StudentRepository;
import com.example.school.entity.Guardian;
import com.example.school.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentJpaTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void testStudentSave(){

        Guardian guardian = Guardian.builder()
                .name("Chidanand")
                .email("Chidanand@gmail.com")
                .mobileNumber("9876455673").build();

        Student student = Student.builder()
                .firstName("Akash")
                .lastName("Yadagouda")
                .emailId("akash@gmail.com")
                .guardian(guardian)
                .build();

        Student studentFromDB = studentRepository.save(student);
    }

    @Test
    void testGetAllStudent() {
        List<Student> students = new ArrayList<>();

        students = studentRepository.findAll();

        students.forEach(
                student -> {
                    System.out.println(student);
                }
        );
    }

    @Test
    void testFindByFirstName(){
        final String firstName = "Akash";
        List<Student> students = this.studentRepository.findByFirstName(firstName);
        assertEquals(1, students.size());
    }



}
