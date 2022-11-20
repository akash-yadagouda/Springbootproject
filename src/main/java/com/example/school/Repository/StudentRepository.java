package com.example.school.Repository;

import com.example.school.entity.Student;
import com.example.school.enums.StudentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    List<Student> findByFirstName(String name);

    List<Student> findByIdIn(List<Long> ids);

    List<Student > findByStatus(StudentStatus status);

}
