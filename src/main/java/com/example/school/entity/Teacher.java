package com.example.school.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Teacher {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Long id;

        private String firstName;

        private String lastName;

        @OneToMany(cascade = CascadeType.ALL)
        @JoinColumn(name = "teacherId",
                referencedColumnName = "id")
        private List<Course> courseList;
}
