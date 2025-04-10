package steap;
import Constante.Xpath;
import Pages.LoginRegisterSuccess;
//import Utils.ExcelReader;
//import Utils.ExcelUtils;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
//import org.testng.annotations.DataProvider;

import java.time.Duration;

public class Background {
    WebDriver driver;
    WebDriverWait wait;
    LoginRegisterSuccess loginRegisterSuccess;
    public String dropdownLabel;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        loginRegisterSuccess = new LoginRegisterSuccess(driver);
    }
//    @DataProvider(name = "userData")
//    public Object[][] userFormData() {
//        String filePath = "src/test/resources/data.xlsx";
//        return ExcelReader.getTableArray(filePath, "Users");
//    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Given("I am on the homepage of Advantage Online Shopping")
    public void i_am_on_the_homepage() {

        driver.get("https://advantageonlineshopping.com/");
    }
    @Given("I click on the {string} icon in the top navigation bar")
    public void i_click_on_the_user_icon(String iconName) {
        wait.until(ExpectedConditions.visibilityOf(loginRegisterSuccess.myAccount));
        loginRegisterSuccess.clickMyaccount();
    }
    @Given("I click on {string}")
    public void i_click_on_create_new_account(String linkText) {
        loginRegisterSuccess.clickCreateNewAccount();
    }
    @When("I fill in the {string} field with {string}")
    public void i_fill_in_the_field_with(String field, String value) {
        switch (field) {
            case "Username":
                loginRegisterSuccess.insertUsername(value);
                break;
            case "Email":
                loginRegisterSuccess.insertRegisterEmail(value);
                break;
            case "Password":
                loginRegisterSuccess.insertRegisterPwd(value);
                break;
            case "Confirm Password":
                loginRegisterSuccess.insertConfirmPwd(value);
                break;
            case "First Name":
                loginRegisterSuccess.insertFirstName(value);
                break;
            case "Last Name":
                loginRegisterSuccess.insertLastName(value);
                break;
            case "Phone Number":
                loginRegisterSuccess.insertPhone(value);
                break;
            case "City":
                loginRegisterSuccess.insertCity(value);
                break;
            case "Address":
                loginRegisterSuccess.insertAddress(value);
                break;
            case "Postal Code":
                loginRegisterSuccess.insertPostalCode(value);
                break;
            case "State / Province / Region":
                loginRegisterSuccess.insertRegion(value);
                break;
            default:
                throw new IllegalArgumentException("Unknown field: " + field);
        }
    }
    @When("I select {string} from the {string} dropdown")
    public void i_select_country_from_dropdown(String country, String dropdownLabel) {
        this.dropdownLabel = dropdownLabel;
        loginRegisterSuccess.selectCountry(country);
    }
    @When("I check the {string} checkbox")
    public void i_check_the_checkbox(String label) {
        loginRegisterSuccess.checkAgreeTerms();
    }
    @When("I click on the {string} button")
    public void i_click_on_the_button(String buttonLabel) {
        wait.until(ExpectedConditions.elementToBeClickable(loginRegisterSuccess.registerButton));
        loginRegisterSuccess.clickButtonRegister();
    }
    @Then("I should be redirected to the homepage")
    public void i_should_be_redirected_to_the_homepage() throws InterruptedException {
        loginRegisterSuccess.verfierPageReg("advantageonlineshopping.com");
        Thread.sleep(5000);
    }
    @Then("I should see my username {string} in the top navigation bar")
    public void i_should_see_my_username(String expectedUsername) {
        loginRegisterSuccess.verifierUsernameDisplayed(expectedUsername);
    }
    @And("I choose a category {string}")
    public void iChooseACategory(String categoryName) {
        WebElement category = driver.findElement(By.xpath(String.format(Xpath.categorySpeakersBy, categoryName)));
        category.click();
    }
    @And("I choose a product")
    public void iChooseAProduct() {
        loginRegisterSuccess.selectProduct();
    }
    @And("I add a product to the cart")
    public void iAddAProductToTheCart() throws InterruptedException {
        loginRegisterSuccess.addProductToCart();
        Thread.sleep(5000);

    }
    @Then("I enter on the {string} icon in the top navigation bar")
    public void i_click_on_the_cart_icon(String iconName) throws InterruptedException {
        WebElement cart = driver.findElement(By.xpath(String.format(Xpath.cartIconBy, iconName)));
        cart.click();
        Thread.sleep(5000);

    }
    @And("I remove all items from the cart")
    public void i_remove_all_items_from_the_cart() throws InterruptedException {
        loginRegisterSuccess.removeAllItemsFromCart();
        Thread.sleep(5000);


    }

}
