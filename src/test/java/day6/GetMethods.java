package day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class GetMethods {

    public static void main (String args[]) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        // get URL
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(5000);

        //get Title
        System.out.println(driver.getTitle());

        //get Current URL
        System.out.println(driver.getCurrentUrl());

        //get pageSource
        //System.out.println(driver.getPageSource());

        //get Window Handle --> return ID of single browser windows
        String windowId = driver.getWindowHandle();
        System.out.println("Window ID is: " + windowId);

        //get Window Handles --> return IDs of multiple browser windows
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();
        Set<String> windowIDs = driver.getWindowHandles();
        System.out.println("Multiple window IDs: " + windowIDs);











    }
}
