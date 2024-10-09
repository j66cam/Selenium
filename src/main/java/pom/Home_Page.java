package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Waits;

public class Home_Page {
	Waits waits;

	public Home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		waits = new Waits(driver);
	}

	@FindBy(xpath = "//h5[text() = 'Elements']")
	public static WebElement elements;
	@FindBy(xpath = "//h5[text() = 'Forms']")
	public static WebElement forms;
	@FindBy(xpath = "//h5[text() = 'Alerts, Frame & Windows']")
	public static WebElement alertFrameWindows;

	public void goToPage(WebElement element) {
		waits.click(element, 30);
	}
}
