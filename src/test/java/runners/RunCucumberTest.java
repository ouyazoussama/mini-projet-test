package runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions","setup" },
        tags = "  @emptyLogin"
)

public class RunCucumberTest extends AbstractTestNGCucumberTests {
}

