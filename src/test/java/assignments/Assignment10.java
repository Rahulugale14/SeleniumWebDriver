package assignments;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Assignment10 {

    public static void main (String args[]) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));

        driver.get("https://blazedemo.com");
        driver.manage().window().maximize();

        WebElement departureCity = driver.findElement(
                By.xpath("//select[@name='fromPort']"));
        Select depCity = new Select (departureCity);
        depCity.selectByVisibleText("Portland");                                    //Selecting Portland from dropdown

        WebElement destinationCity = driver.findElement(
                By.xpath("//select[@name='toPort']"));
        Select destCity = new Select(destinationCity);
        destCity.selectByVisibleText("London");                                     //Selecting London from dropdown

        driver.findElement(
                By.xpath("//input[@value='Find Flights']")).click();


        int totalRows = driver.findElements(
                By.xpath("//table[@class='table']//tr")).size();
        System.out.println("Total number of rows: " + totalRows);                   //printing total rows

        int totalColumns = driver.findElements(
                By.xpath("//table[@class='table']//th")).size();
        System.out.println("Total number of columns: " + totalColumns);             //printing total rows

        System.out.println("--------------------------------------------------------");

        List <WebElement> prices = driver.findElements(
                By.xpath("//table[@class='table']//tbody/tr/td[6]"));
        for (WebElement price : prices) {
            System.out.println(price.getText());                                    //printing all values from last column
        }

        System.out.println("--------------------------------------------------------");

        ArrayList<Double> priceList = new ArrayList<>();
        for (WebElement price : prices) {
            String text = price.getText().replace("$", "").trim();
            priceList.add(Double.parseDouble(text));
        }
        // Print all prices
        System.out.println("All prices: " + priceList);                 //printing in arraylist

        // Find and print lowest
        double lowest = Collections.min(priceList);
        System.out.println("Lowest price: $" + lowest);                 //printing smallest from arraylist

        System.out.println("--------------------------------------------------------");

        driver.findElement(
                By.xpath("(//input[@value='Choose This Flight'])[3]")).click();

        driver.findElement(
                By.xpath("//input[@id='inputName']")).sendKeys("Rahul Ugale");
        driver.findElement(
                By.xpath("//input[@id='address']")).sendKeys("Ozar Mig");
        driver.findElement(
                By.xpath("//input[@id='city']")).sendKeys("Nashik");
        driver.findElement(
                By.xpath("//input[@id='state']")).sendKeys("Maharashtra");
        driver.findElement(
                By.xpath("//input[@id='zipCode']")).sendKeys("422206");

        WebElement card = driver.findElement(
                By.xpath("//select[@id='cardType']"));
        Select cardType = new Select(card);
        cardType.selectByVisibleText("American Express");

        driver.findElement(
                By.xpath("//input[@id='creditCardNumber']")).sendKeys("1405199611032001");
        driver.findElement(
                By.xpath("//input[@id='creditCardMonth']")).sendKeys("3");
        driver.findElement(
                By.xpath("//input[@id='creditCardYear']")).sendKeys("2035");
        driver.findElement(
                By.xpath("//input[@id='nameOnCard']")).sendKeys("Rahul Ugale");
        driver.findElement(
                By.xpath("//input[@id='rememberMe']")).click();
        driver.findElement(
                By.xpath("//input[@value='Purchase Flight']")).click();

        WebElement message = driver.findElement(
                By.tagName("h1"));
        String actualMessage = message.getText();
        System.out.println("Message: " + actualMessage);

        //verify above message
        String expectedMessage = "Thank you for your purchase today!";
        if (actualMessage.equals(expectedMessage)) {
            System.out.println("✅ Verification PASSED!");
        }
        else {
            System.out.println("❌ Verification FAILED!");
            System.out.println("Expected: " + expectedMessage);
            System.out.println("Actual:   " + actualMessage);
        }


    }

}
