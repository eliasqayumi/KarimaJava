package com.example.schoolmanagementsystem.service;

import com.example.schoolmanagementsystem.model.TeacherInfo;
import com.example.schoolmanagementsystem.repository.TeacherInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherInfoService {
    private TeacherInfoRepository TeacherInfoRepository;

    public TeacherInfoService(TeacherInfoRepository TeacherInfoRepository) {
        this.TeacherInfoRepository = TeacherInfoRepository;
    }

    public List<TeacherInfo> getAll() {
        return TeacherInfoRepository.findAll();
    }

    public void insertData(TeacherInfo TeacherInfo) {
        TeacherInfoRepository.save(TeacherInfo);
    }

    public void deleteData(String id) {
        TeacherInfoRepository.deleteById(id);
    }

    public void updateData(TeacherInfo TeacherInfo) {
        TeacherInfoRepository.save(TeacherInfo);
    }
}
