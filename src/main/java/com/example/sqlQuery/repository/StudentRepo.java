package com.example.sqlQuery.repository;

import com.example.sqlQuery.dto.*;
import com.example.sqlQuery.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Long> {
    @Query("SELECT s.name AS studentName, d.name AS departmentName FROM Student s JOIN s.department d")
    List<StudentDepartmentDto> getStudentDepartmentData();

    @Query("SELECT s.name AS studentName, c.name AS courseName FROM Student s LEFT JOIN s.courses c")
    List<StudentCourseDto> getStudentCourseData();

    @Query("SELECT s.name AS studentName, c.name AS courseName FROM Student s RIGHT JOIN s.courses c")
    List<CourseStudentDto> getCourseStudentData();

    @Query(value = """
    SELECT s.name AS studentName, c.name AS courseName
    FROM student s
    LEFT JOIN student_course sc ON s.id = sc.student_id
    LEFT JOIN course c ON c.id = sc.course_id

    UNION

    SELECT s.name AS studentName, c.name AS courseName
    FROM course c
    LEFT JOIN student_course sc ON c.id = sc.course_id
    LEFT JOIN student s ON s.id = sc.student_id
    """, nativeQuery = true)
    List<FullJoinStudentCourseDto> getFullJoinStudentCourseData();

    @Query("SELECT s.name AS studentName,c.name AS courseName,t.name AS teacherName FROM Student s JOIN s.courses c JOIN c.teacher t")
    List<StudentCourseTeacherDto> getStudentCourseTeacherData();

    @Query("SELECT new com.example.sqlQuery.dto.StudentCourseDepartmentTeacherDto(s.name,c.name,t.name,d.name) FROM Student s JOIN s.courses c JOIN c.teacher t JOIN t.department d")
    List<StudentCourseDepartmentTeacherDto> getStudentCourseDepartmentTeacherData();

    @Query("SELECT new com.example.sqlQuery.dto.StudentDto(s.name, s.age, s.department.name) FROM Student s WHERE SIZE(s.courses) >= 2")
    List<StudentDto> getStudentWithCourseGreaterThanTwo();


}
