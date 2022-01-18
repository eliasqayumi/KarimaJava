package com.example.schoolmanagementsystem.model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class TeacherInfoId implements Serializable {
    private static final long serialVersionUID = 3557535756056405158L;
    @Column(name = "teacherId", nullable = false, length = 10)
    private String teacherId;
    @Column(name = "record", nullable = false)
    private LocalDate record;
    @Column(name = "departmentId", nullable = false, length = 10)
    private String departmentId;
    @Column(name = "subjectId", nullable = false, length = 10)
    private String subjectId;

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public LocalDate getRecord() {
        return record;
    }

    public void setRecord(LocalDate record) {
        this.record = record;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, record, departmentId, subjectId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TeacherInfoId entity = (TeacherInfoId) o;
        return Objects.equals(this.teacherId, entity.teacherId) &&
                Objects.equals(this.record, entity.record) &&
                Objects.equals(this.departmentId, entity.departmentId) &&
                Objects.equals(this.subjectId, entity.subjectId);
    }
}