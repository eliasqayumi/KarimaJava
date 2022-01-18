package com.example.schoolmanagementsystem.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "manager_info")
public class ManagerInfo {
    @EmbeddedId
    private ManagerInfoId id;

    public ManagerInfoId getId() {
        return id;
    }

    public void setId(ManagerInfoId id) {
        this.id = id;
    }
}