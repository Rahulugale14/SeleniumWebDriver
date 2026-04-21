package day16;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TabsAndWindows {

    public static void main (String args[]) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));

        driver.get("https://automationtesting.in/");

        //below newWindow is from Selenium4.x
        //driver.switchTo().newWindow(WindowType.TAB);                  //opens new tab
        driver.switchTo().newWindow(WindowType.WINDOW);                 //opens new browser window

        driver.get("https://orangehrm.com/");




    }

}
