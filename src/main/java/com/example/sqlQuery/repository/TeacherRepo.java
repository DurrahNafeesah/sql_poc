package com.example.sqlQuery.repository;

import com.example.sqlQuery.dto.TeacherByCourseDepartmentStudent;
import com.example.sqlQuery.dto.TeacherDepartmentCourseDto;
import com.example.sqlQuery.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherRepo extends JpaRepository<Teacher,Long> {
    @Query("SELECT new com.example.sqlQuery.dto.TeacherDepartmentCourseDto(t.name,d.name,c.name) FROM Teacher t JOIN t.department d JOIN t.courses c")
    List<TeacherDepartmentCourseDto> findTeacherDepartmentCourse();
    @Query("""
SELECT DISTINCT new com.example.sqlQuery.dto.TeacherByCourseDepartmentStudent(d.name,c.name,s.name) FROM Teacher t
JOIN t.department d
JOIN Course c ON c.teacher.id = t.id
JOIN c.students s
WHERE 
        LOWER(s.name)LIKE LOWER(CONCAT('%',:queryString,'%'))OR
        LOWER(c.name)LIKE LOWER(CONCAT('%',:queryString,'%'))OR
        LOWER(d.name)LIKE LOWER(CONCAT('%',:queryString,'%'))
""")
    List<TeacherByCourseDepartmentStudent> searchTeachersByQuery(@Param("queryString") String queryString);

}
