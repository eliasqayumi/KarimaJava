package com.example.schoolmanagementsystem.repository;

import com.example.schoolmanagementsystem.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,String> {
}
