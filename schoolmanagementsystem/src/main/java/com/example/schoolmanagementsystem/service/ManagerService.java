package com.example.schoolmanagementsystem.service;

import com.example.schoolmanagementsystem.model.Manager;
import com.example.schoolmanagementsystem.repository.ManagerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
    private ManagerRepository managerRepository;

    public ManagerService(ManagerRepository ManagerRepository) {
        this.managerRepository = ManagerRepository;
    }

    public List<Manager> getAll() {
        return managerRepository.findAll();
    }

    public void insertData(Manager Manager) {
        managerRepository.save(Manager);
    }

    public void deleteData(String id) {
        managerRepository.deleteById(id);
    }

    public void updateData(Manager Manager) {
        managerRepository.save(Manager);
    }
}

