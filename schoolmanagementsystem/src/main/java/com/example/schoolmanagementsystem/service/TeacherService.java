package com.example.schoolmanagementsystem.service;

import com.example.schoolmanagementsystem.model.Teacher;
import com.example.schoolmanagementsystem.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private TeacherRepository TeacherRepository;

    public TeacherService(TeacherRepository TeacherRepository) {
        this.TeacherRepository = TeacherRepository;
    }

    public List<Teacher> getAll() {
        return TeacherRepository.findAll();
    }

    public void insertData(Teacher Teacher) {
        TeacherRepository.save(Teacher);
    }

    public void deleteData(String id) {
        TeacherRepository.deleteById(id);
    }

    public void updateData(Teacher Teacher) {
        TeacherRepository.save(Teacher);
    }
}
