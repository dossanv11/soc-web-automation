package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.java.Scenario;

import java.io.File;
import java.io.IOException;

public class CustomExtentReporter {

    private ExtentHtmlReporter extentHtmlReporter;
    private ExtentReports extentReports;
    public ExtentTest test;

    public CustomExtentReporter(Scenario scenario, String reportLocation) {
        extentHtmlReporter = new ExtentHtmlReporter(new File(reportLocation));
        extentReports = new ExtentReports();
        String cssImage = "img { width: 160; height: 120px;} .featherlight img {widht: 1280px; height: 1024px;}";
        extentHtmlReporter.config().setCSS(cssImage);
        extentReports.attachReporter(extentHtmlReporter);
        test = extentReports.createTest(getScenarioTitle(scenario));
    }

    public void insereLog(Status status, String descricao) {
        test.log(status, descricao);
    }

    public void insereScreenShot(String screenshotFile) throws IOException {
        test.info("Screenshot: ",MediaEntityBuilder.createScreenCaptureFromPath(getScreenShotLocation(screenshotFile)).build());
    }

    public void insereStatusTest(Scenario scenario) {
        switch (scenario.getStatus()) {
            case PASSED:
                test.pass("Cenário passou.");
                break;
            case FAILED:
                test.fail("Cenário falhou");
                break;
            default:
                test.skip("Cenário foi pulado");
        }
    }

    public void flushReport() {
        if(extentReports != null) {
            extentReports.flush();
        }
    }

    private String getScreenShotLocation(String location) {
        return location.replaceAll("\\\\", "//");
    }

    private String getScenarioTitle(Scenario scenario) {
        return scenario.getName();
    }

}
