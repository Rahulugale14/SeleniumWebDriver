package day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DragAndDropAction {

    public static void main (String args[]) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));

        driver.get("https://vinothqaacademy.com/mouse-event/");
        driver.manage().window().maximize();

        Actions act = new Actions(driver);

        WebElement dd1 = driver.findElement(By.xpath("//div[@id='dragItem']"));
        WebElement dd2 = driver.findElement(By.xpath("//div[@id='dropZone']"));

        act.dragAndDrop(dd1, dd2).perform();






    }

}
