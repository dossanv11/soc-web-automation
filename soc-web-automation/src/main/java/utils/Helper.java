package utils;

import com.aventstack.extentreports.Status;
import factory.DriverFactory;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Helper {
    public static CustomExtentReporter customReport;
    private static int contadorScreenShot = 0;

    public static void inserirLog(Status status, String descricao) {
        customReport.insereLog(status, descricao);
    }

    public static void salvarScreenshot(Scenario scenario) throws IOException {
        contadorScreenShot++;
        ArrayList<String> listaTagName = (ArrayList<String>) scenario.getSourceTagNames();
        String screenShotFileName = System.getProperty("user.dir") + "/target/report/screenshots/print" + contadorScreenShot + ".png";
        screenshot(screenShotFileName);
        customReport.insereScreenShot(screenShotFileName);
    }

    private static void screenshot(String path) {
        File file = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
