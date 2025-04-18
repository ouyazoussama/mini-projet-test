package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Tools;

import java.util.List;

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


    @FindBy(xpath = "//button[contains(@class , 'oxd-main-menu-button')]")
    WebElement toggleButton;



    @FindBy(xpath = "//aside[contains(@class,'oxd-sidepanel')]")
    WebElement aside;


    public void checkCurrentUrl() {
        String url = driver.getCurrentUrl();
        assert url != null;
        Assert.assertTrue(url.contains("index"));
    }


    public void clickLogoutButton() {
        clickElement(profileUserName);
        clickElement(logoutButton);
    }

    public void assertHomeIsHighlighted(String element) {

        List<WebElement> elements  = findElementsWithWait("//ul[@class = 'oxd-main-menu']//a");
        for (WebElement webElement : elements) {
            if (webElement.getText().trim().equalsIgnoreCase(element))  {
               System.out.println("txt " + webElement.getText());
                String className = webElement.getDomAttribute("class");
                System.out.println("classe " + className);
                Assert.assertTrue(className.contains("active"), "L'onglet 'Dashbord' n'est pas surligné.");
                return;
            }
        }
        Assert.fail("'Home' n'a pas été trouvé dans les éléments de la navbar.");
    }

    public List<WebElement> getNavbarElemtsList(){
        return findElementsWithWait("//ul[@class = 'oxd-main-menu']//a");
    }

    public void clickToggleButton() {
        clickElement(toggleButton);

    }

    public int returnWidth(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return aside.getSize().getWidth();
    }

    public boolean isNavbarToggled(){
        System.out.println( aside.getDomAttribute("class"));
        return aside.getDomAttribute("class").contains("toggled");
    }


}

