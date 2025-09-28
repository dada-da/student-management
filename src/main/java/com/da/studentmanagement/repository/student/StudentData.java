package com.da.studentmanagement.repository.student;

import com.da.studentmanagement.entity.Student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class StudentData implements StudentRepository {
    private final String filePath;
    private final HashMap<String,Student> studentHashMap;

    public StudentData(String filePath) {
        this.filePath = filePath;
        this.studentHashMap = new HashMap<>(this.loadFromFile().stream().collect(Collectors.toMap(Student::getStudentId, student -> student)));
    }

    private void saveToFile() {
        String[] header = {"studentId", "firstName", "lastName", "email", "phoneNumber", "address", "classId"};

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.filePath))) {
            writer.write(String.join(",", header));
            for (Student student : this.studentHashMap.values()) {
                writer.write(student.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing file: " + e.getMessage(), e);
        }
    }

    private List<Student> loadFromFile() {
        List<Student> students = new ArrayList<>();
        boolean isFirstLine = true;

        try {
            try (InputStream is = StudentData.class.getClassLoader().getResourceAsStream(this.filePath);
                 BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (isFirstLine) {
                        isFirstLine = false;
                        continue;
                    }

                    String[] studentData = line.split(",");
                    Student student = new Student(studentData[0], studentData[1], studentData[2], studentData[3], studentData[4], studentData[5], studentData[6]);
                    students.add(student);
                }
            } catch (IOException e) {
                throw new RuntimeException("Error reading file: " + e.getMessage(), e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public List<Student> getAll() {
        return new ArrayList<>(this.studentHashMap.values());
    }

    @Override
    public Student getById(String id) {
        return this.studentHashMap.get(id);
    }

    @Override
    public void create(Student student) {
        studentHashMap.put(student.getStudentId(), student);
        this.saveToFile();
    }

    @Override
    public void update(Student student) {
        studentHashMap.put(student.getStudentId(), student);
        this.saveToFile();
    }

    @Override
    public void deleteById(String id) {
        studentHashMap.remove(id);
        this.saveToFile();
    }
}
