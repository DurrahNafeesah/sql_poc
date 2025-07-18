package com.example.sqlQuery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class StudentDepartmentDto {
    private String studentName;
    private String departmentName;
    public StudentDepartmentDto(String studentName, String departmentName) {
        this.studentName = studentName;
        this.departmentName = departmentName;
    }
}
