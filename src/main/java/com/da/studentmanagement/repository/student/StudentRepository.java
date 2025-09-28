package com.da.studentmanagement.repository.student;

import com.da.studentmanagement.entity.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> getAll();
    Student getById(String id);
    void create(Student student);
    void update(Student student);
    void deleteById(String id);
}
