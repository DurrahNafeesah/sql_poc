package com.example.sqlQuery.dto;

import lombok.Data;

@Data
public class StudentCourseDepartmentTeacherDto {
    private String studentName;
    private String courseName;
    private String teacherName;
    private String departmentName;

    public StudentCourseDepartmentTeacherDto(String studentName, String courseName, String teacherName, String departmentName) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.departmentName = departmentName;
    }
}
