package com.example.schoolmanagementsystem.service;

import com.example.schoolmanagementsystem.model.Subject;
import com.example.schoolmanagementsystem.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    private SubjectRepository SubjectRepository;

    public SubjectService(SubjectRepository SubjectRepository) {
        this.SubjectRepository = SubjectRepository;
    }

    public List<Subject> getAll() {
        return SubjectRepository.findAll();
    }

    public void insertData(Subject Subject) {
        SubjectRepository.save(Subject);
    }

    public void deleteData(String id) {
        SubjectRepository.deleteById(id);
    }

    public void updateData(Subject Subject) {
        SubjectRepository.save(Subject);
    }
}
