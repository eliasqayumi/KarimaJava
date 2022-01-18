package com.example.schoolmanagementsystem.model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class ManagerInfoId implements Serializable {
    private static final long serialVersionUID = -3187599263316664541L;
    @Column(name = "managerId", nullable = false, length = 10)
    private String managerId;
    @Column(name = "record", nullable = false)
    private LocalDate record;
    @Column(name = "departmentId", nullable = false, length = 10)
    private String departmentId;

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

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(record, departmentId, managerId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ManagerInfoId entity = (ManagerInfoId) o;
        return Objects.equals(this.record, entity.record) &&
                Objects.equals(this.departmentId, entity.departmentId) &&
                Objects.equals(this.managerId, entity.managerId);
    }
}