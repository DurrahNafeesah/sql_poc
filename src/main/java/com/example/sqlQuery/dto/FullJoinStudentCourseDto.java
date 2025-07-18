package com.example.sqlQuery.dto;

import lombok.Data;

@Data
public class FullJoinStudentCourseDto {
    private String studentName;
    private String courseName;
    public FullJoinStudentCourseDto(String studentName, String courseName) {
        this.studentName = studentName;
        this.courseName = courseName;
    }
}
