package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Assignment2 {

    public static void main (String args[]) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
        List<WebElement> links = driver.findElements(By.className("nav-item"));
        System.out.println("Total number of links: " + links.size());

        //toFind total number of links
        List<WebElement> totalLinks = driver.findElements(By.tagName("a"));
        System.out.println("Total number of links on whole page: " + totalLinks.size());

        List<WebElement> totalImages = driver.findElements(By.tagName("img"));
        System.out.println("Total images on the page are: " + totalImages.size());

        Thread.sleep(5000);
        driver.findElement(By.className("card-title")).click();




    }
}
