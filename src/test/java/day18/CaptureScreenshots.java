package day18;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;

public class CaptureScreenshots {

    public static void main (String args[]) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.britannica.com/technology/automation/Feedback-controls");
        driver.manage().window().maximize();

        //1) ---> Capture full page screenshot--> this element is from orangehrm website
        /*
        TakesScreenshot ts = (TakesScreenshot)driver;
        File sourceFile =ts.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(System.getProperty("user.dir") + "\\Screenshots\\fullpage.png");
        sourceFile.renameTo(targetFile);            //copy sourcefile to targetfile

         */

        //2) ---> specific section screenshot
        /*
        WebElement spPage = driver.findElement(
                By.xpath("//section[@id='ref24843']"));
        File sourceFile = spPage.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(System.getProperty("user.dir") + "\\Screenshots\\spPageShot.png");
        sourceFile.renameTo(targetFile);

         */

        //3 ---> Specific element screenshot
        WebElement specificSS = driver.findElement(
                By.xpath("//img[@class='global-nav-logo global-nav-logo-left']"));
        File sourceFile = specificSS.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(System.getProperty("user.dir") + "\\Screenshots\\specificSS.png");
        sourceFile.renameTo(targetFile);















    }


}
