package pom.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Waits;

public class TextBox_Page {
	Waits waits;

	public TextBox_Page(WebDriver driver) {
		waits = new Waits(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text() = 'Elements']")
	WebElement elementsLb;
	@FindBy(xpath = "//span[text() = 'Text Box']")
	WebElement textBoxTab;
	@FindBy(id = "userName")
	WebElement fullNameTxtBx;
	@FindBy(id = "userEmail")
	WebElement emailTxtBx;
	@FindBy(id = "currentAddress")
	WebElement currentAddressTxtBx;
	@FindBy(id = "permanentAddress")
	WebElement permanentAddressTxtBx;
	@FindBy(id = "submit")
	WebElement submitBtn;
	@FindBy(id = "name")
	WebElement nameLb;
	@FindBy(id = "email")
	WebElement emailLb;
	@FindBy(xpath = "//p[@id='currentAddress']")
	WebElement currentAddressLb;
	@FindBy(xpath = "//p[@id='permanentAddress']")
	WebElement permanentAddressLb;

	public void clickTextBoxTab() {
		waits.visibilityOf(elementsLb, 10);
		waits.click(textBoxTab, 10);
	}

	public void fillInputs(String fullName, String email, String currentAddress, String permanentAddress) {
		waits.putText(fullNameTxtBx, fullName, 30);
		waits.putText(emailTxtBx, email, 30);
		waits.putText(currentAddressTxtBx, currentAddress, 30);
		waits.putText(permanentAddressTxtBx, permanentAddress, 30);
	}

	public void clickSubmit() {
		waits.click(submitBtn, 30);
	}

	public String getNameLb() {
		return nameLb.getText();
	}

	public String getEmailLb() {
		return emailLb.getText();
	}

	public String getCurrentAddressLb() {
		return currentAddressLb.getText();
	}

	public String getPermanentAddressLb() {
		return permanentAddressLb.getText();
	}
}
