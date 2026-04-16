package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Assignment6 {

    public static void main (String args[]) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));

        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().window().maximize();

        WebElement frame5 = driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
        driver.switchTo().frame(frame5);
        driver.findElement(
                By.xpath("//input[@name='mytext5']")).sendKeys("Tesla");

        driver.switchTo().defaultContent();
        driver.switchTo().frame(frame5);
        driver.findElement(
                By.xpath("//a[normalize-space()='https://a9t9.com']")).click();  //xpath from Selector hub. CSS also works


        System.out.println(driver.getTitle());

        //verify image is displayed or not
        WebElement img = driver.findElement(
                By.xpath("//img[@alt='Ui.Vision by a9t9 software - Image-Driven Automation']"));
        System.out.println(img.isDisplayed());

        //finding total links
        List<WebElement> links = driver.findElements(By.tagName("div"));
        System.out.println("Total number of links: " + links.size());









    }

}

