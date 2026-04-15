package day9;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//===> handle alert without using switchTo().alert()
//===> handle alert using explicit wait


public class HandleAlertUsingExplicitWait {

    public static void main (String args []) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10000));

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();


        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
        Thread.sleep(5000);                                     //adding only to see alert is closed or not

        Alert myAlert = myWait.until(ExpectedConditions.alertIsPresent());
        //Alert myAlert = driver.switchTo().alert();                        //used above instead of this due to explicit waits
        System.out.println(myAlert.getText());                            //to get alert text or message
        myAlert.accept();





    }
}
