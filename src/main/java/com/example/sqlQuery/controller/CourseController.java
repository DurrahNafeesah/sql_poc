package com.example.sqlQuery.controller;

import com.example.sqlQuery.dto.CourseDto;
import com.example.sqlQuery.dto.CourseTeacherDto;
import com.example.sqlQuery.entity.Course;
import com.example.sqlQuery.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sql")
public class CourseController {
    @Autowired
    private CourseRepo courseRepo;

    @PostMapping("/course")
    public Course addCourse(@RequestBody Course course) {
        return courseRepo.save(course);
    }

    @GetMapping("/courseWithoutStudent")
    public List<CourseDto> findCourseWithoutStudents() {
        return courseRepo.getCourseWithoutStudents();
    }
    @GetMapping("/courseWithTeacherWithoutStudent")
    public List<CourseTeacherDto> findCourseWithTeacherWithoutStudent() {
        return courseRepo.getCourseWithTeacherWithoutStudent();
    }
}
