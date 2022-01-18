package com.example.schoolmanagementsystem.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student_info")
public class StudentInfo {
    @EmbeddedId
    private StudentInfoId id;

    public StudentInfoId getId() {
        return id;
    }

    public void setId(StudentInfoId id) {
        this.id = id;
    }
}