package com.da.studentmanagement.repository.student;

import com.da.studentmanagement.repository.filedata.IBaseFileData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentIdData implements IBaseFileData<String> {
    private final String filePath;

    public StudentIdData(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void saveToFile(List<String> studentIds) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.filePath))) {
            for (String studentId : studentIds) {
                writer.write(studentId);
                writer.newLine();
            }
            System.out.println("CSV file written successfully!");
        } catch (IOException e) {
            System.err.println("Error writing CSV file: " + e.getMessage());
        }
    }

    @Override
    public List<String> loadFromFile() {
        List<String> studentIds = new ArrayList<>();
        try {
            try (InputStream is = StudentData.class.getClassLoader().getResourceAsStream(this.filePath);
                 BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                String line;
                while ((line = br.readLine()) != null) {
                    studentIds.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return studentIds;
    }
}
