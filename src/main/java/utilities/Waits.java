package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class Waits {
	WebDriver driver;
	Wait<WebDriver> fWaits;
	WebDriverWait wait;
	Select select;

	public Waits(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}

	public Wait<WebDriver> fluentWait(int waitingTime) {
		fWaits = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(waitingTime))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class)
				.ignoring(InvalidArgumentException.class)
				.ignoring(NoSuchWindowException.class);
		return fWaits;
	}

	public void click(WebElement webElement, int waitingTime) {
		Wait<WebDriver> fWait = fluentWait(waitingTime);
		fWait.until(ExpectedConditions.visibilityOf(webElement));
		fWait.until(ExpectedConditions.elementToBeClickable(webElement));
		webElement.click();
	}

	public void clickJavaScriptInjection(WebElement webElement) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", webElement);
	}

	public void putText(WebElement webElement, String text, int waitingTime) {
		Wait<WebDriver> fWait = fluentWait(waitingTime);
		fWait.until(ExpectedConditions.visibilityOf(webElement));
		fWait.until(ExpectedConditions.elementToBeClickable(webElement));
		webElement.clear();
		webElement.sendKeys(text);
	}

	public String getText(WebElement webElement, int waitingTime) {
		Wait<WebDriver> fWait = fluentWait(waitingTime);
		fWait.until(ExpectedConditions.visibilityOf(webElement));
		return webElement.getText();
	}

	public void visibilityOf(WebElement webElement, int waitingTime) {
		Wait<WebDriver> fWait = fluentWait(waitingTime);
		fWait.until(ExpectedConditions.visibilityOf(webElement));
	}

	public void visibilityOfAll(List<WebElement> webElement, int waitingTime) {
		Wait<WebDriver> fWait = fluentWait(waitingTime);
		fWait.until(ExpectedConditions.visibilityOfAllElements(webElement));
	}

	public boolean webElementIsDisplayed(WebElement webElement, int waitingTime) {
		Wait<WebDriver> fWait = fluentWait(waitingTime);
		fWait.until(ExpectedConditions.visibilityOf(webElement));
		return webElement.isDisplayed();
	}

	public void invisibilityOfSingle(WebElement webElement, int waitingTime) {
		Wait<WebDriver> fWait = fluentWait(waitingTime);
		fWait.until(ExpectedConditions.invisibilityOf(webElement));
	}

	public void webElementToBeDisabled(WebElement webElement, int waitingTime) {
		Wait<WebDriver> fWait = fluentWait(waitingTime);
		fWait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(webElement)));
	}

	public boolean webElementIsDisabled(WebElement webElement, int waitingTime) {
		Wait<WebDriver> fWait = fluentWait(waitingTime);
		fWait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(webElement)));
		return webElement.isEnabled();
	}

	public void webElementToBeSelected(WebElement webElement, int waitingTime) {
		Wait<WebDriver> fWait = fluentWait(waitingTime);
		fWait.until(ExpectedConditions.elementToBeSelected(webElement));
	}

	public void webElementToBeClickable(WebElement webElement, int waitingTime) {
		Wait<WebDriver> fWait = fluentWait(waitingTime);
		fWait.until(ExpectedConditions.elementToBeClickable(webElement));
	}

	public boolean webElementIsSelected(WebElement webElement, int waitingTime) {
		Wait<WebDriver> fWait = fluentWait(waitingTime);
		fWait.until(ExpectedConditions.visibilityOf(webElement));
		return webElement.isSelected();
	}

	public void pickSelectDropDownOptionByValue(WebElement webElement, String dropDownOption, int waitingTime) {
		Wait<WebDriver> fWait = fluentWait(waitingTime);
		fWait.until(ExpectedConditions.elementToBeClickable(webElement));
		select = new Select(webElement);
		select.selectByVisibleText(dropDownOption);
	}

	public void pickSelectDropDownOptionByIndex(WebElement webElement, int optionIndex, int waitingTime) {
		Wait<WebDriver> fWait = fluentWait(waitingTime);
		fWait.until(ExpectedConditions.elementToBeClickable(webElement));
		select = new Select(webElement);
		select.selectByIndex(optionIndex);
	}

	public String getDDSelectedOption(WebElement webElement, int waitingTime) {
		Wait<WebDriver> fWait = fluentWait(waitingTime);
		fWait.until(ExpectedConditions.elementToBeClickable(webElement));
		select = new Select(webElement);
		return select.getFirstSelectedOption().getText();
	}

	public int getNumberOfDropdownOptions(WebElement webElement, int waitingTime) {
		Wait<WebDriver> fWait = fluentWait(waitingTime);
		fWait.until(ExpectedConditions.elementToBeClickable(webElement));
		select = new Select(webElement);
		List<WebElement> numberOfDropdownOptions = select.getOptions();
		return numberOfDropdownOptions.size();
	}

	public void setDatePickerOnTextBox(WebElement webElement, String date, int waitingTime) {
		Wait<WebDriver> fWait = fluentWait(waitingTime);
		fWait.until(ExpectedConditions.visibilityOf(webElement));
		fWait.until(ExpectedConditions.elementToBeClickable(webElement));
		click(webElement, 30);
		webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		webElement.sendKeys(Keys.DELETE);
		webElement.sendKeys(date);
	}

	public void removeReadOnlyForInputDateAndSetDate(WebElement element, String date) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('readonly','readonly');", element);
		putText(element, date, 30);
	}
}
