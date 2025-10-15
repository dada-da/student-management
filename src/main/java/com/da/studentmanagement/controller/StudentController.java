package com.da.studentmanagement.controller;

import com.da.studentmanagement.entity.Student;
import com.da.studentmanagement.service.student.StudentIdService;
import com.da.studentmanagement.service.student.StudentService;
import com.da.studentmanagement.utils.InputValidator;

import java.util.List;
import java.util.Scanner;

public class StudentController {
    private final StudentService service;
    private final StudentIdService studentIdService;
    private final Scanner scanner;

    public StudentController(StudentService service, StudentIdService studentIdService, Scanner scanner) {
        this.service = service;
        this.studentIdService = studentIdService;
        this.scanner = scanner;
    }

    public void handleCreate() {
        String firstName = InputValidator.getRequiredInput(scanner, "Enter first name: ", "First name is required");
        String lastName = InputValidator.getRequiredInput(scanner, "Enter last name: ", "Last name is required");
        String classId = InputValidator.getRequiredInput(scanner, "Enter class ID: ", "Class ID is required");

        String newStudentId = studentIdService.generateStudentId();

        Student newStudent = new Student(firstName, lastName, classId, newStudentId);

        try {
            service.addStudent(newStudent);
            System.out.println("Added student successfully");
        } catch (Exception e) {
            System.err.println("Error adding student: " + e.getMessage());
        }
    }

    public void handleUpdate() {
    }

    public void handleDelete() {
    }

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

        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}
