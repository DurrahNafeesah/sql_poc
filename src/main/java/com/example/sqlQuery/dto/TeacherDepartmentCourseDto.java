package com.example.sqlQuery.dto;

import lombok.Data;

@Data
public class TeacherDepartmentCourseDto {
    private String teacherName;
    private String departmentName;
    private String courseName;

    public TeacherDepartmentCourseDto(String teacherName, String departmentName, String courseName){
        this.teacherName = teacherName;
        this.departmentName = departmentName;
        this.courseName = courseName;
    }
}
