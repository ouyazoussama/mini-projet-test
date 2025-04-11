package pages;

import Constantes.Xpaths;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Tools;

import java.time.Duration;
import java.util.NoSuchElementException;

public class ShoppingCart extends Tools{
    public ShoppingCart() {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = Xpaths.decreaseButtonXpath)
    private WebElement decreaseQuantity;


    @FindBy(xpath = Xpaths.editQuantityXpath)
    private WebElement editQuantity;

    public void editQuantity() {
        super.clickElement(editQuantity);
    }

    public void verifierProductName(String productName) {
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String xpath = "//label[contains(@class,'productName') and contains(text(),'" + productName + "')]";
        WebElement productLabel = driver.findElement(By.xpath(xpath));
        System.out.println(productLabel.getText());
        System.out.println(productName);
        Assert.assertEquals(productLabel.getText(), productName);

    }





}
