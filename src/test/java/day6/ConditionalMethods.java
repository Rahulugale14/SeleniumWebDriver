package day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {

    public static void main (String args[]) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/register");
        driver.manage().window().maximize();
        Thread.sleep(3000);


        //1 -----> isDisplayed -> we can check display status of the element
        WebElement logo = driver.findElement(
                By.xpath("//img[@alt='nopCommerce demo store']"));
        System.out.println("Display status logo: " + logo.isDisplayed());
                    //==== OR =====
        //boolean status = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
        //System.out.println("Display Status: " + status)


        //2 -----> isEnabled ->  we can check enable/disable status of the element / operational element
        boolean status = driver.findElement(
                By.xpath("//input[@id='FirstName']")).isEnabled();
        System.out.println("Enable Status: " + status);


        //3 -----> isSelected -> we can use to check the element is selected or not
        WebElement maleRadioButton = driver.findElement(
                By.xpath("//input[@id='gender-male']"));
        WebElement femaleRadioButton = driver.findElement(
                By.xpath("//input[@id='gender-female']"));

        System.out.println("Before selection...................");
        System.out.println("Male Radio Button: " + maleRadioButton.isSelected());
        System.out.println("Female Radio Button: " + femaleRadioButton.isSelected());

        System.out.println("After selection...................");
        maleRadioButton.click();
        System.out.println("Male Radio Button: " + maleRadioButton.isSelected());
        // ==== or ===
        //femaleRadioButton.click();
        //System.out.println("Female Radio Button: " + maleRadioButton.isSelected());

        boolean newsLetterStatus = driver.findElement(
                By.xpath("//input[@id='NewsLetterSubscriptions_0__IsActive']")).isSelected();
        System.out.println("News Letter checkbox status: " + newsLetterStatus);





    }

}
