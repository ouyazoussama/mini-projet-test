package runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions","setup" },
        plugin = {
                "pretty",
                "json:target/cucumber-report.json",       // Pour qTest
                "junit:target/cucumber-report.xml",       // (optionnel) format JUnit
                "html:target/cucumber-html-report.html"   // Pour consultation locale
        },
        tags = "@register"

)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}

