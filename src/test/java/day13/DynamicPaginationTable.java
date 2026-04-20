package day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DynamicPaginationTable {

    public static void main (String args[]) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));

        driver.get("https://demo.opencart.com/admin/index.php");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(
                By.xpath("//input[@id='input-username']"));
        username.click();
        username.sendKeys("demo");

        WebElement password = driver.findElement(
                By.xpath("//input[@id='input-password']"));
        password.click();
        password.sendKeys("demo");

        driver.findElement(
                By.xpath("//button[normalize-space()='Login']")).click();

        //close window if it's applicable
        if (driver.findElement(
                By.xpath("//button[@class='btn-close']")).isDisplayed()) {
            driver.findElement(
                    By.xpath("//button[@class='btn-close']")).click();
        }

        driver.findElement(
                By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();
        driver.findElement(
                By.xpath("//ul[@id='collapse-5']//acontains(text(),'customers')]")).click();

        //showing 1 to 10 of 19081 (1909 Pages)
        String text = driver.findElement(
                By.xpath("//div[contains(text),'Pages']")).getText();
        int totalPages = Integer.parseInt(text.substring(text.indexOf("(") + 1, text.indexOf("Pages")-1));

        //repeating pages
        for (int p=0; p<=5; p++) {
            if (p>1) {
                WebElement activePage = driver.findElement(
                        By.xpath("//ul[@class-'Pagination]//*[text()="+p+"]"));
                activePage.click();
                Thread.sleep(3000);
            }
            //reading data from page
            int numOfRows = driver.findElements(
                    By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
            for (int r=0; r<=numOfRows; r++) {
                String customerName = driver.findElement(
                        By.xpath("//table[@class='table table-bordered table-hover]//tbody//tr["+r+"]//td[2]")).getText();
                String emailAdd = driver.findElement(
                        By.xpath("//table[@class='table table-bordered table-hover]//tbody//tr["+r+"]//td[3]")).getText();
                String status = driver.findElement(
                        By.xpath("//table[@class='table table-bordered table-hover]//tbody//tr["+r+"]//td[5]")).getText();
                System.out.println(customerName + "\t" + emailAdd + "\t" + status);
            }

        }


    }

}
