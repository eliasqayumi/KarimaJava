package com.example.esma.service;

import com.example.esma.model.TeacherInfo;
import com.example.esma.repository.TeacherInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherInfoService {
    private TeacherInfoRepository teacherInfoRepository;

    public TeacherInfoService(TeacherInfoRepository TeacherInfoRepository) {
        this.teacherInfoRepository = TeacherInfoRepository;
    }

    public List<TeacherInfo> findAll() {
        return teacherInfoRepository.findAll();
    }

    public void insertData(TeacherInfo TeacherInfo) {
        teacherInfoRepository.save(TeacherInfo);
    }

    public void deleteData(String id) {
        teacherInfoRepository.deleteById(id);
    }

    public void updateData(TeacherInfo TeacherInfo) {
        teacherInfoRepository.save(TeacherInfo);
    }

    public TeacherInfo findTeacherInfoById(String id) {
        return teacherInfoRepository.findById(id).orElseThrow();
    }
}
