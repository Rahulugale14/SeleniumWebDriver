package day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class StaticTableEx2 {

    public static void main (String args[]) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        //1 ----> Find total number of rows in Static table
        int totalRows = driver.findElements(
                By.xpath("//table[@name='BookTable']//tr")).size();
        System.out.println("Number of rows: " + totalRows);

        //2 ----> Find total number of columns in static table
        int totalColumns = driver.findElements(
                By.xpath("//table[@name='BookTable']//th")).size();
        System.out.println("Number of columns: " + totalColumns);

        //Read data from specific Row & Column (example: 5th row & 1st column)

        /*
        String bookName = driver.findElement(
                By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
        System.out.println("Book name is:" +  bookName);

         */


        //print data from specific column only

/*
        for (int r=2; r<=totalRows; r++) {                      //prints only author names from the table
            String authorNames = driver.findElement(
                    By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();

            if (authorNames.equals("Mukesh")) {                 //prints book name & author name written by specific author
                String bookNames = driver.findElement(
                        By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
                System.out.println(bookNames + "\t" + authorNames);

            }
        }
            */


        //Find total price of all the books

        int total=0;
        for (int r=2; r<=totalRows; r++) {
            String price = driver.findElement(
                    By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[4]")).getText();
            total = total + Integer.parseInt(price);
        }
        System.out.println("Total price of Books: " + total);


    }

}
