package pages;
import Constante.Xpath;
import utils.Tools;
import org.openqa.selenium.*;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;
import java.util.Objects;
import static setup.SetUp.wait;

public class LoginRegisterSuccess extends Tools {

    public LoginRegisterSuccess() {


        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = Xpath.menuUserBy)
    public WebElement myAccount;

    @FindBy(xpath = Xpath.createNewAccountBy)
    public WebElement createAccountLink;

    @FindBy(xpath = Xpath.usernameBy)
    private WebElement usernameField;

    @FindBy(xpath = Xpath.emailBy)
    private WebElement emailField;

    @FindBy(xpath = Xpath.passwordBy)
    private WebElement passwordField;

    @FindBy(xpath = Xpath.confirmPasswordBy)
    private WebElement confirmPasswordField;

    @FindBy(xpath = Xpath.firstNameBy)
    private WebElement firstNameField;

    @FindBy(xpath = Xpath.lastNameBy)
    private WebElement lastNameField;

    @FindBy(xpath = Xpath.phoneBy)
    private WebElement phoneField;

    @FindBy(xpath = Xpath.addressBy)
    private WebElement addressField;

    @FindBy(xpath = Xpath.cityBy)
    private WebElement cityField;

    @FindBy(xpath = Xpath.postalCodeBy)
    private WebElement postalCodeField;

    @FindBy(xpath = Xpath.regionBy)
    private WebElement regionField;

    @FindBy(xpath = Xpath.countryOptionMrBy)
    private WebElement countryDropdown;

    @FindBy(xpath = Xpath.agreeCheckboxBy)
    private WebElement agreeCheckbox;

    @FindBy(xpath = Xpath.registerBtnBy)
    public WebElement registerButton;

    @FindBy(xpath = Xpath.cartIconBy)
    private WebElement cartIcons;

    @FindBy(xpath = Xpath.cartContainerBy)
    private WebElement cartContainer;

    @FindBy(xpath = Xpath.removeButtonBy)
    private WebElement removeButtons;

    @FindBy(xpath = Xpath.categorySpeakersBy)
    private WebElement categorySpeakers;
    @FindBy(xpath = Xpath.firstProductBy)
    private WebElement firstProduct;
    @FindBy(xpath = Xpath.firstProductAddBy)
    private WebElement firstProductAddButton;

    public void clickMyaccount() {
      wait.until(ExpectedConditions.elementToBeClickable(myAccount)).click();

    }
    public void clickCreateNewAccount() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loader")));
        wait.until(ExpectedConditions.elementToBeClickable(createAccountLink));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom = '60%'");
        if (createAccountLink.isDisplayed()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createAccountLink);
            createAccountLink.click();
        } else {
            System.out.println("Le lien pour créer un nouveau compte n'est pas visible.");
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loader")));
        wait.until(ExpectedConditions.visibilityOf(usernameField));
    }
    public void insertUsername(String username) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.clear();
        usernameField.sendKeys(username);
    }
    public void insertRegisterEmail(String email) {
        insertElement(emailField, email);
    }
    public void insertRegisterPwd(String password) {
        insertElement(passwordField, password);
    }
    public void insertConfirmPwd(String confirmPwd) {
        insertElement(confirmPasswordField, confirmPwd);
    }
    public void insertFirstName(String firstName) {
        insertElement(firstNameField, firstName);
    }
    public void insertLastName(String lastName) {
        insertElement(lastNameField, lastName);
    }
    public void insertPhone(String phone) {
        insertElement(phoneField, phone);
    }
    public void selectCountry(String countryName) {
        WebElement dropdown = driver.findElement(By.name("countryListboxRegisterPage"));
        if (dropdown.getTagName().equals("select")) {
            Select select = new Select(dropdown);
            select.selectByVisibleText(countryName);
        } else {
            throw new IllegalStateException("Element n’est pas un <select>: " + dropdown.getTagName());
        }
    }
    public void insertCity(String city) {
        insertElement(cityField, city);
    }
    public void insertAddress(String address) {
        insertElement(addressField, address);
    }
    public void insertRegion(String region) {
        insertElement(regionField, region);
    }
    public void insertPostalCode(String postalCode) {
        insertElement(postalCodeField, postalCode);
    }
    public void checkAgreeTerms() {
        if (!agreeCheckbox.isSelected()) {
            clickElement(agreeCheckbox);
        }
    }
    public void clickButtonRegister() {
        clickElement(registerButton);
    }
    public void verfierPageReg(String expectedFragment) {
        String current = Objects.requireNonNull(driver.getCurrentUrl());
        Assert.assertTrue(current.contains(expectedFragment),
                "L’URL doit contenir « " + expectedFragment + " », mais c'est : " + current);
    }
    public void verifierUsernameDisplayed(String username) {
        String xpath = String.format(Xpath.menuUserLoggedBy, username);
        WebElement userMenu = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        Assert.assertTrue(userMenu.isDisplayed(),
                "Le nom d’utilisateur '" + username + "' doit être affiché dans le menu");
    }
    public void selectCategory(String categoryName) {
        WebElement category = driver.findElement(By.xpath(Xpath.categorySpeakersBy));
        category.click();
    }
    public void selectProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productImage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath.firstProductBy)));
        productImage.click();
    }
    public void addProductToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath.firstProductAddBy)));
        addToCartButton.click();
        System.out.println("Le produit est ajouté");
    }
    public void goToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpath.cartIconBy)));
        cartIcon.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath.cartContainerBy)));

        WebElement clickOn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpath.clickOnProductBy)));
        clickOn.click();

        WebElement removeButton = driver.findElement(By.xpath(Xpath.removeButtonBy));
        removeButton.click();

        wait.until(ExpectedConditions.invisibilityOf(removeButton));
    }
    public void removeAllItemsFromCart() {
        List<WebElement> removeButtonElements = driver.findElements(By.xpath(Xpath.removeButtonBy));
        for (WebElement removeButton : removeButtonElements) {
            removeButton.click();
            try {
                Thread.sleep(1000); // pour éviter les conflits entre clics
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
