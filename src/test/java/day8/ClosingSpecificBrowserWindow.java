package day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class ClosingSpecificBrowserWindow {

    public static void main (String args[]) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));

        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        driver.findElement(
                By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();

        Set<String> windowIDs = driver.getWindowHandles();

        for (String winID : windowIDs) {
            String title = driver.switchTo().window(winID).getTitle();
            System.out.println(title);

            if (title.equals("OrangeHRM: All in One HR Software for Businesses")) { //closing child browser. Use || here to close multiple browsers
                driver.close();
                break;                      //use only when need to exit after clearing browser.
            }
        }

    }

}
