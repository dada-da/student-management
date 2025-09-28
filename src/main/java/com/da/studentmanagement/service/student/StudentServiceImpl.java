package com.da.studentmanagement.service.student;

import com.da.studentmanagement.entity.Student;
import com.da.studentmanagement.repository.student.StudentRepository;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepo;

    private void validateStudentId(String id) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("Student id is empty!");
    }

    private void validateStudent(Student student) {
        if (student == null) throw new IllegalArgumentException("Student is null");
        validateStudentId(student.getStudentId());
        if (student.getFirstName() == null || student.getFirstName().isBlank()) throw new IllegalArgumentException("First name empty");
        if (student.getLastName() == null || student.getLastName().isBlank()) throw new IllegalArgumentException("Last name empty");
        if (student.getClassId() == null || student.getClassId().isBlank()) throw new IllegalArgumentException("Class id empty");
    }

    public StudentServiceImpl(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public void addStudent(Student student) {
        validateStudent(student);

        if (studentRepo.getById(student.getStudentId()) != null) {
            throw new IllegalArgumentException("Student with id " + student.getStudentId() + " already exists!");
        }

        this.studentRepo.create(student);
    }

    @Override
    public void updateStudent(String studentId, Student student) {
        validateStudent(student);
        validateStudentId(studentId);

        if (studentRepo.getById(studentId) == null) {
            throw new IllegalArgumentException("Student with id " + studentId + " not found!");
        }

        student.setStudentId(studentId);

        this.studentRepo.update(student);
    }

    @Override
    public void deleteStudent(String studentId) {
        validateStudentId(studentId);

        if (studentRepo.getById(studentId) == null) {
            throw new IllegalArgumentException("Student with id " + studentId + " not found!");
        }

        this.studentRepo.deleteById(studentId);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepo.getAll();
    }

    @Override
    public Student getStudentById(String studentId) {
        validateStudentId(studentId);

        return studentRepo.getById(studentId);
    }

    @Override
    public double getGpa(Student student) {
        return 0;
    }
}
