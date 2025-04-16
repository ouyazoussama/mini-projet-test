package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Tools;

public class Login extends Tools {
    public Login(){
         PageFactory.initElements(driver,this);
    }

    @FindBy(name = "username")
    WebElement userNameButton;
    @FindBy(xpath = "//input[@name  = 'username']//following::span[1]")
    WebElement userNameErrorMessage;

    @FindBy(name = "password")
    WebElement passwordButton;
    @FindBy(xpath = "//input[@name  = 'password']//following::span[1]")
    WebElement passwordErrorMessage;

    @FindBy(xpath = "//button[contains(@class , 'login-button')]")
    WebElement loginButton;


    @FindBy(xpath = "//p[contains(text() , 'Forgot your password? ')]")
    WebElement forgetPassword; //p[contains(@class, 'oxd-alert-content-text') and text()="Invalid credentials"]

    @FindBy(xpath = "//p[contains(@class, 'oxd-alert-content-text') and text()=\"Invalid credentials\"]")
    WebElement InvalidCredentials;

    public void insertUserName(String username){
       insertElement(userNameButton,username);
    }
    public void insertPassword(String password){
        insertElement(passwordButton,password);
    }
    public void getUsernameErrorMessage(){
        Assert.assertTrue(userNameErrorMessage.isDisplayed());
    }
    public void getPasswordErrorMessage(){
        Assert.assertTrue(passwordErrorMessage.isDisplayed());
    }
    public void clickLogin(){
        clickElement(loginButton);
    }

    public void assertCurrentUrl() {
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }
}
