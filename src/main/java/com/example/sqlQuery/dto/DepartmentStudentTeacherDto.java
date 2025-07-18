package com.example.sqlQuery.dto;

import lombok.Data;

@Data
public class DepartmentStudentTeacherDto {
    private String departmentName;
    private String studentName;
    public DepartmentStudentTeacherDto(String departmentName, String studentName){
        this.departmentName = departmentName;
        this.studentName = studentName;
    }
}
