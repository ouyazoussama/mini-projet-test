package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentReports getExtentReports() {
        if (extent == null) {
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter("target/extent-report.html");
            htmlReporter.config().setReportName("Cucumber Test Report");
            htmlReporter.config().setDocumentTitle("Automation Report");

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("Tester", "Ton Nom");
            extent.setSystemInfo("Environment", "QA");
        }
        return extent;
    }

    public static ExtentTest createTest(String name) {
        test = getExtentReports().createTest(name);
        return test;
    }

    public static ExtentTest getTest() {
        return test;
    }
}
