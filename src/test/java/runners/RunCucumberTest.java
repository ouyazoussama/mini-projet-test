package runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions", "setup"},
        //tags = "@navbarIsToggled",
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",       // Rapport HTML
                "json:target/cucumber.json",               // Rapport JSON
                "rerun:target/failed_scenarios.txt"         // Pour relancer les échecs si besoin
        },
        monochrome = true                               // Console lisible
)

public class RunCucumberTest extends AbstractTestNGCucumberTests {
}

