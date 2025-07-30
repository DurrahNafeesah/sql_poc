package com.example.sqlQuery.dto;

import lombok.Data;

@Data
public class StudentByCourseAndDepartmentName {
    private String studentName;
    private String courseName;
    private String departmentName;

    public StudentByCourseAndDepartmentName(String studentName,String courseName,String departmentName) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.departmentName = departmentName;
    }
}
