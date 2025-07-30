package com.example.sqlQuery.controller;

import com.example.sqlQuery.dto.DepartmentTeacherDto;
import com.example.sqlQuery.dto.StudentDepartmentDto;
import com.example.sqlQuery.entity.Department;
import com.example.sqlQuery.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sql")
public class DepartmentController {
    @Autowired
    private DepartmentRepo departmentRepo;

    @PostMapping("/department")
    public Department addDepartment(@RequestBody Department department) {
        return departmentRepo.save(department);
    }

    @GetMapping("/getTeacherFromDepartment")
    public List<DepartmentTeacherDto> findTeacherFromDepartment(){
        return departmentRepo.getAllTeacherFromDepartment();
    }
    @GetMapping("/departmentWithStudentEntrolledCourse")
    public List<StudentDepartmentDto> findDepartmentWithStudentEntrolledCourse(){
        return departmentRepo.getGetDepartmentStudentEntrolledCourse();
    }

}
