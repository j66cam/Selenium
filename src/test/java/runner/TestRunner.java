package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features"},
		glue = {"seleniumgluecode", "hooks"},
		plugin = {"json:test/report/cucumber_report.json"},
		monochrome = true,
		tags = "@loginAndLogOutRMS"
)

public class TestRunner {
}
