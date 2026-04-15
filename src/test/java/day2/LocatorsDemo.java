package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;
import java.util.List;

public class LocatorsDemo {

    public static void main (String args[]) {

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
        driver.get("https://demo.nopcommerce.com");
        driver.manage().window().maximize();

        //1 ----> locate element using "name"
        driver.findElement(
                By.name("q")).sendKeys("Mac");

        //2 ----> locate element using "id"
        boolean displayCurrencyLogo = driver.findElement(
                By.id("customerCurrency")).isDisplayed();
        System.out.println(displayCurrencyLogo);

        //3 ----> locate element using ""linktext" & "partilLinkTest"
        // driver.findElement(By.linkText("Computers")).click();            // use this
        // driver.findElement(By.partialLinkText("Comp")).click();           //passing small value in the text.

        //4 ----> capture multiple web-elements - CLASSNAME
        //chances of duplicate elements, so List is used instead of Set
        //List<WebElement> headerLinks = driver.findElements(By.className("menu"));
        //System.out.println("Total number of links: " + headerLinks.size());

        //5 ----> capture multiple web-elements - TAGNAME
        List<WebElement> links = driver.findElements(
                By.tagName("a"));
        System.out.println("Total number of links: " + links.size());

        List<WebElement> images = driver.findElements(
                By.tagName("img"));
        System.out.println("Total number of images: " + images.size());





    }

}
