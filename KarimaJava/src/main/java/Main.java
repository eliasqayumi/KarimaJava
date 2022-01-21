import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.xml.crypto.Data;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private List<Vehicles> dataList = new ArrayList<Vehicles>();
    private Map<Vehicles,Double>  vehiclesDoubleMap= new HashMap<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.fetchingData();
        MakeCoefficients makeCoefficients = new MakeCoefficients();
        main.makeRisk(makeCoefficients);
        for(Vehicles vehicles: main.dataList) {
            System.out.println("Plate Number "+vehicles.getPlateNumber()+" Producer "+vehicles.getProducer()+" Annual fee "+main.vehiclesDoubleMap.get(vehicles));;
        }
    }

    public void makeRisk(MakeCoefficients makeCoefficients) {
        for (Vehicles vehicles : dataList) {
            vehiclesDoubleMap.put(vehicles,cascoAnnualFee(makeCoefficients,vehicles));
        }
    }
    public double cascoAnnualFee(MakeCoefficients makeCoefficients,Vehicles vehicles){
        double value=0;
        if (makeCoefficients.getMakeCoef().containsKey(vehicles.getProducer()))
            value= 12*makeCoefficients.getMakeCoef().get(vehicles.getProducer())*Coefficients.VEHICLEAGE*(2021-changer(vehicles.getFirstRegistration()));
        return value;
    }
    private int changer(String value){
        double number= Double.valueOf(value);

        return (value==null? 1:(int)(number));
    }

    private void fetchingData() {
        String excelPath = "/Users/qayumi/Desktop/All_Codes/spring-security/KarimaJava/vehicles.xlsx";
        try {
            FileInputStream inputStream = new FileInputStream(excelPath);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            int rowNum = sheet.getLastRowNum();
            int columnNum = sheet.getRow(0).getLastCellNum();
            for (int i = 1; i < 100; i++) {
                dataList.add(new Vehicles(
                        String.valueOf(sheet.getRow(i).getCell(0).toString()),
                        String.valueOf(sheet.getRow(i).getCell(1).toString()),
                        String.valueOf(sheet.getRow(i).getCell(2).toString()),
                        String.valueOf(sheet.getRow(i).getCell(3).toString()),
                        String.valueOf(sheet.getRow(i).getCell(4).toString()),
                        String.valueOf(sheet.getRow(i).getCell(5).toString()),
                        String.valueOf(sheet.getRow(i).getCell(6).toString())
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
