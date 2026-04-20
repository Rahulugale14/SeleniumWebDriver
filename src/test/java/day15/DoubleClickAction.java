package day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DoubleClickAction {

    public static void main (String args[]) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));

        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
        driver.manage().window().maximize();

        //switching to iframe. id & name attributes are directly available so passing id/name in frame()
        driver.switchTo().frame("iframeResult");

        //before coming here see above as below elements are in the iframe
        WebElement box1 = driver.findElement(
                By.xpath("//input[@id='field1']"));
        WebElement box2 = driver.findElement(
                By.xpath("//input[@id='field2']"));
        WebElement button = driver.findElement(
                By.xpath("//button[normalize-space()='Copy Text']"));

        box1.clear();           //clear existing text from website
        box1.sendKeys("Welcome to Jumanji");

        Actions act = new Actions(driver);
        //double click perform method
        act.doubleClick(button).perform();


        //validation --> to compare box2 text with box1
        if (box2.getText().equals(box1.getText())) {          //this can be (box2.getText().equals("Welcome to Jumanji") or by storing in String variable
            System.out.println("Text is copied successfully");
        }
        else {
            System.out.println("Text is not copied");
        }



    }

}
