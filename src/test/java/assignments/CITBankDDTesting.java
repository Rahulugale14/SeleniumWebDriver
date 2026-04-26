package assignments;

import day21.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class CITBankDDTesting {

    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");

        String pathFile = System.getProperty("user.dir") + "\\\\TestData\\citbankdata.xlsx";
        int rows = ExcelUtils.getRowCount(pathFile, "Sheet1");

        for (int i = 1; i <= rows; i++) {

            try {
                // ============================
                // Step 1: Read Excel Data
                // ============================
                String InitialDepositAmount = ExcelUtils.getCellData(pathFile, "Sheet1", i, 0);
                String lengthMonths = ExcelUtils.getCellData(pathFile, "Sheet1", i, 1);
                String interestRate = ExcelUtils.getCellData(pathFile, "Sheet1", i, 2);
                String compounding = ExcelUtils.getCellData(pathFile, "Sheet1", i, 3);
                String total = ExcelUtils.getCellData(pathFile, "Sheet1", i, 4);

                // ============================
                // Step 2: Enter Data
                // ============================

                WebElement amount = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[@formcontrolname='cdAmount']")));
                amount.clear();
                amount.sendKeys(InitialDepositAmount);

                WebElement months = driver.findElement(
                        By.xpath("//input[@formcontrolname='cdLength']"));
                months.clear();
                months.sendKeys(lengthMonths);

                WebElement intrate = driver.findElement(
                        By.xpath("//input[@formcontrolname='cdRate']"));
                intrate.clear();
                intrate.sendKeys(interestRate);

                // ============================
                // Step 3: Dropdown Handling
                // ============================

                WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//mat-select[@formcontrolname='cdCompounding']")));
                dropdown.click();

                // Select option (case-insensitive)
                List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//mat-option//span")));

                for (WebElement opt : options) {
                    if (opt.getText().equalsIgnoreCase(compounding)) {
                        opt.click();
                        break;
                    }
                }

                // Wait for overlay to disappear
                wait.until(ExpectedConditions.invisibilityOfElementLocated(
                        By.cssSelector(".cdk-overlay-backdrop")));

                // ============================
                // Step 4: Click Calculate
                // ============================

                driver.findElement(By.id("CIT-chart-submit")).click();

                // ============================
                // Step 5: Validation
                // ============================

                WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.id("displayTotalValue")));

                String actualTotal = result.getText();

                // Clean actual value
                actualTotal = actualTotal.replaceAll("[^0-9.]", "");

                // Clean expected value
                total = total.replaceAll("[^0-9.]", "");

                double actualValue = Double.parseDouble(actualTotal);
                double expectedValue = Double.parseDouble(total);

                System.out.println("Actual = " + actualValue + " | Expected = " + expectedValue);

                // Safe comparison
                if (Math.abs(actualValue - expectedValue) < 0.01) {
                    System.out.println("Test Passed");
                    ExcelUtils.setCellData(pathFile, "Sheet1", i, 6, "Passed");
                    ExcelUtils.fillGreenColor(pathFile, "Sheet1", i, 6);
                } else {
                    System.out.println("Test Failed");
                    ExcelUtils.setCellData(pathFile, "Sheet1", i, 6, "Failed");
                    ExcelUtils.fillRedColor(pathFile, "Sheet1", i, 6);
                }

            } catch (Exception e) {
                System.out.println("Error at row: " + i);
                e.printStackTrace();
            }
        }

        driver.quit();
        System.out.println("Execution Completed ✅");
    }
}