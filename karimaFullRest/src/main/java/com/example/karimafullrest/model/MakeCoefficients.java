package com.example.karimafullrest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

public class MakeCoefficients {
    private float volvo = 0.96f;
    private float tatra = 0.85f;
    private float subaru= 1.2f;
    private float bmw=1.3f;
    private float porsche= 1.2f;
    private float tesla=11f;

    public MakeCoefficients(float volvo, float tatra, float subaru, float bmw, float porsche, float tesla) {
        this.volvo = volvo;
        this.tatra = tatra;
        this.subaru = subaru;
        this.bmw = bmw;
        this.porsche = porsche;
        this.tesla = tesla;
    }

    public MakeCoefficients() {
    }

    public float getVolvo() {
        return volvo;
    }

    public void setVolvo(float volvo) {
        this.volvo = volvo;
    }

    public float getTatra() {
        return tatra;
    }

    public void setTatra(float tatra) {
        this.tatra = tatra;
    }

    public float getSubaru() {
        return subaru;
    }

    public void setSubaru(float subaru) {
        this.subaru = subaru;
    }

    public float getBmw() {
        return bmw;
    }

    public void setBmw(float bmw) {
        this.bmw = bmw;
    }

    public float getPorsche() {
        return porsche;
    }

    public void setPorsche(float porsche) {
        this.porsche = porsche;
    }

    public float getTesla() {
        return tesla;
    }

    public void setTesla(float tesla) {
        this.tesla = tesla;
    }
}
