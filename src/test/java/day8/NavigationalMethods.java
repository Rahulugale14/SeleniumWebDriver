package day8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class NavigationalMethods {

    public static void main (String args[]) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        //driver.get("https://demo.nopcommerce.com/");                  //accepst URL only in String format
        //----------or-------------
        //driver.navigate().to("https://demo.nopcommerce.com/");
        //----------or-------------
        //URL myURL = new URL("https://demo.nopcommerce.com/");
        //driver.navigate().to(myURL);                                //accepts URL in String as well as Object format

        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        System.out.println(driver.getCurrentUrl());

        driver.navigate().refresh();


    }

}
