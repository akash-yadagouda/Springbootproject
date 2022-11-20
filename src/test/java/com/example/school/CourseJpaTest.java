package com.example.school;

import com.example.school.Repository.CourseMaterialRepository;
import com.example.school.Repository.CourseRepository;
import com.example.school.entity.Course;
import com.example.school.entity.CourseMaterial;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CourseJpaTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Autowired
    private CourseRepository courseRepository;

    @BeforeEach
    void inti(){
        System.out.println("Before each test cases runs");
    }


    @Test
    void testAddCourseMaterial() {

        // Cascading feature

        Course course = Course.builder()
                .courseTitle("Java For Starter")
                .credit(10).build();

        CourseMaterial courseMaterial = CourseMaterial.builder().url("/java").course(course).build();

        courseMaterialRepository.save(courseMaterial);

    }

    @Test
    void testCascadingFeat(){
        // source : https://www.baeldung.com/jpa-cascade-types
        // create a course materiual


        Course course = Course.builder().courseTitle("testCascading").credit(10).build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .course(course).url("/testcascading").build();

        courseMaterialRepository.saveAndFlush(courseMaterial);

        // delete the courseMaterial and see that course also gets deleted.

        courseMaterialRepository.deleteAll();
    }

    @Test
    void testFetchType_Eger_Lazy() {

        // fetch type tells whether to fetch the child object or not
        // Lazy : fetch the child object also
        // eager : fetch the parent only not child ( if entity is annotated with the @tostring then child object should be excluded from that )
        Course course = Course.builder()
                .courseTitle("Java For Starter")
                .credit(10).build();

        CourseMaterial courseMaterial = CourseMaterial.builder().url("/java").course(course).build();

        courseMaterialRepository.save(courseMaterial);

        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();

        System.out.println("courseMaterials = " + courseMaterials);

    }

    @Test
    void testOneToOneBi_directionalMapping(){
        Course course = Course.builder()
                .courseTitle("Java For Starter")
                .credit(10).build();

        CourseMaterial courseMaterial = CourseMaterial.builder().url("/java").course(course).build();

        courseMaterialRepository.save(courseMaterial);

        // fetch the course and along with courseMaterials info
        List<Course> courses = courseRepository.findAll();
        System.out.println("course = " + course);


    }


//    @AfterEach
//    void deletethedata(){
//        courseMaterialRepository.deleteAll();
//        courseRepository.deleteAll();
//    }
}
