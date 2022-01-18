package com.example.schoolmanagementsystem.service;

import com.example.schoolmanagementsystem.model.ManagerInfo;
import com.example.schoolmanagementsystem.repository.ManagerInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerInfoService {
    private ManagerInfoRepository ManagerInfoRepository;

    public ManagerInfoService(ManagerInfoRepository ManagerInfoRepository) {
        this.ManagerInfoRepository = ManagerInfoRepository;
    }

    public List<ManagerInfo> getAll() {
        return ManagerInfoRepository.findAll();
    }

    public void insertData(ManagerInfo ManagerInfo) {
        ManagerInfoRepository.save(ManagerInfo);
    }

    public void deleteData(String id) {
        ManagerInfoRepository.deleteById(id);
    }

    public void updateData(ManagerInfo ManagerInfo) {
        ManagerInfoRepository.save(ManagerInfo);
    }
}
