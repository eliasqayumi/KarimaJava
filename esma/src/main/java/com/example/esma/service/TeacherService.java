package com.example.esma.service;

import com.example.esma.model.Teacher;
import com.example.esma.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository TeacherRepository) {
        this.teacherRepository = TeacherRepository;
    }

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public void insertData(Teacher Teacher) {
        teacherRepository.save(Teacher);
    }

    public void deleteData(String id) {
        teacherRepository.deleteById(id);
    }

    public void updateData(Teacher Teacher) {
        teacherRepository.save(Teacher);
    }

    public Teacher findTeacherById(String id) {
        return teacherRepository.findById(id).orElseThrow();
    }
}
