package Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.sql.Time;
import java.time.Duration;
import java.util.ArrayList;
import java.util.logging.Logger;


public class Tools {
    public static WebDriver driver;
    protected static final int TIME = 40;
    protected void clickElement(WebElement element) {
        element.click();
    }

    protected void insertElement(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }
    private WebDriverWait wait;

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }

    public void waitAndClick(WebElement e) {
        System.out.println("Attends max [" + TIME + "]s que l'element soit cliquable");
        wait.until(ExpectedConditions.elementToBeClickable(e)).click();
    }


    public void waitAndMoveAndHover(WebElement e,WebDriver driver) {
        System.out.println("Attends max [" + TIME + "]s que l'element soit cliquable");
        Actions act = new Actions(driver);
        act.moveToElement(e).pause(3000).build().perform();
    }
    public void waitAndMoveAndClick(WebElement e,WebDriver driver) {
        System.out.println("Attends max [" + TIME + "]s que l'element soit cliquable");
        Actions act = new Actions(driver);
        act.moveToElement(e).pause(3000).click().build().perform();
    }
    public void scrollToElementAndClick(WebElement e,WebDriver driver){
        e.getLocation();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        waitAndClick(e);
    }
    public void scrollToBottom(WebDriver driver){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }
    public void scrollToEnd(WebDriver driver) {
        Actions actions = new Actions(driver);
        WebElement body = driver.findElement(By.tagName("body"));
        actions.keyDown(body, "End").perform();
    }
    public void waitAndDoubleClick(WebElement e,WebDriver driver){
        System.out.println("Attends max [" + TIME + "]s que l'element soit cliquable");
        Actions act = new Actions(driver);
        act.moveToElement(e).doubleClick().build().perform();
    }
    public void waitDisplayElement(WebElement e) {
        System.out.println("Attends max [\" + TIME + \"]s que l'element soit visible");
        wait.until(ExpectedConditions.visibilityOf(e)).isDisplayed();
    }

    public boolean ElementIsClickable(WebElement el) {
        System.out.println("Attends max [" + TIME + "]s que l'element soit cliquable");
        return wait.until(ExpectedConditions.elementToBeClickable(el)).isDisplayed();
    }
    public void waitEnabledElement(WebElement e) {
        System.out.println("Attends max [\" + TIME + \"]s que l'element soit visible");
        wait.until(ExpectedConditions.visibilityOf(e)).isDisplayed();
        Assert.assertTrue(e.isEnabled(),"l'element "+e+" est disabled");
    }

    public void waitDisabledElement(WebElement e) {
        System.out.println("Attends max [\" + TIME + \"]s que l'element soit visible");
        wait.until(ExpectedConditions.visibilityOf(e)).isDisplayed();
        Assert.assertFalse(e.isEnabled(),"l'element "+e+" est disabled");
    }
    public void verifyTextInElement(WebElement e, String text) {
        System.out.println("Vérifier que l'element contient le text "+text);
        waitDisplayElement(e);
        e.getText().contains(text);
        Assert.assertTrue(e.getText().contains(text),"l'element "+e+" ne contient pas le text : "+ text  );
    }

    public void verifyValueInElement(WebElement e, String text) {
        System.out.println("Vérifier que l'element contient le text "+text);
        waitDisplayElement(e);
        pause(3000);
        Assert.assertTrue( e.getAttribute("value").contains(text),"l'element "+e+" ne contient pas le text : "+ text );
    }

    public WebElement waitToBeVisible(WebElement e) {
        System.out.println("Attends max [" + TIME + "]s que l'element soit visible");
        wait.until(ExpectedConditions.visibilityOf(e));
        return e;
    }

    public void waitAndSendKeys(WebElement e, String keys) {
        //System.out.println(keys,"Entre la chaine de charactere [{}]");
        waitToBeVisible(e).sendKeys(keys);
    }


    public boolean waitDisplayElementBoolean(WebElement e){
        try{
            wait.until(ExpectedConditions.visibilityOf(e));
        } catch(Exception ex){
            return false;
        }
        return true;
    }

    public boolean isAttributePresent(WebElement e, String attribute) {
        boolean result = false;
        try {
            String value = e.getAttribute(attribute);
            if (value != null) {
                result = true;
            }
        } catch (Exception ignored) {
            System.out.println("exception ignoré");
        }
        return result;
    }

    public String getAttributeValue(WebElement e) {
        String s = e.getAttribute("value");
        return !s.isEmpty() ? s : null;
    }

    public void focusAndSendKeys(WebElement e,String text,WebDriver driver){
        waitAndMoveAndClick(e,driver);
        e.clear();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.DELETE);
        action.sendKeys(e,text).build().perform();
    }

    public void selectOptionByText(WebElement e, String value) {
        System.out.println("Attends max [" + TIME + "]s que l'element soit cliquable");
        wait.until(ExpectedConditions.elementToBeClickable(e));
        Select fruits = new Select(e);
        fruits.selectByVisibleText(value);
    }

    public void selectOptionByPartText(WebElement listeOptions, String partialText) {

        Select select = new Select(listeOptions);
        for(int i=1;i<=select.getOptions().size();i++)
        {
            String x= select.getOptions().get(i-1).getText();
            if(select.getOptions().get(i-1).getText().contains(partialText))
            {
                select.selectByIndex(i-1);
                break;
            }
            if(i==select.getOptions().size())
            {
                System.out.println("l'element" +partialText+ "n'est pas dans la liste");
                select.selectByVisibleText(partialText);
            }
        }
    }

    public void pause(int millSec) {
        try {
            Thread.sleep(millSec);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }


    //Gestion des onglets navigateur
    public void switchToNextTab(WebDriver driver) {
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
    }

    public void switchToPreviousTab(WebDriver driver) {
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(0));
    }
    public void switchToThirdTab(WebDriver driver) {
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(2));
    }
}

