package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class Specific_Waits {
	WebDriver driver;
	WebDriverWait wait;
	Waits waits;

	public Specific_Waits(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		waits = new Waits(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//kendo-calendar-header/span[@class = 'k-button k-bare k-title']")
	WebElement datePickerHeaderLabel;

	public void pickMultiSelectDropDownWithTypeHereAndSeveralOptions(WebElement webElement, String[] dropDownOptions, int waitingTime) {
		Wait<WebDriver> fWait = waits.fluentWait(waitingTime);
		fWait.until(ExpectedConditions.elementToBeClickable(webElement));
		waits.click(webElement, 30);
		if (Objects.equals(dropDownOptions[0], "Select all")) {
			waits.click(driver.findElement(By.xpath("//button[contains(text(), 'Select all')]")), 30);
		} else {
			WebElement searchTxtBx = driver.findElement(By.xpath("//input[@placeholder = 'Type here to search...']"));
			for (int i = 0; i < dropDownOptions.length - 1; i++) {
				waits.putText(searchTxtBx, dropDownOptions[i], 30);
				WebElement firstOption = driver.findElement(By.xpath("(//div[@class= 'multiSelectItem ng-scope vertical'])[1]"));
				waits.click(firstOption, 30);
			}
		}
	}

	public void pickMultiSelectDropDownWithTypeHereAndOneOption(WebElement webElement, String dropDownOptions, int waitingTime) {
		Wait<WebDriver> fWait = waits.fluentWait(waitingTime);
		fWait.until(ExpectedConditions.elementToBeClickable(webElement));
		waits.click(webElement, 30);
		WebElement searchTxtBx = driver.findElement(By.xpath("//input[@placeholder = 'Type here to search...']"));
		waits.putText(searchTxtBx, dropDownOptions, 30);
		WebElement firstOption = driver.findElement(By.xpath("(//div[@class= 'multiSelectItem ng-scope vertical'])[1]"));
		waits.click(firstOption, 30);
	}

	public void pickMultiSelectDropDownWithSearch(WebElement webElement, String dropDownOptions, int waitingTime) {
		Wait<WebDriver> fWait = waits.fluentWait(waitingTime);
		fWait.until(ExpectedConditions.elementToBeClickable(webElement));
		waits.click(webElement, 30);
		WebElement searchTxtBx = driver.findElement(By.xpath("//input[@placeholder = 'Search...']"));
		waits.putText(searchTxtBx, dropDownOptions, 30);
		WebElement firstOption = driver.findElement(By.xpath("(//div[@class= 'multiSelectItem ng-scope vertical'])[1]"));
		waits.click(firstOption, 30);
	}

	public void pickKendoDropDown(WebElement kendoDDWebElement, String dropDownText, int waitingTime) {
		Wait<WebDriver> fWait = waits.fluentWait(waitingTime);
		fWait.until(ExpectedConditions.elementToBeClickable(kendoDDWebElement));
		waits.click(kendoDDWebElement, 30);
		waits.click(driver.findElement(By.xpath("//li[@kendodropdownsselectable and text() = '" + dropDownText + "']")), 30);
	}

	public void pickMultipleKendoDropDown(WebElement kendoDDWebElement, String[] dropDownText, int waitingTime) {
		Wait<WebDriver> fWait = waits.fluentWait(waitingTime);
		fWait.until(ExpectedConditions.elementToBeClickable(kendoDDWebElement));
		for (String s : dropDownText) {
			waits.click(kendoDDWebElement, 30);
			waits.click(driver.findElement(By.xpath("//li[@kendodropdownsselectable and text() = '" + s + "']")), 30);
		}
	}

	public void pickKendoDropDownWithAllOption(WebElement kendoDDWebElement, String dropDownText, int waitingTime) {
		Wait<WebDriver> fWait = waits.fluentWait(waitingTime);
		fWait.until(ExpectedConditions.elementToBeClickable(kendoDDWebElement));
		waits.click(kendoDDWebElement, 30);
		waits.click(driver.findElement(By.xpath("//li[text() = 'All']")), 30);
		waits.click(driver.findElement(By.xpath("//li[text() = '" + dropDownText + "']")), 30);
	}

	public void pickKendoDropDownWithNAOption(WebElement kendoDDWebElement, String dropDownText, int waitingTime) {
		Wait<WebDriver> fWait = waits.fluentWait(waitingTime);
		fWait.until(ExpectedConditions.elementToBeClickable(kendoDDWebElement));
		waits.click(kendoDDWebElement, 30);
		waits.click(driver.findElement(By.xpath("//li[text() = '" + dropDownText + "']")), 30);
	}

	public void setKendoDatePicker(WebElement webElement, String date, int waitingTime) {
		String[] myDate = date.split("/");
		String day = myDate[0];
		String month = myDate[1];
		String year = myDate[2];

		waits.click(webElement, waitingTime);
		waits.click(datePickerHeaderLabel, waitingTime);
		waits.click(datePickerHeaderLabel, waitingTime);

		WebElement selectYear = driver.findElement(By.xpath("//span[text() = '" + year + "']"));
		waits.click(selectYear, waitingTime);

		WebElement selectMonth = driver.findElement(By.xpath("//td[@title = '" + year + " " + month + "']"));
		waits.click(selectMonth, waitingTime);

		WebElement selectDay = driver.findElement(By.xpath("//td[contains(@title, '" + month + "')]/span[text()='" + day + "']"));
		waits.click(selectDay, waitingTime);
	}

}
