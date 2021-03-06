package com.example.karimafullrest.controller;

import com.example.karimafullrest.model.Data;
import com.example.karimafullrest.model.DataFile;
import com.example.karimafullrest.model.Vehicles;
import com.example.karimafullrest.service.DataFileService;
import com.example.karimafullrest.service.VehiclesService;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ApplicationController {
    private VehiclesService vehiclesService;

    public ApplicationController(VehiclesService vehiclesService) {
        this.vehiclesService = vehiclesService;
    }

    @PostMapping("/post")
    public void post() {
        List<Vehicles> dataList = new ArrayList<>();
        String excelPath = "/Users/qayumi/Desktop/All_Codes/spring-security/KarimaJava/vehicles.xlsx";
        try {
            FileInputStream inputStream = new FileInputStream(excelPath);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            int rowNum = sheet.getLastRowNum();
            System.out.println(rowNum);
            int columnNum = sheet.getRow(0).getLastCellNum();
            System.out.println(columnNum);
            for (int i = 1; i < 5000; i++) {
                Vehicles vehicle = new Vehicles(
                        String.valueOf(sheet.getRow(i).getCell(0).toString()),
                        String.valueOf(sheet.getRow(i).getCell(1).toString()),
                        String.valueOf(sheet.getRow(i).getCell(2).toString()),
                        String.valueOf(sheet.getRow(i).getCell(3).toString()),
                        String.valueOf(sheet.getRow(i).getCell(4).toString()),
                        String.valueOf(sheet.getRow(i).getCell(5).toString()),
                        String.valueOf(sheet.getRow(i).getCell(6).toString())
                );
                vehiclesService.save(vehicle);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/getAll")
    public List<Vehicles> getAll() {
        return vehiclesService.finAll();
    }

}
