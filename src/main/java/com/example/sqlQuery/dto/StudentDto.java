package com.example.sqlQuery.dto;

import lombok.Data;

@Data
public class StudentDto {
    private String studentName;
    private int age;
    private String departmentName;

    public StudentDto(String studentName, int age, String departmentName) {
        this.studentName = studentName;
        this.age = age;
        this.departmentName = departmentName;
    }
}
