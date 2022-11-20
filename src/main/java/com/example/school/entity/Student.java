package com.example.school.entity;

import com.example.school.enums.StudentStatus;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_Student", uniqueConstraints = {
        @UniqueConstraint(name = "uniqueConstraints", columnNames = {"EMAILADDRESS", "FIRSTNAME"})
})
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;

    @NotNull
    private String firstName;

    private String lastName;

    @NotNull
    @Column(name = "EmailAddress")
    private String emailId;

//    private String guardianName;
//    private String guardianEmail;
//    private String guardianMobile;
    @Embedded
    private Guardian guardian;

    @Builder.Default
    private StudentStatus status = StudentStatus.REGULAR;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", guardianName='" + getGuardian().getName() + '\'' +
                ", guardianEmail='" + getGuardian().getEmail() + '\'' +
                ", guardianMobile='" + getGuardian().getMobileNumber() + '\'' +
                '}';
    }
}
