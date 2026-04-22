package day17;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ScrollingPage {

    public static void main (String args[]) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor)driver;

        //1) ---> scroll down page by pixel number
        //js.executeScript("window.scrollBy(0, 1500)", "");
        //System.out.println("return window.pageYOffset");

        //2) ---> scroll down page till the element is visible
        //WebElement testElement = driver.findElement(By.xpath("//h2[normalize-space()='Pagination Web Table']"));
        //js.executeScript("arguments[0].scrollInToView();", testElement);
        //System.out.println("return window.pageYOffset");

        //3) ---> scroll page till end of the page
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
        System.out.println("return window.pageYOffset");

        Thread.sleep(5000);

        //4) ---> scrolling upto initial position
        js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");








    }

}
