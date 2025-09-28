package com.da.studentmanagement.repository.filedata;


import java.util.List;

public interface IBaseFileData<T> {
    void saveToFile(List<T> data);

    List<T> loadFromFile();
}
