package com.example.esma.repository;

import com.example.esma.model.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentInfoRepository extends JpaRepository<StudentInfo, String> {
}
