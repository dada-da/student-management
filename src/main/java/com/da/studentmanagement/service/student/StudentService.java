package com.da.studentmanagement.service.student;

import com.da.studentmanagement.entity.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student) throws Exception;

    void updateStudent(String studentId, Student student) throws Exception;

    void deleteStudent(String studentId) throws Exception;

    List<Student> getAllStudent();

    Student getStudentById(String studentId) throws Exception;

    double getGpa(Student student);
}
