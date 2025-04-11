package pages;

import Constantes.Xpaths;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Tools;

import static setup.SetUp.driver;
import static setup.SetUp.wait;

public class DetailsPages extends Tools {
    public DetailsPages() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "quantity")
    WebElement quantityButton;
    @FindBy(name = "save_to_cart")
    WebElement addToCartButton;

    @FindBy(xpath = "//a[@id=\"shoppingCartLink\"]/span")
    WebElement cartItemCount;

    @FindBy(className = "plus")
    WebElement incrementButton;

    @FindBy(xpath = Xpaths.shoppingCartButton)
    private WebElement cart;

    @FindBy(xpath = Xpaths.decreaseButtonXpath)
    private WebElement decreaseQuantity;

    @FindBy(xpath = Xpaths.description)
    private WebElement description;


    public void setQuantity(int value) {

        wait.until(ExpectedConditions.visibilityOf(quantityButton));  // Attendre que le champ soit visible
        quantityButton.sendKeys(Keys.BACK_SPACE);  // Vider le champ avant de saisir une nouvelle valeur
        quantityButton.sendKeys(String.valueOf(value));  // Saisir la nouvelle valeur
    }

    // Méthode pour valider l'ajout au panier
    public void validate() {
        clickElement(addToCartButton);


    }

    public void assertCartItemCountNumber(int number) {
        String actual = cartItemCount.getText();  // Récupérer le nombre actuel d'articles dans le panier
        Assert.assertEquals(actual , String.valueOf(number) , "numbers mismatch");
    }

    public void increment() {
        clickElement(incrementButton);
    }

    public void goToShoppingCart() {
        clickElement(cart);

    }

    public void decreaseQuantity() {
        clickElement(decreaseQuantity);
    }

    public void shoppingCartUpdated(String expected_quantity) {
        Assert.assertEquals(cartItemCount.getText(),expected_quantity);
    }

    public void verfierNomProduit(String nomProduit) {
        checkElement(description,nomProduit);
    }


}
