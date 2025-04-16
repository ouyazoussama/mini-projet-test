package pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Tools;

public class Index extends Tools {
    public Index(){
        PageFactory.initElements(driver,this);
    }
    public void checkCurrentUrl() {
        String url = driver.getCurrentUrl();
        assert url != null;
        Assert.assertTrue(url.contains("index"));
    }
}
