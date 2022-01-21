package com.example.esma.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "teacher_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
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