package com.example.school.enums;

public enum StudentStatus {
    REGULAR(1),
    IRREGULAR(2);

    int studentStatus;
    int getValue;

    StudentStatus(int i) {
        this.studentStatus = i;
    }

    public static int getValue(StudentStatus studentStatus) {
        return StudentStatus.getValue(studentStatus);
    }
}
