package com.example.sqlQuery.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;

    @OneToMany(cascade=CascadeType.ALL,mappedBy="department")
    private List<Student> students;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "department")
    private List<Teacher> teachers;

}
