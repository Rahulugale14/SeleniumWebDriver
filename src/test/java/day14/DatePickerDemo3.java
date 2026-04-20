package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DatePickerDemo3 {

    static void selectFutureDate (WebDriver driver, String month, String year, String date) {
        //now selecting month & year
        while(true) {
            String currentMonth = driver.findElement(
                    By.xpath("//span[@class='ui-datepicker-month']")).getText();     //actual month
            String currentYear = driver.findElement(
                    By.xpath("//span[@class='ui-datepicker-year']")).getText();  //actualYear

            if (currentMonth.equals(month) && currentYear.equals(year)) {
                break;
            }
            driver.findElement(
                    By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); //clicking on arrow for next month
        }

        //selectingDate
        List<WebElement> allDates = driver.findElements(
                By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
        for (WebElement dt : allDates) {
            if (dt.getText().equals(date)) {
                dt.click();
            }
        }

    }

    static void selectPastDate (WebDriver driver, String month, String year, String date) {
        //now selecting month & year
        while(true) {
            String currentMonth = driver.findElement(
                    By.xpath("//span[@class='ui-datepicker-month']")).getText();     //actual month
            String currentYear = driver.findElement(
                    By.xpath("//span[@class='ui-datepicker-year']")).getText();  //actualYear

            if (currentMonth.equals(month) && currentYear.equals(year)) {
                break;
            }
            driver.findElement(
                    By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); //clicking on arrow for next month
        }

        //selectingDate
        List<WebElement> allDates = driver.findElements(
                By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
        for (WebElement dt : allDates) {
            if (dt.getText().equals(date)) {
                dt.click();
            }
        }

    }


    public static void main (String args[]) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));

        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();

        //switching frame as date is inside the frame
        driver.switchTo().frame(0);

        // Method1 ---> using sendKeys ()
        //driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("05/14/2026");

        // Method 2 ----> using date picker
        driver.findElement(
                By.xpath("//input[@id='datepicker']")).click();

        selectPastDate(driver, "May", "2024", "14");
        //selectFutureDate(driver, month, year, date);

        }

}


