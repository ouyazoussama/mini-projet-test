package pages;

import org.openqa.selenium.support.PageFactory;
import utils.Tools;

public class NavigationPage extends Tools {
    public NavigationPage() {
        PageFactory.initElements(driver,this);
    }

    public void navigateToPage(String arg0) throws InterruptedException {
        Thread.sleep(3000);
        driver.get(arg0);
        Thread.sleep(3000);
    }
}
