package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import setup.SetUp;

import java.time.Duration;

public class Tools extends SetUp {

    private final Duration TIMEOUT = Duration.ofSeconds(10);

    public void clickElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        System.out.println("✅ Clicked: " + element);
    }

    public void insertElement(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
        System.out.println("✅ Inserted text: " + text);
    }

    public void checkElement(WebElement element, String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(element));
        String actualText = element.getText();
        Assert.assertEquals(actualText, expectedText);
        System.out.println("✅ Text verified: " + actualText);
    }

    public boolean isElementEnabled(WebElement element) {
        return element.isEnabled();
    }
}
