package pages;

import Constantes.Xpaths;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Tools;

public class HomePage extends Tools {

    public HomePage( ) {
        PageFactory.initElements(driver, this);  // Initialisation des éléments de la page
    }

    @FindBy(xpath = "//a[@id = 'menuUserLink']")
    private WebElement accountButton;

    @FindBy(xpath = "//a[contains(text() , 'NEW ACCOUNT')]")
    private WebElement registerButton;

    @FindBy(id = "tabletsTxt")
    WebElement tabletSection;

    @FindBy(xpath = Xpaths.headphonesBoxXpath)
    private WebElement headphoneBox;
    @FindBy(xpath = Xpaths.speakersBoxXpath)
    private WebElement speakersBox;



    // Actions sur la page d'accueil
    public void clickSignIn() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitForLoaderToDisappear(By.className("loader"));


        this.clickElement(accountButton);


    }

    public void clickRegister() {

        zoomOut(0.6);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitForLoaderToDisappear(By.className("loader"));


        this.clickElement(registerButton);
    }

    public void clickOnTabletsCategory(){
        clickElement(tabletSection);
    }

    public void clickHeadphoneBox(){
        super.clickElement(headphoneBox);
    }
    public void clickSpeakersBox(){
        super.clickElement(speakersBox);
    }

    public void cliquerSurCategorie(String categorie) {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitForLoaderToDisappear(By.className("loader"));
        WebElement categorieLocator = driver.findElement(
                By.xpath("//div[contains(@class,'shop_now_slider')]//span[contains(text(),'" + categorie + "')]")
        );
        clickElement(categorieLocator);
    }
}