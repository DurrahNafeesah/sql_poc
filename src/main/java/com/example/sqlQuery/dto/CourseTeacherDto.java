package com.example.sqlQuery.dto;

import lombok.Data;

@Data
public class CourseTeacherDto {
    private String courseName;
    private String teacherName;
    public CourseTeacherDto(String courseName,String teacherName) {
        this.courseName = courseName;
        this.teacherName = teacherName;

    }
}
