package com.example.schoolmanagementsystem.service;

import com.example.schoolmanagementsystem.model.Student;
import com.example.schoolmanagementsystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository StudentRepository) {
        this.studentRepository = StudentRepository;
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public void insertData(Student Student) {
        studentRepository.save(Student);
    }

    public void deleteData(String id) {
        studentRepository.deleteById(id);
    }

    public void updateData(Student Student) {
        studentRepository.save(Student);
    }
}
