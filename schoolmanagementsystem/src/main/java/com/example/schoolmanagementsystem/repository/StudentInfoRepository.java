package com.example.schoolmanagementsystem.repository;

import com.example.schoolmanagementsystem.model.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentInfoRepository extends JpaRepository<StudentInfo,String> {

}
