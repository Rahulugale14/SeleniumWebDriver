package day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class SelectDropdown {

    public static void main (String args[]) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        WebElement dropdownCountryElement = driver.findElement(
                By.xpath("//select[@id='country']"));
        Select dropdownCountry = new Select(dropdownCountryElement);

        //---> select option from the dropdown
        // dropdownCountry.selectByVisibleText("France");          //France is text from dropdown
        // dropdownCountry.selectByValue("japan");                    // japan is the value from webelement
        //dropdownCountry.selectByIndex(9);

        //---> capture the options from the dropdown
        List<WebElement> options = dropdownCountry.getOptions();
        System.out.println("Total number of dropdown options" + options.size());



        //----> printing the options
        //using normal for loop
        /*
        for (int i=0; i<options.size(); i++) {
            System.out.println(options.get(i).getText());
        }

         */

        //using enhanced for loop
        for (WebElement op : options) {
           System.out.println(op.getText());
        }


    }
}
