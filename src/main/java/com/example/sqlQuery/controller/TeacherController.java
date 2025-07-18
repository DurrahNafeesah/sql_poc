package com.example.sqlQuery.controller;

import com.example.sqlQuery.dto.TeacherDepartmentCourseDto;
import com.example.sqlQuery.entity.Teacher;
import com.example.sqlQuery.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sql")
public class TeacherController {
    @Autowired
    private TeacherRepo teacherRepo;

    @PostMapping("/teacher")
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return teacherRepo.save(teacher);
    }
    @GetMapping("/teacherDepartmentCourse")
    public List<TeacherDepartmentCourseDto> findTeacherDepartmentCourse() {
        return teacherRepo.findTeacherDepartmentCourse();
    }
}
