package com.example.karimafullrest.service;

import com.example.karimafullrest.model.Vehicles;
import com.example.karimafullrest.repository.VehiclesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class VehiclesService {
    private final VehiclesRepo vehiclesRepo;

    public VehiclesService(VehiclesRepo vehiclesRepo) {
        this.vehiclesRepo = vehiclesRepo;
    }

    public List<Vehicles> finAll(){
        return vehiclesRepo.findAll();
    }
    public void save(Vehicles vehicles){
        vehiclesRepo.save(vehicles);
    }

}
