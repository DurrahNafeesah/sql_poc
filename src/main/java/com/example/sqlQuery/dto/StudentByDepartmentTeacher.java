package com.example.sqlQuery.dto;

import lombok.Data;

@Data
public class StudentByDepartmentTeacher {
    private String studentName;
    private String departmentName;
    private String teacherName;
    public StudentByDepartmentTeacher(String studentName, String departmentName, String teacherName) {
        this.studentName = studentName;
        this.departmentName = departmentName;
        this.teacherName = teacherName;
    }


}
