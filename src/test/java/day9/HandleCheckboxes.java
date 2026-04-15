package day9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandleCheckboxes {

    public static void main (String args[]) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        //1 =======> Select specific checkbox
        //driver.findElement(By.xpath("//input[@id='sunday']")).click();


        //2 =======> Selecting all checkboxes one by one
        List<WebElement> checkboxes = driver.findElements(
                By.xpath("//input[@class='form-check-input' and @type='checkbox']"));

        //using for loop
        /*
        for (int i=0; i<checkboxes.size(); i++) {
            checkboxes.get(i).click();
        }
         */


        //using enhanced for loop -- no indexing so any 3 or random checkboxes are not selected. all are selected
        /*

        for (WebElement checkbox : checkboxes) {
            checkbox.click();
        }
         */



        //3 =======> select last 3 checkboxes
        //          total no of checkboxes (counts from 0 index) - how many checkboxes want to select
        //          7-3 = 4 to select
        /*

        for (int i = 4; i<checkboxes.size(); i++) {
            checkboxes.get(i).click();
        }
         */



        //4 =======> select first 3 checkboxes
        /*

        for (int i=0; i<3; i++) {
            checkboxes.get(i).click();
        }

         */




        //5 =======> unselect checkboxes if they are selected
        for (int i=0; i<3; i++) {
            checkboxes.get(i).click();
        }

        Thread.sleep(5000);

        for (int i=0; i<checkboxes.size(); i++) {
            if (checkboxes.get(i).isSelected()) {
                    checkboxes.get(i).click();
            }
        }






    }
}
