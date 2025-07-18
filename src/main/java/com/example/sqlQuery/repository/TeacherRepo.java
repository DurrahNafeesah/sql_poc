package com.example.sqlQuery.repository;

import com.example.sqlQuery.dto.TeacherDepartmentCourseDto;
import com.example.sqlQuery.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepo extends JpaRepository<Teacher,Long> {
    @Query("SELECT new com.example.sqlQuery.dto.TeacherDepartmentCourseDto(t.name,d.name,c.name) FROM Teacher t JOIN t.department d JOIN t.courses c")
    List<TeacherDepartmentCourseDto> findTeacherDepartmentCourse();
}
