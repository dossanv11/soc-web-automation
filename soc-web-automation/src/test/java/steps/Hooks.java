package steps;

import com.aventstack.extentreports.Status;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.BasePage;
import utils.CustomExtentReporter;
import utils.Helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Hooks {

    private static BasePage basePage = new BasePage(DriverFactory.getDriver());

    private static CustomExtentReporter customExtentReporter;
    private static boolean isReporterRunning;
    private static int contadorScreenShot = 0;

    @Before
    public static void beforeScenario(Scenario scenario) {
        if (!isReporterRunning) {
            Helper.customReport =  new CustomExtentReporter(scenario, "target/report/TestReport.html");
            isReporterRunning = true;
        }
        Helper.inserirLog(Status.INFO, "Acessando o site: https://ww2.soc.com.br/blog/");
        basePage.abrirURL("https://ww2.soc.com.br/blog/");
        basePage.aceitarCookie();
    }

    @After
    public static void afterScenario(Scenario scenario) throws IOException {
        Helper.salvarScreenshot(scenario);
        Helper.customReport.insereStatusTest(scenario);
        Helper.customReport.flushReport();
        DriverFactory.killDriver();
    }

}
