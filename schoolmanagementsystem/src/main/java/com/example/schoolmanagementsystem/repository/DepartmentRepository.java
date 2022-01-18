package com.example.schoolmanagementsystem.repository;

import com.example.schoolmanagementsystem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,String> {

}
