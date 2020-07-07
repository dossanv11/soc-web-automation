package steps;

import com.aventstack.extentreports.Status;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.BasePage;
import report.CustomExtentReporter;
import report.ReportHelper;

import java.io.IOException;

public class Hooks {

    private static BasePage basePage = new BasePage(DriverFactory.getDriver());

    private static CustomExtentReporter customExtentReporter;
    private static boolean isReporterRunning;
    private static int contadorScreenShot = 0;

    @Before
    public static void beforeScenario(Scenario scenario) {
        if (!isReporterRunning) {
            ReportHelper.customReport =  new CustomExtentReporter(scenario, ReportHelper.urlBaseDiretorio(scenario) + "/TestReport.html");
            isReporterRunning = true;
        }
        ReportHelper.inserirLog(Status.INFO, "Acessando o site: https://ww2.soc.com.br/blog/");
        basePage.abrirURL("https://ww2.soc.com.br/blog/");
        basePage.aceitarCookie();
    }

    @After
    public static void afterScenario(Scenario scenario) throws IOException {
        ReportHelper.salvarScreenshot(scenario);
        ReportHelper.customReport.insereStatusTest(scenario);
        ReportHelper.customReport.flushReport();
        DriverFactory.killDriver();
    }

}
