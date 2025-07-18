package com.example.sqlQuery.dto;

import lombok.Data;

@Data
public class StudentCourseDto {
    private String studentName;
    private String courseName;
    public  StudentCourseDto(String studentName, String courseName){
        this.studentName=studentName;
        this.courseName=courseName;
    }
}
