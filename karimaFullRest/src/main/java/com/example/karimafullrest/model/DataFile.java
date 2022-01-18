package com.example.karimafullrest.model;

import org.springframework.context.annotation.Configuration;

public class DataFile {
   private Data data;

    public DataFile(Data data) {
        this.data = data;
    }

    public DataFile() {
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
