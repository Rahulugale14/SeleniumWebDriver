package day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MouseHoverAction {

    public static void main (String args[]) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));

        driver.get("https://vinothqaacademy.com/mouse-event/");
        driver.manage().window().maximize();

        WebElement demoSite = driver.findElement(
                By.xpath("//div[@class='collapse navbar-collapse pull-right']//a[contains(text(),'Demo Sites')]"));
        WebElement htc = driver.findElement(
                By.xpath("//div[@class='collapse navbar-collapse pull-right']//a[normalize-space()='Healthcare Demo Page']"));

        Actions act = new Actions(driver);
        //mouse hover
        act.moveToElement(demoSite).moveToElement(htc).click().build().perform();
        //OR     act.moveToElement(demoSite).moveToElement(htc).perform();


    }

}
