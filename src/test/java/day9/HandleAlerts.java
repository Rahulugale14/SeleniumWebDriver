package day9;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandleAlerts {

    public static void main (String args []) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();



        //1 ===> Normal alert

        /*
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
        Thread.sleep(5000);                     //adding only to see alert is closed or not
        Alert myAlert = driver.switchTo().alert();
        System.out.println(myAlert.getText());                      //to get alert text or message
        myAlert.accept();

         */




        //2 ===> Confirmation alert

        /*
        driver.findElement(
                By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
        Thread.sleep(5000);                          //adding only to see alert is closed or not
        //driver.switchTo().alert().accept();             //closes alert using ok button
        //driver.switchTo().alert().dismiss();              //closes alert using cancel button
        Alert myAlert = driver.switchTo().alert();
        System.out.println(myAlert.getText());
        myAlert.dismiss();

         */




        //3 ===> prompt alert

        driver.findElement(
                By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
        Thread.sleep(5000);                          //adding only to see alert is closed or not
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Welcome to Prompt Alert");
        Thread.sleep(2000);                          //adding only to see alert is closed or not
        promptAlert.accept();






    }
}
