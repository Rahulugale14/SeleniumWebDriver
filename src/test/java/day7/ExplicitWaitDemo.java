package day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitDemo {

    public static void main (String args[]) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        //Step1 ---> declaring explicit wait
        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        //Step2 ---> use of explicit wait
        WebElement textUsername = myWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Username']")));
        textUsername.sendKeys("Admin");

        WebElement textPassword = myWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Password']")));
        textPassword.sendKeys("admin123");

        WebElement loginButton = myWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[normalize-space()='Login']")));
        loginButton.click();





    }
}
