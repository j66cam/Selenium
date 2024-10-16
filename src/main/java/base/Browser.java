package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.ConfigFileReader;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Browser {

	static WebDriver driver;

	public static WebDriver startBrowser() throws Exception {

		switch (ConfigFileReader.getConfigValueFromPropertyFile("BROWSER")) {

			case "chrome":
				ChromeOptions options = new ChromeOptions();

				//For Headless Execution
				options.addArguments("--headless", "--disable-gpu");

				//To deactivate the info bar
				//options.addArguments("--disable-infobars");

				//To stop chrome from displaying the automated test message
				//options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

				//To deactivate notifications
				//options.addArguments("--disable-notifications");
				//options.addArguments("-–disable-popup-blocking");

				//To set a Page Load Strategy {NORMAL, EAGER & NONE}
				//options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

				//To set chrome language on english
				options.addArguments("--lang=en-US");

				//To implement a Chrome extension for block adds
				options.addExtensions(new File(System.getProperty("user.dir") + "\\config\\uBlock-Origin.crx"));

				//To avoid windows, notifications and autofill in Chrome
				Map<String, Object> prefs = new HashMap<>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("autofill.profile_enabled", false);
				options.setExperimentalOption("prefs", prefs);

				driver = new ChromeDriver(options);
				break;

			case "firefox":
				driver = new FirefoxDriver();
				break;

			case "edge":
				driver = new EdgeDriver();
				break;

			default:
				throw new Exception("[ERROR] - Incorrect Browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get(ConfigFileReader.getConfigValueFromPropertyFile("URL"));
		return driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}

}
