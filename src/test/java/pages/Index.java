package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Tools;

public class Index extends Tools {
    public Index() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@class ='oxd-userdropdown-img']")
    WebElement profileUserName;

    @FindBy(xpath = "//a[text() = 'Logout']")
    WebElement logoutButton;
    @FindBy(xpath = "//button[contains(@class , 'oxd-button-primary')]")
    WebElement createButton;

    public void checkCurrentUrl() {
        String url = driver.getCurrentUrl();
        assert url != null;
        Assert.assertTrue(url.contains("index"));
    }


    public void clickLogoutButton() {
        clickElement(profileUserName);
        clickElement(logoutButton);
    }
}

