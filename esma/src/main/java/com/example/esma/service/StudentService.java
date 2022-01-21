package com.example.esma.service;

import com.example.esma.model.Student;
import com.example.esma.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository StudentRepository) {
        this.studentRepository = StudentRepository;
    }

    public List<Student> findAll() {
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

    public Student findStudentById(String id) {
        return studentRepository.findById(id).orElseThrow();
    }
}
