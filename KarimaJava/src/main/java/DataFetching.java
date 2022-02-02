import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataFetching {
    private List<Vehicles> dataList;

    public DataFetching() {
        dataList = new ArrayList<>();
        fetchingData();
    }

    public List<Vehicles> getDataList() {
        return dataList;
    }

    public void setDataList(List<Vehicles> dataList) {
        this.dataList = dataList;
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

    public void makeRisk(MakeCoefficients makeCoefficients) {
        for (Vehicles vehicles : dataList) {
            vehicles.setAnnualFee(String.valueOf(12 * cascoAnnualFee(makeCoefficients, vehicles)));
            vehicles.setManualFee(String.valueOf(cascoAnnualFee(makeCoefficients, vehicles)));
        }
    }

    public double cascoAnnualFee(MakeCoefficients makeCoefficients, Vehicles vehicles) {
        double value = 0;
        if (makeCoefficients.getMakeCoef().containsKey(vehicles.getProducer()))
            value = makeCoefficients.getMakeCoef().get(vehicles.getProducer()) * Coefficients.VEHICLEAGE * (2021 - changer(vehicles.getFirstRegistration()));
        return value;
    }

    private int changer(String value) {
        double number = Double.valueOf(value);
        return (value == null ? 1 : (int) (number));
    }
}
