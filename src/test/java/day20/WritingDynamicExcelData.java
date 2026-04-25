package day20;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

//Excel File --> WorkBook --> Sheets --> Rows --> Cells

public class WritingDynamicExcelData {

    public static void main (String args[] ) throws IOException {

        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\myfile_dynamic.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("DynamicData");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many rows?");
        int noOfRows = sc.nextInt();
        System.out.println("Enter how many cells?");
        int noOfCells = sc.nextInt();


        for (int r=0; r<=noOfRows; r++) {           //first we need to create rows
            XSSFRow currentRow = sheet.createRow(r);

            for (int c=0; c<noOfCells; c++) {
                XSSFCell cell = currentRow.createCell(c);
                cell.setCellValue(sc.next());      //for user to enter hardcode value from console. next accepts all form of datatypes
            }

        }

        workbook.write(file);           //attach workbook to the file
        workbook.close();
        file.close();

        System.out.println("File is created");


    }
}
