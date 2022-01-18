package com.example.schoolmanagementsystem.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "teacher_info")
public class TeacherInfo {
    @EmbeddedId
    private TeacherInfoId id;

    public TeacherInfoId getId() {
        return id;
    }

    public void setId(TeacherInfoId id) {
        this.id = id;
    }
}