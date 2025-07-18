package com.example.sqlQuery.dto;

import lombok.Data;

@Data
public class CourseStudentDto {
    private String studentName;
    private String courseName;
    public CourseStudentDto(String studentName, String courseName) {

        this.studentName = studentName;
        this.courseName = courseName;
    }
}
