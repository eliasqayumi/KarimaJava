package com.example.karimafullrest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicles {
    @Id
    private String plateNumber;
    private int firstRegistration;
    private double purchasePrice;
    private String producer;
    private double mileage;
    private double previewsIndemnity;
}
