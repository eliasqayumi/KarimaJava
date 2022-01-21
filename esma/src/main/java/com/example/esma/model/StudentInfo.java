package com.example.esma.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student_info")
public class StudentInfo {
    @Id
    @Column(name = "studentId", nullable = false, length = 10)
    private String studentId;
    @Column(name = "record", nullable = false)
    private LocalDate record;
    @Column(name = "departmentId", nullable = false, length = 10)
    private String departmentId;
    @Column(name = "class", nullable = false, length = 5)
    private String _class;

}