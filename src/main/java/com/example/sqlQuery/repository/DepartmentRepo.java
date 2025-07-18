package com.example.sqlQuery.repository;

import com.example.sqlQuery.dto.DepartmentStudentTeacherDto;
import com.example.sqlQuery.dto.DepartmentTeacherDto;
import com.example.sqlQuery.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepo extends JpaRepository<Department,Long> {
    @Query("SELECT d.name AS departmentName,t.name AS teacherName FROM Department d JOIN d.teachers t")
    List<DepartmentTeacherDto> getAllTeacherFromDepartment();

    @Query("SELECT new com.example.sqlQuery.dto.DepartmentStudentTeacherDto(d.name,s.name) FROM Department d JOIN d.teachers t JOIN t.courses c JOIN c.students s")
    List<DepartmentStudentTeacherDto> getGetDepartmentStudentEntrolledCourse();
}
