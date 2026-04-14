package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathAxesDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 1: Open URL
        driver.get("https://opensource-demo.orangehrmlive.com/");

        Thread.sleep(10000);

        // Step 2: Login
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(10000);

        // ==============================
        // 🔹 XPATH AXES EXAMPLES
        // ==============================

        // 1. Parent Axis
        WebElement parentExample = driver.findElement(
                By.xpath("//input[@name='username']/parent::div")
        );
        System.out.println("Parent Axis: " + parentExample.getAttribute("class"));

        // 2. Ancestor Axis
        WebElement ancestorExample = driver.findElement(
                By.xpath("//input[@name='username']/ancestor::form")
        );
        System.out.println("Ancestor Axis: " + ancestorExample.getTagName());

        // 3. Child Axis
        WebElement childExample = driver.findElement(
                By.xpath("//form/child::div")
        );
        System.out.println("Child Axis: " + childExample.getTagName());

        // 4. Descendant Axis
        WebElement descendantExample = driver.findElement(
                By.xpath("//form/descendant::input[@name='password']")
        );
        System.out.println("Descendant Axis: " + descendantExample.getAttribute("name"));

        // 5. Following Axis
        WebElement followingExample = driver.findElement(
                By.xpath("//input[@name='username']/following::input[1]")
        );
        System.out.println("Following Axis: " + followingExample.getAttribute("name"));

        // 6. Preceding Axis
        WebElement precedingExample = driver.findElement(
                By.xpath("//input[@name='password']/preceding::input[1]")
        );
        System.out.println("Preceding Axis: " + precedingExample.getAttribute("name"));

        // 7. Following-Sibling Axis
        WebElement followingSibling = driver.findElement(
                By.xpath("//input[@name='username']/parent::div/following-sibling::div[1]")
        );
        System.out.println("Following Sibling Axis: " + followingSibling.getTagName());

        // 8. Preceding-Sibling Axis
        WebElement precedingSibling = driver.findElement(
                By.xpath("//input[@name='password']/parent::div/preceding-sibling::div[1]")
        );
        System.out.println("Preceding Sibling Axis: " + precedingSibling.getTagName());

        // 9. Self Axis
        WebElement selfExample = driver.findElement(
                By.xpath("//input[@name='username']/self::input")
        );
        System.out.println("Self Axis: " + selfExample.getAttribute("name"));

        // 10. Attribute Axis
        WebElement attributeExample = driver.findElement(
                By.xpath("//input[@name='username']/attribute::name")
        );
        System.out.println("Attribute Axis: " + attributeExample.getText());

        driver.quit();
    }
}
