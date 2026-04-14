package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSLocators {

    public static void main (String args[]) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com");
        driver.manage().window().maximize();

        //********  TYPES of CSS selectors    **********

        //1 -> tag id ----> tag#id
        //driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-Shirts");
        //driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("T-Shirts");        //"input" removed

        //2 -> tag class ----> tag.classname
        //driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("T-Shirts");
        //driver.findElement(By.cssSelector(".search-box-text")).sendKeys("T-Shirts");      //"input" removed

        //3 -> tag attribute ----> tag[attribute="value"]
        //driver.findElement(By.cssSelector("input[placeholder=\"Search store\"]")).sendKeys("T-Shirts");

        //4 -> tag class attribute ----> tag.classname[attribute="value"]
        driver.findElement(
                By.cssSelector("input.search-box-text[aria-label='Search store']")).sendKeys("T-Shirts");
        // OR driver.findElement(By.cssSelector(".search-box-text[aria-label='Search store']")).sendKeys("T-Shirts");

    }
}
