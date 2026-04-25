package day20;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

//Excel File --> WorkBook --> Sheets --> Rows --> Cells

public class WritingDataInSpecificRowAndCell {

    public static void main (String args[] ) throws IOException {

        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\myfile_random.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Data");

        //creating random rows
        XSSFRow row =  sheet.createRow(3);
        XSSFCell cell = row.createCell(4);
        cell.setCellValue("Hello World");

        XSSFRow row1 =  sheet.createRow(1);
        XSSFCell cell1 = row.createCell(1);
        cell1.setCellValue("Java");

        workbook.write(file);
        workbook.close();
        file.close();

        System.out.println("File is created");



    }
}
