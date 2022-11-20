package com.example.school.entity;

import lombok.*;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Builder
// we can use attribute override to write new name to these attribute in the Student class
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "guardianName")
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "guardianEmail")
        ),
        @AttributeOverride(
                name = "mobileNumber",
                column = @Column(name = "guardianMobileNumber")
        )
}
)
public class Guardian {

//    @Column(name = "guardianName")
    private String name;
//    @Column(name = "guardianEmail")
    private String email;
//    @Column(name = "guardianMobileNumber")
    private String mobileNumber;
}
