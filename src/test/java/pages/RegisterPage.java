package pages;

import utils.Tools;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends Tools {

    @FindBy(name = "usernameRegisterPage")
    private WebElement userNameInput;

    @FindBy(name = "emailRegisterPage")
    private WebElement emailInput;

    @FindBy(name = "passwordRegisterPage")
    private WebElement passwordInput;

    @FindBy(name = "confirm_passwordRegisterPage")
    private WebElement confirmPasswordInput;

    @FindBy(name = "i_agree")
    private WebElement agreeToConditions;

    @FindBy(id = "register_btn")
    private WebElement registerButton;

    @FindBy(xpath = "//label[@data-ng-show='!registerSuccess']")
    private WebElement errorMsg;

    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }

    public void enterUserName(String username) {
        this.insertElement(userNameInput, username);
    }

    public void enterEmail(String email) {
        this.insertElement(emailInput, email);
    }

    public void enterPassword(String password) {
        this.insertElement(passwordInput, password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        this.insertElement(confirmPasswordInput, confirmPassword);
    }

    public void clickAgreeToConditions() {
        this.clickElement(agreeToConditions);
    }

    public void clickRegisterButton() {
        this.clickElement(registerButton);
    }

    public String getErrorMessage() {
        // Utilisation d'un wait explicite si besoin à la place de Thread.sleep
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return errorMsg.getText();
    }
}
