package com.example.sqlQuery.controller;

import com.example.sqlQuery.dto.*;
import com.example.sqlQuery.entity.Department;
import com.example.sqlQuery.entity.Student;
import com.example.sqlQuery.repository.DepartmentRepo;
import com.example.sqlQuery.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
    public List<StudentCourseDto> findAllFullJoin(){
        List<StudentCourseDto>list1=studentRepo.getFullJoinStudentCourseData();
        List<StudentCourseDto>list2=studentRepo.getFullJoinCourseStudentData();

        Set<StudentCourseDto> merged=new LinkedHashSet<>();
        merged.addAll(list1);
        merged.addAll(list2);

        return new ArrayList<>(merged);
    }

    @GetMapping("/multipleJoin")
    public List<StudentCourseTeacherDto> findFullJoin(){
        return studentRepo.getStudentCourseTeacherData();
    }

    @GetMapping("/studentWithCourseTeacherDepartment")
    public List<StudentCourseDepartmentTeacherDto> findStudentWithCourseTeacherDepartment(@RequestParam String query){
        return studentRepo.searchStudentDetails(query);
    }

    @GetMapping("/studentCourseGreaterThanTwo")
    public List<StudentDto> findStudentCourseGreaterThanTwo(){
        return studentRepo.getStudentWithCourseGreaterThanTwo();
    }

    @GetMapping("/studentByCourseAndTeacher")
    public List<StudentByDepartmentTeacher> findStudentByDepartmentAndTeacher(@RequestParam("departmentId") List<Long> departmentId, @RequestParam("teacherId") List<Long> teacherId){
        return studentRepo.getStudentByDepartmentAndTeacher(departmentId,teacherId);
    }

    @GetMapping("/studentByCourseAndDepartmentName")
    public List<StudentByCourseAndDepartmentName> findStudentByCourseAndDepartmentName(@RequestParam List<String> courseName,@RequestParam List<String> departmentName){
        return studentRepo.getStudentByCourseAndDepartmentName(courseName,departmentName);
    }





}
