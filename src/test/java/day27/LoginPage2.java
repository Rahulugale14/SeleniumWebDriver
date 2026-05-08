package day27;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage2 {

    //=========================================
    //This is by using page factory
    //=========================================

    /*
    1st part --> Constructor -> this will initialize the webdriver
    2nd part --> locators
    3rd part --> action methods

    above three parts we write on every page object class
     */


    WebDriver driver;


    //1st --> Constructor
    LoginPage2(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);             //this is mandatory for Page Object class using PageFactory
    }


    //2nd --> locators
        // or this or below one is same
        // @FindBy(how = How.XPATH, using = "//input[@placeholder='Username']")
    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement txt_username;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement txt_password;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement btn_login;

    //location multiple elements below
    @FindBy(tagName = "a")
    List<WebElement> links;


    //3rd --> Action methods

    public void setUserName(String username){
        txt_username.sendKeys(username);
    }

    public void setPassword(String password){
        txt_password.sendKeys(password);
    }

    public void clickLoginButton(){
        btn_login.click();
    }

}
