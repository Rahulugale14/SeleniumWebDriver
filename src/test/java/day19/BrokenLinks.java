package day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BrokenLinks {
/*
Link -----> href="https://xyz.com
https://xyz.com -----> Server ----> status code
Status code >=400 ----> broken link
Status code <400 ---> not a broken link

 */

    public static void main (String [] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://www.deadlinkcity.com/");
        driver.manage().window().maximize();

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total number of links: " + links.size());

        int noOfBrokenLinks = 0;

        for (WebElement linkElement : links) {
            String hrefAttributeValue = linkElement.getAttribute("href");
            if (hrefAttributeValue==null || hrefAttributeValue.isEmpty()) {
                System.out.println("href attribute value is null or empty, so not possible to check");
                continue;
            }
            //hit URL to the server
            try {
                URL linkURL = new URL(hrefAttributeValue);  //converted href value from String to URL format
                HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection();  //opens connection to the server
                conn.connect(); //connect the server & sent request the server
                if (conn.getResponseCode() >= 400) {
                    System.out.println(hrefAttributeValue + " =====>Broken Link");
                    noOfBrokenLinks++;
                } else {
                    System.out.println(hrefAttributeValue + " =====> Not a broken link");
                }
            }
            catch (Exception e) {
            }

        }
        System.out.println("Number of Broken Links: " + noOfBrokenLinks);

    }

}
