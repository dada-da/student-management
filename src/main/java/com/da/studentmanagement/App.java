package com.da.studentmanagement;

import com.da.studentmanagement.controller.StudentController;
import com.da.studentmanagement.repository.student.StudentData;
import com.da.studentmanagement.repository.student.StudentIdData;
import com.da.studentmanagement.service.student.StudentIdService;
import com.da.studentmanagement.service.student.StudentService;
import com.da.studentmanagement.service.student.StudentServiceImpl;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final String id_file = "./student_ids.txt";
        final String student_file = "./students.csv";

        StudentData sd = new StudentData(student_file);
        StudentIdData studentIdData = new StudentIdData(id_file);
        StudentIdService studentIdService = new StudentIdService(studentIdData);
        StudentService studentService = new StudentServiceImpl(sd);
        StudentController studentController = new StudentController(studentService);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("=== Student Management Menu ===");
            System.out.println("1. List Students");
            System.out.println("2. Add Student");
            System.out.println("3. Save to CSV");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    studentController.handleGetAll();
                    break;
                case "2":
                    break;
                case "3":
                    System.out.println("[Save to CSV] feature coming soon...");
                    break;
                case "4":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
