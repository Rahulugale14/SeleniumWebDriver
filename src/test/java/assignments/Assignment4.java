package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Assignment4 {

    public static void main (String args[]) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        driver.findElement(
                By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("Selenium");
        driver.findElement(
                By.xpath("//input[@type='submit']")).click();

        //find total number of links
        List<WebElement> links = driver.findElements(
                By.cssSelector("#Wikipedia1_wikipedia-search-results a, " + "#Wikipedia1_wikipedia-search-more a"));
        System.out.println("Total number of links are: " + links.size());

        //open 6 links using for loop
        int totalLinks = links.size();

        for (int i=0; i<totalLinks; i++) {

            // Re-fetch elements (VERY IMPORTANT)
            links = driver.findElements(By.cssSelector("#Wikipedia1_wikipedia-search-results a, " + "#Wikipedia1_wikipedia-search-more a"));

            //get main window
            String parentWindow = driver.getWindowHandle();
            System.out.println("Parent Window ID: " + parentWindow);

            //click link. here all total links are opened
            links.get(i).click();

            //Wait for new tab
            Set<String> allWindows = driver.getWindowHandles();

            for (String win : allWindows) {
                if (!win.equals(parentWindow)) {
                    System.out.println("Child Window ID: " + win);
                    driver.switchTo().window(win);
                    //System.out.println("-------------------------------------------------------------------------");
                    break;
                }
            }
            // Print title (validation)
            System.out.println("Opened page title: " + driver.getTitle());

            // Close new tab
            driver.close();

            // Switch back to parent
            driver.switchTo().window(parentWindow);

        }


    }
}
