package setup;
import Utils.Tools;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {

    @Before(order = 0)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Tools.driver = new ChromeDriver();
        Tools.driver.manage().window().maximize();
        Tools.driver.get("http://advantageonlineshopping.com/#/");
    }
    @After(order = 0)
    public void tearDown() {
        if (Tools.driver != null) {
            Tools.driver.quit();
        }
    }
}
