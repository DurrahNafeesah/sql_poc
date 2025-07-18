package com.example.sqlQuery.controller;

import com.example.sqlQuery.dto.*;
import com.example.sqlQuery.entity.Department;
import com.example.sqlQuery.entity.Student;
import com.example.sqlQuery.repository.DepartmentRepo;
import com.example.sqlQuery.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sql")
public class StudentController {
    @Autowired
    private StudentRepo studentRepo;

    @PostMapping("/Student")
    public Student saveStudent(@RequestBody Student student){
        return studentRepo.save(student);
    }

    @GetMapping("/studentDepartment")
    public List<StudentDepartmentDto> findAllStudentsWithDepartment(){
        return studentRepo.getStudentDepartmentData();
    }
    @GetMapping("/studentCourse")
    public List<StudentCourseDto> findAllStudentsWithCourse(){
        return studentRepo.getStudentCourseData();
    }

    @GetMapping("/courseStudent")
    public List<CourseStudentDto> findAllCourseStudents(){
        return studentRepo.getCourseStudentData();
    }

    @GetMapping("/fullJoin")
    public List<FullJoinStudentCourseDto> findAllFullJoin(){
        return studentRepo.getFullJoinStudentCourseData();
    }

    @GetMapping("/multipleJoin")
    public List<StudentCourseTeacherDto> findFullJoin(){
        return studentRepo.getStudentCourseTeacherData();
    }

    @GetMapping("/studentWithCourseTeacherDepartment")
    public List<StudentCourseDepartmentTeacherDto> findStudentWithCourseTeacherDepartment(){
        return studentRepo.getStudentCourseDepartmentTeacherData();
    }

    @GetMapping("/studentCourseGreaterThanTwo")
    public List<StudentDto> findStudentCourseGreaterThanTwo(){
        return studentRepo.getStudentWithCourseGreaterThanTwo();
    }





}
