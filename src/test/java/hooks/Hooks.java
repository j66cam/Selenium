package hooks;

import base.Browser;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import utilities.TimeManager;

public class Hooks {

	public static WebDriver driver;

	@BeforeAll
	public static void setInitialTime() {
		TimeManager.setStartTime();
	}

	@After()
	public void tearDown() {
		driver = Browser.getDriver();
		if (driver != null) driver.quit();
	}
}
