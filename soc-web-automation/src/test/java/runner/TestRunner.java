package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/java/features",
        glue="steps",
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-reports/report.html", "json:target/cucumber-json-report.json"},
        tags="@FormFAP")
public class TestRunner{}

// "html:target/cucumber-reports/report.html", "json:target/cucumber-json-report.json"
