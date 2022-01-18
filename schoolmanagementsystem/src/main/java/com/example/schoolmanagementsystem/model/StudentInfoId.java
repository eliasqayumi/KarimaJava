package com.example.schoolmanagementsystem.model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class StudentInfoId implements Serializable {
    private static final long serialVersionUID = -1006371343197044916L;
    @Column(name = "studentId", nullable = false, length = 10)
    private String studentId;
    @Column(name = "record", nullable = false)
    private LocalDate record;
    @Column(name = "departmentId", nullable = false, length = 10)
    private String departmentId;
    @Column(name = "class", nullable = false, length = 5)
    private String _class;

    public String get_class() {
        return _class;
    }

    public void set_class(String _class) {
        this._class = _class;
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

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, record, departmentId, _class);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        StudentInfoId entity = (StudentInfoId) o;
        return Objects.equals(this.studentId, entity.studentId) &&
                Objects.equals(this.record, entity.record) &&
                Objects.equals(this.departmentId, entity.departmentId) &&
                Objects.equals(this._class, entity._class);
    }
}