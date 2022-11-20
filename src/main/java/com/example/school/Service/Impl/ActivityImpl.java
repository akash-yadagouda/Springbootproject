package com.example.school.Service.Impl;

import com.example.school.Repository.StudentRepository;
import com.example.school.Service.Activity;
import com.example.school.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ActivityImpl implements Activity {

    @Autowired
    private StudentRepository studentRepository;

    @Override
//    @Cacheable(cacheNames = "Student", key = "#id")
    public Student getStudentById(long id) {
        log.info("fetching data from the DB");
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return student.get();
        }
        return new Student();
    }

    @Override
//    @CachePut(cacheNames = "Student", key = "#student.id")
    public Student createStudent(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
//    @CacheEvict(cacheNames = "Student" , key = "#id")
    public void deleteStudent(long id) {
        this.studentRepository.deleteById(id);
    }

    @Override
    @Cacheable(cacheNames = "Student", key = "#p0")
    public List<Student> getStudentsByIds(final List<Long> ids){


//        get data form the cache first if pareset any keys without value
//        then go for the DB call and get the data and cage it also for future use.

        List<Student> byIdIn = this.studentRepository.findByIdIn(ids);
        System.out.println("fetched from the DB" + byIdIn.size());
        return byIdIn;
    }

}
