package com.example.karimafullrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApplicationController {

    private DataService dataService;


    @Autowired
    public ApplicationController(DataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping("/save")
    public void createData(@RequestBody Object data) {
        System.out.println(data.toString());

    }

    @GetMapping("/")
    public DataService getAllData() {
        return dataService;
    }

}
