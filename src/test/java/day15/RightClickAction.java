package day15;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class RightClickAction {

    public static void main (String args[]) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));

        driver.get("https://vinothqaacademy.com/mouse-event/");
        driver.manage().window().maximize();

        WebElement rightButton = driver.findElement(
                By.xpath("//button[@id='rightBtn']"));
        Actions act = new Actions(driver);
        //rightClick action
        act.contextClick(rightButton).perform();

        //click on COPY option from right click
        driver.findElement(
                By.xpath("//button[normalize-space()='Copy']")).click();



    }

}
