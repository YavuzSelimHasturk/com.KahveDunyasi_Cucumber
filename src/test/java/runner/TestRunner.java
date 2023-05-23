package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Severity(SeverityLevel.NORMAL)
@CucumberOptions(
        plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        tags = "@wip",
        dryRun = false
)
public class TestRunner {
}
