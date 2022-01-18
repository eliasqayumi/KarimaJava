package com.example.schoolmanagementsystem.service;

import com.example.schoolmanagementsystem.model.Department;
import com.example.schoolmanagementsystem.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    public void insertData(Department department) {
        departmentRepository.save(department);
    }

    public void deleteData(String id) {
        departmentRepository.deleteById(id);
    }

    public void updateData(Department department) {
        departmentRepository.save(department);
    }
}
