package day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FileUpload {

    public static void main (String args[]) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
        driver.manage().window().maximize();
        driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");


        //single file upload
        /*
        driver.findElement(
                By.xpath("//input[@id='filesToUpload']")).sendKeys("C:\\testfolder\\subfolder1\\Test.txt");
        if (driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("Test.txt")) {
            System.out.println("File is successfully uploaded");
        }
        else {
            System.out.println("File is failed to upload");
        }

         */


        //multiple file uploads
        String file1 = "C:\\\\testfolder\\\\subfolder1\\\\Test1.txt";
        String file2 = "C:\\\\testfolder\\\\subfolder1\\\\Test2.txt";

        driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1 + "\n" + file2);

        //check file names
        int totalSize = driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
        if (totalSize ==2) {
            System.out.println("All files are successfully uploaded");
        }
        else {
            System.out.println("Files failed to upload");
        }

        if (driver.findElement(
                By.xpath("//ul[@id='fileList']//li[1]")).getText().equals("Test1.txt") && driver.findElement(
                        By.xpath("//ul[@id='fileList']//li[2]")).getText().equals("Test2.txt")) {
            System.out.println("File names are matching");
        }
        else {
            System.out.println("File names are not matching");
        }

    }

}
