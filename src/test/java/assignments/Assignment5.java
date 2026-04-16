package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Assignment5 {

    public static void main (String args[]) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        List<WebElement> checkboxes = driver.findElements(
                By.xpath("//table[@id='productTable']//input[@type='checkbox']"));


        //selecting first 3 checkboxes & deselecting those
        for (int i=0; i<3; i++) {
            checkboxes.get(i).click();
        }

        for (int i=0; i<=3; i++) {
            if (checkboxes.get(i).isSelected()) {
                checkboxes.get(i).click();
            }
        }





    }

}
