package day16;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class SliderDemo {

    public static void main (String args[]) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));

        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        driver.manage().window().maximize();

        Actions act = new Actions(driver);

        //min slider
        WebElement min_slider = driver.findElement(
                By.xpath("//div[@class='price-range-block']//span[1]"));
        System.out.println("Default location of the min slider: " + min_slider.getLocation());      //(59, 250)
        act.dragAndDropBy(min_slider, 55, 250).perform();
        System.out.println("Location of min slider after moving: " + min_slider.getLocation());     //(114, 250)

        //max slider
        WebElement max_slider = driver.findElement(
                By.xpath("//span[2]"));
        System.out.println("Default location of the max slider: " + max_slider.getLocation());      //(613, 250)
        act.dragAndDropBy(max_slider, -150, 250).perform();
        System.out.println("Location of max slider after moving: " + max_slider.getLocation());     //(463, 250)










    }

}
