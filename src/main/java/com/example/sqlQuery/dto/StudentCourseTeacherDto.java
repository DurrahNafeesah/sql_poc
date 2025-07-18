package com.example.sqlQuery.dto;

import lombok.Data;

@Data
public class StudentCourseTeacherDto {
    private String studentName;
    private String courseName;
    private String teacherName;
    public StudentCourseTeacherDto(String studentName, String courseName, String teacherName) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.teacherName = teacherName;
    }
}
