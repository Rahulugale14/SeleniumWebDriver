package day16;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class KeyboardActions {

    public static void main (String args[]) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));

        driver.get("https://text-compare.com");
        driver.manage().window().maximize();

        driver.findElement(
                By.xpath("//textarea[@id='inputText1']")).sendKeys("WELCOME");

        Actions act = new Actions(driver);



        //CTRL+A --> selects the text
        act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();

        //CTRL+C --> copy the text
        act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();

        //TAB --> shift to 2nd text box
        act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();

        //CTRL+V --> paste the copied text in 2nd box
        act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();





    }

}
