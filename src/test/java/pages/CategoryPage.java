package pages;

import Constantes.Xpaths;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Tools;

import static setup.SetUp.driver;

public class CategoryPage extends Tools {

    public CategoryPage() {

        PageFactory.initElements(driver, this);  // Initialisation des éléments de la page
    }

    @FindBy(name = "buy_now")
    WebElement buyButton;

    @FindBy(xpath = Xpaths.headphonesProductXpath)
    WebElement blackHeadphone;

    public void buy(){

        clickElement(buyButton);
    }



    public void addBlackHeadphones() {

        clickElement(blackHeadphone);
    }

    public  void cliquerSurProduit(String produit) {
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String productLocator = "//a[contains(@class,'productName') and contains(text(),'" + produit + "')]";
        WebElement productElement = driver.findElement(By.xpath(productLocator));
        productElement.click();
    }


}
