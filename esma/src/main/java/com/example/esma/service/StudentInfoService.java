package com.example.esma.service;

import com.example.esma.model.StudentInfo;
import com.example.esma.repository.StudentInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentInfoService {
    private StudentInfoRepository studentInfoRepository;

    public StudentInfoService(StudentInfoRepository StudentInfoRepository) {
        this.studentInfoRepository = StudentInfoRepository;
    }

    public List<StudentInfo> findAll() {
        return studentInfoRepository.findAll();
    }

    public void insertData(StudentInfo StudentInfo) {
        studentInfoRepository.save(StudentInfo);
    }

    public void deleteData(String id) {
        studentInfoRepository.deleteById(id);
    }

    public void updateData(StudentInfo StudentInfo) {
        studentInfoRepository.save(StudentInfo);
    }

    public StudentInfo findStudentInfoById(String id) {
        return studentInfoRepository.findById(id).orElseThrow();
    }
}
