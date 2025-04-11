package pages;

import Constantes.Xpaths;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Tools;

import java.time.Duration;


public class Inscription extends Tools {
    @FindBy(xpath = Xpaths.InvalidMailLabel)
    private WebElement invalidMailField;
    @FindBy(xpath = Xpaths.usernameXpath)
    private WebElement userNameField;


    @FindBy(xpath =Xpaths.emailXpath)
    private WebElement emailField;

    @FindBy(xpath =Xpaths.passwordXpath)
    private WebElement passwordField;

    @FindBy(xpath = Xpaths.confirmPasswordXpath)
    private WebElement confirmPasswordField;

    @FindBy(id = Xpaths.menuUserId)
    private WebElement menuUser;

    @FindBy(xpath = Xpaths.createAccountXpath)
    private WebElement createAccountButton;

    @FindBy(xpath = Xpaths.registerButton)
    private WebElement enregistrerButton;


    public Inscription( ){

        PageFactory.initElements(driver, this);
    }



    public void insertEmail(String email) {
        super.insertElement(emailField, email);
    }
    public void checkMessageErrorDisplayed() {
        super.ElementIsDisplayed(invalidMailField);
    }


    public void clickUserIcon() throws InterruptedException {
        super.clickElement(menuUser);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom = '60%'");
        Thread.sleep(3000);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
        super.clickElement(createAccountButton);


    }

    public void insertUsename(String username) {
        super.insertElement(userNameField, username);
    }


    public void insertPassword(String password) {
        super.insertElement(passwordField, password);
    }
    public void insertRepeatedPassword(String repeatedPassword) {
        super.insertElement(confirmPasswordField, repeatedPassword);
    }

    public void checkEnregistrerButtonDisable() {
        super.ElementIsDisabled(enregistrerButton);
    }
}
