package day16;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class OpenTheLinkInNewTabThroughKeyboardActions {

    public static void main (String args[]) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));

        driver.get("https://automationtesting.in/");
        driver.manage().window().maximize();

        WebElement clk = driver.findElement(
                By.xpath("//a[normalize-space()='Demo Site']"));

        //through Keyboard action, clicking on locator & opening it in new tab
        Actions act = new Actions(driver);
        act.keyDown(Keys.CONTROL).click(clk).keyUp(Keys.CONTROL).perform();     //driver is focused on 1st tab here

        //now switching to register page
        List<String> ids = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(ids.get(1));                       //switched to window 2
        driver.findElement(
                By.xpath("//input[@placeholder='First Name']")).sendKeys("Rahul");


        //switching back to main page (i.e, 1st window)
        driver.switchTo().window(ids.get(0));
        driver.findElement(By.xpath("//input[@id='s']")).sendKeys("Test");


    }

}
