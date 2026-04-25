package day20;
//Excel File --> WorkBook --> Sheets --> Rows --> Cells

// "C:\Users\Administrator\IdeaProjects\SeleniumWebDriver\TestData\DDTest.xlsx"

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadingExcelData {

    public static void main (String args []) throws IOException {

        //reading data from exceel sheet, use FileInputStream class
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\DDTest.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(file);

        XSSFSheet sheet = workbook.getSheet("Sheet1");   // OR -----> XSSFSheet sheet1 = workbook.getSheetAt(0);
        int totalRows = sheet.getLastRowNum();
        int totalCells = sheet.getRow(1).getLastCellNum();      //any row number here

        System.out.println("Total number of rows: " + totalRows);       //as per excel, rows are counted from 0
        System.out.println("Total number of cells: " + totalCells);     //as per excel, cells are counted from 1

        for (int r=0; r<=totalRows; r++) {     //as per java, rows count from zero, so r<=totalRows
            XSSFRow currentRow = sheet.getRow(r);  //here getting entire row & then from 2nd for loop, getting all cells

            for (int c=0; c<totalCells; c++) { //as per java, cells count from zero, but from excel it's 1, so c<totalCells
                XSSFCell cell = currentRow.getCell(c);
                System.out.print(cell.toString() + "\t");       //toString reads any datatype into String format
            }
            System.out.println();
        }
        workbook.close();
        file.close();



    }

}
