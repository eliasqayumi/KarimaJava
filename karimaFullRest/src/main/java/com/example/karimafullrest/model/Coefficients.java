package com.example.karimafullrest.model;


public class Coefficients {
    private float vehicleAge = 1.1f;
    private float vehicleValue = 0.08f;
    private float previousIndemnity = 0.05f;

    public Coefficients(float vehicleAge, float vehicleValue, float previousIndemnity) {
        this.vehicleAge = vehicleAge;
        this.vehicleValue = vehicleValue;
        this.previousIndemnity = previousIndemnity;
    }

    public Coefficients() {
    }

    public float getVehicleAge() {
        return vehicleAge;
    }

    public void setVehicleAge(float vehicleAge) {
        this.vehicleAge = vehicleAge;
    }

    public float getVehicleValue() {
        return vehicleValue;
    }

    public void setVehicleValue(float vehicleValue) {
        this.vehicleValue = vehicleValue;
    }

    public float getPreviousIndemnity() {
        return previousIndemnity;
    }

    public void setPreviousIndemnity(float previousIndemnity) {
        this.previousIndemnity = previousIndemnity;
    }
}
