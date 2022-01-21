package com.example.esma.service;

import com.example.esma.model.Subject;
import com.example.esma.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    private SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository SubjectRepository) {
        this.subjectRepository = SubjectRepository;
    }

    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    public void insertData(Subject Subject) {
        subjectRepository.save(Subject);
    }

    public void deleteData(String id) {
        subjectRepository.deleteById(id);
    }

    public void updateData(Subject Subject) {
        subjectRepository.save(Subject);
    }

    public Subject findSubjectById(String id) {
        return subjectRepository.findById(id).orElseThrow();
    }
}
