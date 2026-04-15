package day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HandleBrowserWindows {

    public static void main (String args[]) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));

        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        driver.findElement(
                By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();

        Set<String> windowIDs = driver.getWindowHandles();

        /*

        //========= 1st Approach - using List Collection ========= use this if there are only two windows
        //Converting Set into List collection. why? bcoz --> list extract individual items & Set collections don't have get method
        List<String> windowList = new ArrayList<>(windowIDs);
        String parentBrowerID = windowList.get(0);
        String childBrowserID = windowList.get(1);

        // now switching to child window
        driver.switchTo().window(childBrowserID);
        System.out.println(driver.getTitle());

        //switching back to parent window
        driver.switchTo().window(parentBrowerID);
        System.out.println(driver.getTitle());

         */

        //========= 2nd Approach - using looping statement ========= use this approach if there are multiple windows
        for (String winID : windowIDs) {
            String title = driver.switchTo().window(winID).getTitle();
            if (title.equals("OrangeHRM")) {
                System.out.println(driver.getCurrentUrl());
            }
        }

    }

}
