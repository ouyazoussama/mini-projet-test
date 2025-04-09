package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initialisation des éléments de la page
    }

    @FindBy(xpath = "//a[@id = 'menuUserLink']")
    private WebElement accountButton;

    @FindBy(xpath = "//a[contains(text() , 'NEW ACCOUNT')]")
    private WebElement registerButton;



    // Actions sur la page d'accueil
    public void clickSignIn() {
        accountButton.click();
    }

    public void clickRegister() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", registerButton);
        registerButton.click();
    }
}