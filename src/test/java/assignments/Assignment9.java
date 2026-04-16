package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

//auto suggest dropdown practice

public class Assignment9 {

    public static void main (String args[]) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));

        driver.get("https://open.spotify.com/");
        driver.manage().window().maximize();

        driver.findElement(
                By.xpath("//input[@placeholder='What do you want to play?']")).sendKeys("Dil");
        Thread.sleep(5000);

        List<WebElement> list = driver.findElements(
                By.xpath("//div[@data-testid='tracklist-row']"));
        System.out.println(list.size());

        for (int i=0; i<list.size(); i++) {
            System.out.println(list.get(i).getText());
            if (list.get(i).getText().equals("Dil")) {
                list.get(i).click();
                break;
            }
        }




    }

}
