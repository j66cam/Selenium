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
		try {
			if (scenario.isFailed()) {
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "img/png", scenario.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (driver != null) driver.quit();
	}
}
