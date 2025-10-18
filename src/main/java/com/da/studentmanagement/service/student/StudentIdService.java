package com.da.studentmanagement.service.student;

import com.da.studentmanagement.repository.filedata.IBaseFileData;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class StudentIdService {
    private static final String STUDENT_PREFIX = "STU_PTI";
    private static int currentId;
    private final IBaseFileData<String> studentIdFileData;
    private final LinkedHashSet<String> studentIdSet = new LinkedHashSet<>();

    public StudentIdService(IBaseFileData<String> studentIdFileData) {
        this.studentIdFileData = studentIdFileData;
        this.initData();
    }

    private void initData() {
        List<String> studentIdList = this.studentIdFileData.loadFromFile();
        this.studentIdSet.addAll(studentIdList);
        String lastId = this.studentIdSet.getLast().replaceAll(StudentIdService.STUDENT_PREFIX, "");
        StudentIdService.currentId = Integer.parseInt(lastId) + 1;
    }

    private void saveStudentId(String studentId) {
        this.studentIdSet.add(studentId);
        List<String> studentIdList = new ArrayList<>(this.studentIdSet);
        this.studentIdFileData.saveToFile(studentIdList);
    }

    public String generateStudentId() {
        DecimalFormat df = new DecimalFormat("00000");
        String formattedString = df.format(currentId++);

        String studentId = STUDENT_PREFIX + formattedString;

        this.saveStudentId(studentId);

        return studentId;
    }
}
