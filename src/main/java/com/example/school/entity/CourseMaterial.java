package com.example.school.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@ToString(exclude = "course")
public class CourseMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE )
    private Long id;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "courseId",
    referencedColumnName = "id")
    private Course course;
}
