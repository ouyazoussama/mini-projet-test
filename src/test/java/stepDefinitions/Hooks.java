package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ExtentReportManager;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        ExtentReportManager.createTest(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            ExtentReportManager.getTest().fail("Scenario failed: " + scenario.getName());
        } else {
            ExtentReportManager.getTest().pass("Scenario passed");
        }
        ExtentReportManager.getExtentReports().flush();
    }
}
