package com.example.sqlQuery.dto;

import lombok.Data;

@Data
public class DepartmentTeacherDto {
    private String departmentName;
    private String teacherName;
    public DepartmentTeacherDto(String departmentName, String teacherName) {
        this.departmentName = departmentName;
        this.teacherName = teacherName;
    }
}
