package day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandleFrames {

    public static void main (String args[]) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));

        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().window().maximize();


        //switching to iframe for accessing webelement
        //frame1
        WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
        driver.switchTo().frame(frame1);                //passed frame as a webelement-> this switches to frame1
        driver.findElement(
                By.xpath("//input[@name='mytext1']")).sendKeys("welcome");


        driver.switchTo().defaultContent();         //this moves back to page

        //frame2
        WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
        driver.switchTo().frame(frame2);
        driver.findElement(
                By.xpath("//input[@name='mytext2']")).sendKeys("Selenium");


        driver.switchTo().defaultContent();         //this moves back to page

        //frame3
        WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
        driver.switchTo().frame(frame3);
        driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Java");

        //inner iframe -> part of frame3
        driver.switchTo().frame(0);     //switching to frame using index
        //found below xpath after opening inner iframe website from DOM itself
        driver.findElement(By.xpath("//div[@id='i9']//div[@class='AB7Lab Id5V1']")).click();



        driver.switchTo().defaultContent();         //this moves back to page

    }

}
