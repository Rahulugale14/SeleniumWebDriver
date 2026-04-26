package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.time.Duration;

public class FDCalculator {

    public static void main (String[] args) throws IOException, InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
        driver.manage().window().maximize();

        String filePath = System.getProperty("user.dir")+"\\TestData\\caldata.xlsx";

        int rows = ExcelUtils.getRowCount(filePath, "Sheet1");

        for  (int i = 1; i <= rows; i++) {
            //Step1 ---> read data from Excel. below is from utility class
            String principalAmount = ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
            String rateOfInterest = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
            String period1 = ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
            String period2 = ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
            String frequency = ExcelUtils.getCellData(filePath, "Sheet1", i, 4);
            String expMaturityValue = ExcelUtils.getCellData(filePath, "Sheet1", i, 5);

            //Step2 ---> pass above data into application
            driver.findElement(
                    By.xpath("//input[@id='principal']")).sendKeys(principalAmount);
            driver.findElement(
                    By.xpath("//input[@id='interest']")).sendKeys(rateOfInterest);
            driver.findElement(
                    By.xpath("//input[@id='tenure']")).sendKeys(period1);

            Select periodDropdown = new Select(driver.findElement(
                    By.xpath("//select[@id='tenurePeriod']")));
            periodDropdown.selectByVisibleText(period2);

            Select freqDropdown = new Select(driver.findElement(
                    By.xpath("//select[@id='frequency']")));
            freqDropdown.selectByVisibleText(frequency);

            driver.findElement(
                    By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']")).click();//clicked on calculate

            //Step3 ---> validation
            String actualMaturityValue = driver.findElement(
                    By.xpath("//span[@id='resp_matval']//strong")).getText();

            if (Double.parseDouble(expMaturityValue)==Double.parseDouble(actualMaturityValue)) {
                System.out.println("Test passed");
                ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Passed");
                ExcelUtils.fillGreenColor(filePath, "Sheet1", i, 7);
            }
            else {
                System.out.println("Test failed");
                ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Failed");
                ExcelUtils.fillRedColor(filePath, "Sheet1", i, 7);
            }
            Thread.sleep(5000);
            driver.findElement(By.xpath("//img[@class='PL5']")).click(); //clicked on clear button

        }       //ending of for loop

        driver.quit();

    }

}
