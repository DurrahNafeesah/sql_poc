package com.example.sqlQuery.dto;

import lombok.Data;

@Data
public class TeacherByCourseDepartmentStudent {
    private String courseName;
    private String departmentName;
    private String studentName;
    public TeacherByCourseDepartmentStudent(String courseName,String departmentName,String studentName){
        this.courseName=courseName;
        this.departmentName=departmentName;
        this.studentName=studentName;
    }
}
