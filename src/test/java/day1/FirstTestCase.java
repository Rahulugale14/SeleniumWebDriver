package day1;

/*
Test Case -->
    1 -> Launch Chrome browser
    2 -> Open URL https://www.saucedemo.com
    3 -> Validate title should be "Swag Labs"
    4 -> Close browser

 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {

    public static void main (String args[] ) {

        //Step 1 --> launching browser (chrome)
        // ChromeDriver driver = new ChromeDriver();   //or below one
        WebDriver driver = new ChromeDriver();

        //Step 2 --> Open URL https://demo.opencart.com/
        driver.get("https://www.saucedemo.com");

        //Step 3 --> Validate title should be "Swag Labs"
        String actualTitle  = driver.getTitle();
            if(actualTitle.equals("Swag Labs")) {
                System.out.println("Test Passed");
            }
            else {
                System.out.println("Test Failed");
            }

        //Step 4 --> Close browser
        driver.close();
        // OR  driver.quit();


    }
}
