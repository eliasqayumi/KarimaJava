package com.example.esma.service;

import com.example.esma.model.Manager;
import com.example.esma.repository.ManagerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
    private ManagerRepository managerRepository;

    public ManagerService(ManagerRepository ManagerRepository) {
        this.managerRepository = ManagerRepository;
    }

    public List<Manager> findAll() {
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

