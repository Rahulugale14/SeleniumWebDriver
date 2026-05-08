package day27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage1 {

    //=========================================
    //This is without using page factory
    //=========================================

    /*
    1st part --> Constructor -> this will initialize the webdriver
    2nd part --> locators
    3rd part --> action methods

    above three parts we write on every page object class
     */


    WebDriver driver;

    //1st --> Constructor
    LoginPage1(WebDriver driver){
        this.driver = driver;
    }

    //2nd --> locators
    By txt_username_loc = By.xpath("//input[@placeholder='Username']");
    By txt_password_loc = By.xpath("//input[@placeholder='Password']");
    By button_login_loc = By.xpath("//button[normalize-space()='Login']");

    //3rd --> Action methods
    public void setUserName(String username){
        driver.findElement(txt_username_loc).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(txt_password_loc).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(button_login_loc).click();
    }

}
