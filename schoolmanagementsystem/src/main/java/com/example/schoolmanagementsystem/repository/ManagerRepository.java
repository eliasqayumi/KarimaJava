package com.example.schoolmanagementsystem.repository;

import com.example.schoolmanagementsystem.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager,String> {
}
