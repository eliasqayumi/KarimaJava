import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.xml.crypto.Data;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<Vehicles> dataList = new ArrayList<Vehicles>();

    public static void main(String[] args) {
        Main main = new Main();
        main.fetchingData();

    }

    private  void fetchingData() {
        String excelPath = "/Users/qayumi/Desktop/All_Codes/spring-security/KarimaJava/vehicles.xlsx";
        try {
            FileInputStream inputStream = new FileInputStream(excelPath);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            int rowNum = sheet.getLastRowNum();
            System.out.println(rowNum);
            int columnNum = sheet.getRow(0).getLastCellNum();
            System.out.println(columnNum);
            for (int i = 1; i < rowNum; i++) {
                dataList.add(new Vehicles(
                        String.valueOf(sheet.getRow(i).getCell(0).toString()),
                        String.valueOf(sheet.getRow(i).getCell(1).toString()),
                        String.valueOf(sheet.getRow(i).getCell(2).toString()),
                        String.valueOf(sheet.getRow(i).getCell(3).toString()),
                        String.valueOf(sheet.getRow(i).getCell(4).toString()),
                        String.valueOf(sheet.getRow(i).getCell(5).toString()),
                        String.valueOf(sheet.getRow(i).getCell(6).toString())
                ));
                System.out.println(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
