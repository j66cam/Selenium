package hooks;

import base.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

	public static WebDriver driver;

	@After()
	public void tearDown(Scenario scenario) {
		driver = Browser.getDriver();
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
		if (driver != null) driver.quit();
	}
}
