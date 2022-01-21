package com.example.esma.service;

import com.example.esma.model.Department;
import com.example.esma.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> findAll() {
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

    public Department findById(String id) {
        return departmentRepository.findById(id).orElseThrow();
    }
}
