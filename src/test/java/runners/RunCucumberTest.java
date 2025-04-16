package runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features",      // Chemin vers tes .feature
        glue = {"stepDefinitions", "setup"},           // Tes packages de steps et config
        //tags = "  @AccessWithoutLogin ",           // On exécute les deux scénarios
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

