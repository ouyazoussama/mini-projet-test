package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue     = {"steap"},
        plugin   = {"pretty", "json:target/reports/cucumber.json"} )

public class Runner extends AbstractTestNGCucumberTests { }

