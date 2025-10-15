package com.da.studentmanagement.entity;

import java.text.DecimalFormat;

public class Student {
    private String studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String classId;
    private Subject[] subjects;

    public Student(String studentId, String firstName, String lastName, String classId, String email, String phoneNumber, String address, Subject[] subjects) {
        this(firstName, lastName, classId, email, phoneNumber, address, studentId);
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.subjects = subjects;
    }

    public Student(String studentId, String firstName, String lastName, String email, String phoneNumber, String address, String classId) {
        this(firstName, lastName, classId, studentId);
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Student(String firstName, String lastName, String classId, String studentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.classId = classId;
        this.studentId = studentId;
    }

    public Student() {

    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String toString() {
        return String.format("| %-12s | %-8s | %-8s | %-20s | %-12s | %-15s | %-4s |",
                studentId != null ? studentId : "",
                firstName != null ? firstName : "",
                lastName != null ? lastName : "",
                email != null ? email : "",
                phoneNumber != null ? phoneNumber : "",
                address != null ? address : "",
                classId != null ? classId : "");
    }
}
