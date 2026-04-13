package assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

    public static void main (String args[]) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com");

        String title = driver.getTitle();
        if(title.equals("nopCommerce demo store. Home page title")) {
            System.out.println("Test Case passed");
        }
        else {
            System.out.println("Test Case failed");
        }

        Thread.sleep(5000);
        driver.close();                 //  OR driver.quit();

    }
}
