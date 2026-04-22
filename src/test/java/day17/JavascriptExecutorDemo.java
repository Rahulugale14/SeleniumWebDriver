package day17;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JavascriptExecutorDemo {

    public static void main (String args[]) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        WebElement inputBox = driver.findElement(
                By.xpath("//input[@id='name']"));

        //below is alternate for sendKeys(). Use below one when Element Intercepted Exception is thrown
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('value', 'John Wick')", inputBox);

        WebElement radioButton = driver.findElement(
                By.xpath("//input[@id='male']"));
        //below is used instead of simply click() after xpath
        js.executeScript("arguments[0].click()", radioButton);

    }

}
