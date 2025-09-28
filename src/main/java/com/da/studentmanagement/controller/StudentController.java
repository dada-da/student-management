package com.da.studentmanagement.controller;

import com.da.studentmanagement.entity.Student;
import com.da.studentmanagement.service.student.StudentService;

import java.util.List;

public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    public void handleCreate() {

    }

    public void handleUpdate() {}

    public void handleDelete() {}

    public void handleGetAll() {
        List<Student> students = service.getAllStudent();

        if (students.isEmpty()) {
            System.out.println("No students found");
        }

        System.out.println("\n" + "=".repeat(85));
        System.out.println("                              STUDENT DATABASE");
        System.out.println("=".repeat(85));

        // Table header
        System.out.printf("| %-12s | %-8s | %-8s | %-20s | %-12s | %-15s | %-4s |\n",
                "STUDENT ID", "FIRST", "LAST", "EMAIL", "PHONE", "ADDRESS", "CLASS");
        System.out.println("|" + "-".repeat(14) + "|" + "-".repeat(10) + "|" + "-".repeat(10) +
                "|" + "-".repeat(22) + "|" + "-".repeat(14) + "|" + "-".repeat(17) +
                "|" + "-".repeat(6) + "|");

        for(Student student : students) {
            System.out.println(student.toString());
        }
    }
}
