package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PIM {
    @FindBy(xpath = "//span[contains(@class , 'oxd-main-menu-item') and text() = 'PIM']")
    WebElement pimButton;
    @FindBy(xpath = "//label[text()='Employee Id']//following::input[1]")
    WebElement employeeId;


}
