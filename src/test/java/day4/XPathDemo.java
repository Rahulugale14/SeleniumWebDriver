package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;

public class XPathDemo {

    public static void main (String args[]) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--start-maximized");
        options.setExperimentalOption("excludeSwitches",
                Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);

        // Also add this after driver creation:
        ((JavascriptExecutor)driver).executeScript(
                "Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");



        //************ MY PROGRAM STARTS HERE..... above is to eliminate blocking website issues******************

        //WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);

        //XPath with single attribute
        // driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("T-Shirts");

        //XPath with multiple attribute
        //driver.findElement(By.xpath("//input[@name='search'][@placeholder='Search']")).sendKeys("T-Shirts");

        //XPath with "and" & "or" operators
        //driver.findElement(By.xpath("//input[@name='search' and @placeholder='Search']")).sendKeys("T-Shirts");
        //OR
        //driver.findElement(By.xpath("//input[@name='search' or @placeholder='Search']")).sendKeys("T-Shirts");

        //xpath using innerText
        //driver.findElement(By.xpath("//*[text()='MacBook']")).click();

        //capture text
        /*

        boolean displayStatus = driver.findElement(By.xpath("//*[text()='Featured']")).isDisplayed();
        System.out.println(displayStatus);
        String textValue = driver.findElement(By.xpath("//*[text()='Featured']")).getText();
        System.out.println(textValue);
         */

        //xpath using contains() method
        //driver.findElement(By.xpath("//input[contains(@placeholder,'Sea')]")).sendKeys("T-Shirts");

        //xpath using starts-wth() method
        driver.findElement(
                By.xpath("//input[starts-with(@placeholder,'Sea')]")).sendKeys("T-Shirts");

        Thread.sleep(5000);

        //xpath - chained xpath --> combines relative & absolute xpaths
        boolean imageStatus =driver.findElement(
                By.xpath("//div[@id='logo']/a/img")).isDisplayed();
        System.out.println(imageStatus);


    }
}
