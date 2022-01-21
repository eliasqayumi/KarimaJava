package com.example.esma.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "manager_info")
public class ManagerInfo {
    @EmbeddedId
    private ManagerInfoId id;
}