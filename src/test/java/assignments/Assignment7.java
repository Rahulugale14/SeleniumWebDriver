package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

//dropdown practice

public class Assignment7 {

    public static void main (String args[]) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));

        driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
        driver.manage().window().maximize();

        WebElement dropdownCountry = driver.findElement(
                By.xpath("//select[@id='country-list']"));
        Select dpdC = new Select(dropdownCountry);
        //dpdC.selectByVisibleText("Brazil");               //selecting only one from dropdown

        List<WebElement> list = dpdC.getOptions();
        System.out.println("Total Number of dropdowns: " + list.size());

        for (WebElement opt : list) {
            System.out.println(opt.getText());
        }




    }

}
