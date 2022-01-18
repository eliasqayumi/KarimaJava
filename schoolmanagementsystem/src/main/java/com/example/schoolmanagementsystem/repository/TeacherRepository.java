package com.example.schoolmanagementsystem.repository;

import com.example.schoolmanagementsystem.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,String> {
}
