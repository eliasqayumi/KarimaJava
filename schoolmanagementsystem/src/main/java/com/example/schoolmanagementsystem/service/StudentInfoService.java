package com.example.schoolmanagementsystem.service;

import com.example.schoolmanagementsystem.model.StudentInfo;
import com.example.schoolmanagementsystem.repository.StudentInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentInfoService {
    private StudentInfoRepository StudentInfoRepository;

    public StudentInfoService(StudentInfoRepository StudentInfoRepository) {
        this.StudentInfoRepository = StudentInfoRepository;
    }

    public List<StudentInfo> getAll() {
        return StudentInfoRepository.findAll();
    }

    public void insertData(StudentInfo StudentInfo) {
        StudentInfoRepository.save(StudentInfo);
    }

    public void deleteData(String id) {
        StudentInfoRepository.deleteById(id);
    }

    public void updateData(StudentInfo StudentInfo) {
        StudentInfoRepository.save(StudentInfo);
    }
}
