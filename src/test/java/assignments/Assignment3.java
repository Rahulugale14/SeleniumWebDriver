package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Assignment3 {

    public static void main (String args[]) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        String title = driver.getTitle();
        System.out.println(title);

        System.out.println(driver.getCurrentUrl());

        String windowID = driver.getWindowHandle();
        System.out.println(windowID);

        /*
        driver.findElement(By.xpath("//a[normalize-space()='merrymoonmary']")).click();
        Set<String> windowIDs = driver.getWindowHandles();
        System.out.println("Multiple window IDs: " + windowIDs);

         */

        boolean status = driver.findElement(
                By.xpath("//a[normalize-space()='GUI Elements']")).isDisplayed();
        System.out.println("Status displayed: " + status);

        WebElement fieldSelected = driver.findElement(
                By.xpath("//input[@id='email']"));
        System.out.println("E-mail field is Selected: " + fieldSelected.isSelected());

        System.out.println("Before selecting checkbox....................");
        WebElement checkbox = driver.findElement(
                By.xpath("//input[@id='sunday']"));
        System.out.println("Checkbox is selected: " + checkbox.isSelected());
        checkbox.click();
        System.out.println("After selecting checkbox.....................");
        System.out.println("Checkbox is Selected: " + checkbox.isSelected());













    }
}
