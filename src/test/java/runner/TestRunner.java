package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features"},
		glue = {"seleniumgluecode", "hooks"},
//		plugin = {"json:target/cucumber_report.json"},				// For a Json report results
//		plugin = {"pretty", "json:target/cucumber_report.json"},	// For a Json report results AND the scenario is displayed on the console with "pretty"
		plugin = {"html:target/cucumber.html"},						// For a more friendly cucumber report
	dryRun=false,													// To check whether all feature file steps have corresponding step definitions
	monochrome = false,												// if we want console output from Cucumber in a readable format
		tags = "@"
)

public class TestRunner {
}
