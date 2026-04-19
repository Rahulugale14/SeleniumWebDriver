package day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class StaticTableEx1 {

    public static void main (String args[]) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        //1 ----> Find total number of rows in Static table
        //below xpath returns all the tr (tr are rows of table)
        int totalRows = driver.findElements(
                By.xpath("//table[@name='BookTable']//tr")).size();
        System.out.println("Number of rows: " + totalRows);

        //2 ----> Find total number of columns in static table
        int totalColumns = driver.findElements(
                By.xpath("//table[@name='BookTable']//th")).size();
        System.out.println("Number of columns: " + totalColumns);

        //3 ----> Read data from specific Row & Column (example: 5th row & 1st column)
        String bookName = driver.findElement(
                By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
        System.out.println("Book name is:" +  bookName);

        //4 ----> Read data from specific Row & Column (example: 7th row & 3rd column)
        String subject = driver.findElement(
                By.xpath("//table[@name='BookTable']//tr[7]//td[3]")).getText();
        System.out.println("Subject is: " + subject);

        System.out.println("-----------------------------------------------------------------");

        System.out.println("BookName" + "\t" + "Author" + "\t" + "Subject" + "\t" + "Price");       //to print header of the table

        //5 ----> Read data from all rows & columns of static table. It's possible using nested for loop
        for (int r=2; r<=totalRows; r++) {                  //r=2 bcoz counting from 2nd row
            for (int c=1; c<=totalColumns; c++) {           //c=1 bcoz counting from 1st column
                String value = driver.findElement(
                        By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText(); //xpath from 3rd step. only changes in r & c
                System.out.print(value + "\t");
            }
            System.out.println();
        }





    }

}
