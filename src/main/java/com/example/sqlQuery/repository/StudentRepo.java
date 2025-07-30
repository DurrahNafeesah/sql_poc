package com.example.sqlQuery.repository;

import com.example.sqlQuery.dto.*;
import com.example.sqlQuery.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Long> {
    @Query("SELECT s.name AS studentName, d.name AS departmentName FROM Student s JOIN s.department d")
    List<StudentDepartmentDto> getStudentDepartmentData();

    @Query("SELECT s.name AS studentName, c.name AS courseName FROM Student s LEFT JOIN s.courses c")
    List<StudentCourseDto> getStudentCourseData();

    @Query("SELECT s.name AS studentName, c.name AS courseName FROM Student s RIGHT JOIN s.courses c")
    List<CourseStudentDto> getCourseStudentData();

    @Query("""
SELECT new com.example.sqlQuery.dto.StudentCourseDto(s.name,c.name)
FROM Student s
LEFT JOIN s.courses c""")
    List<StudentCourseDto> getFullJoinStudentCourseData();

    @Query("""
SELECT new com.example.sqlQuery.dto.StudentCourseDto(s.name,c.name)
FROM Course c
LEFT JOIN c.students s""")
    List<StudentCourseDto> getFullJoinCourseStudentData();



    @Query("SELECT s.name AS studentName,c.name AS courseName,t.name AS teacherName FROM Student s JOIN s.courses c JOIN c.teacher t")
    List<StudentCourseTeacherDto> getStudentCourseTeacherData();

    @Query("""
    SELECT new com.example.sqlQuery.dto.StudentCourseDepartmentTeacherDto(
         s.name,c.name,t.name,d.name)
             FROM Student s
             JOIN s.courses c
             JOIN c.teacher t
             JOIN t.department d
    WHERE
        LOWER(s.name)LIKE LOWER(CONCAT('%',:queryString,'%'))OR
        LOWER(c.name)LIKE LOWER(CONCAT('%',:queryString,'%'))OR
        LOWER(t.name)LIKE LOWER(CONCAT('%',:queryString,'%'))OR
        LOWER(d.name)LIKE LOWER(CONCAT('%',:queryString,'%'))""")
    List<StudentCourseDepartmentTeacherDto> searchStudentDetails(@Param("queryString") String queryString);

    @Query("SELECT new com.example.sqlQuery.dto.StudentDto(s.name, s.age, s.department.name) FROM Student s WHERE SIZE(s.courses) >= 2")
    List<StudentDto> getStudentWithCourseGreaterThanTwo();

    @Query("""
SELECT DISTINCT new com.example.sqlQuery.dto.StudentByDepartmentTeacher(c.name, d.name,t.name) FROM Student s
JOIN s.courses c
JOIN c.teacher t
JOIN t.department d
WHERE 
    d.id IN :departmentId 
    AND t.id IN :teacherId
""")
    List<StudentByDepartmentTeacher> getStudentByDepartmentAndTeacher(
            @Param("departmentId")List<Long> departmentId,
            @Param("teacherId")List<Long> teacherId
    );

    @Query("""
SELECT DISTINCT new com.example.sqlQuery.dto.StudentByCourseAndDepartmentName(s.name, c.name, d.name) FROM Student s
JOIN s.courses c
JOIN c.teacher t
JOIN t.department d
WHERE
LOWER(c.name) IN :courseName
AND LOWER(d.name) IN :departmentName""")
    List<StudentByCourseAndDepartmentName> getStudentByCourseAndDepartmentName(
            @Param("courseName") List<String> courseName,
            @Param("departmentName")List<String> departmentName
    );





}
