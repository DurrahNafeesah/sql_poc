package com.example.sqlQuery.dto;

import lombok.Data;

@Data
public class CourseDto {
    private String courseName;
    public CourseDto(String courseName) {
        this.courseName = courseName;

    }
}
