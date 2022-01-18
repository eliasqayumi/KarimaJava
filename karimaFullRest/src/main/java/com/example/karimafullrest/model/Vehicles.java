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
    private String id;
    private String plateNumber;
    private String firstRegistration;
    private String purchasePrice;
    private String producer;
    private String mileage;
    private String previewsIndemnity;
}
