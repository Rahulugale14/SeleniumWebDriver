package day18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class HeadlessTesting {

    public static void main (String [] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.facebook.com/login/?next=https%3A%2F%2Fwww.facebook.com%2F");
        driver.manage().window().maximize();

        String title = driver.findElement(
                By.xpath("//span[@class='x1lliihq x1plvlek xryxfnj x1n2onr6 xyejjpt x15dsfln x193iq5w xeuugli x1fj9vlw x13faqbe x1vvkbs x1s928wv xhkezso x1gmr53x x1cpjm7i x1fgarty x1943h6x x1ejgnnb xza2c7i x1apb90u x1215byi xzsf02u x1yc453h xtoi2st x3x7a5m']")).getText();
        System.out.println(title);






    }

}
