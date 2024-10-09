package pom.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Waits;

public class CheckBox_Page {
	WebDriver driver;
	Waits waits;

	public CheckBox_Page(WebDriver driver) {
		this.driver = driver;
		waits = new Waits(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text() = 'Elements']")
	WebElement elementsLb;
	@FindBy(xpath = "//span[text() = 'Check Box']")
	WebElement checkBoxTab;
	@FindBy(xpath = "//span[text() = 'Home']/ancestor::span/button")
	WebElement homeBtn;
	@FindBy(xpath = " //span[text() = 'Documents']/ancestor::span/button")
	WebElement documentsBtn;
	@FindBy(xpath = "//span[text() = 'WorkSpace']/ancestor::span/button")
	WebElement workSpaceBtn;
	@FindBy(xpath = "//span[@class='text-success']")
	WebElement selection;

	public void clickCheckBoxTab() {
		waits.visibilityOf(elementsLb, 10);
		waits.click(checkBoxTab, 50);
	}

	public void checkItems(String finalItem) {
		waits.click(homeBtn, 50);
		waits.click(documentsBtn, 50);
		waits.click(workSpaceBtn, 50);
		WebElement finalElement = driver.findElement(By.xpath("//span[text() = '" + finalItem + "']"));
		waits.click(finalElement, 50);
	}

	public String getOutputSelectedLb() {
		return waits.getText(selection, 30);
	}
}
