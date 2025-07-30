package com.example.sqlQuery.repository;

import com.example.sqlQuery.dto.CourseDto;
import com.example.sqlQuery.dto.CourseStudentDto;
import com.example.sqlQuery.dto.CourseTeacherDto;
import com.example.sqlQuery.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course,Long> {
    @Query("SELECT c.name AS courseName FROM Course c LEFT Join c.students s WHERE s IS NULL")
    List<CourseDto> getCourseWithoutStudents();

    @Query("SELECT new com.example.sqlQuery.dto.CourseTeacherDto(c.name,c.teacher.name)FROM Course c LEFT JOIN c.students s WHERE s IS NULL AND c.teacher  IS NOT NULL")
    List<CourseTeacherDto> getCourseWithTeacherWithoutStudent();

    @Query("""
SELECT DISTINCT new com.example.sqlQuery.dto.CourseStudentDto(c.name, s.name) FROM Course c
JOIN c.students s
JOIN c.teacher t
JOIN t.department d
WHERE d.name = :departmentName""")
    List<CourseStudentDto> getCourseStudentByDepartmentName(@Param("departmentName") String departmentName);

    @Query("""
SELECT new com.example.sqlQuery.dto.CourseStudentDto(s.name, c.name)
FROM Student s
JOIN s.courses c
WHERE SIZE(s.courses) >= 2""")

    List<CourseStudentDto> getStudentByCourseGreaterThanTwo();
}
