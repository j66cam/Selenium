package hooks;

import base.Browser;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

public class Hooks {

	public static WebDriver driver;

	@After()
	public void tearDown() {
		driver = Browser.getDriver();
		if (driver != null) driver.quit();
	}
}
