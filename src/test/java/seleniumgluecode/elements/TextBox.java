package seleniumgluecode.elements;

import base.Browser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pom.Home_Page;
import pom.elements.TextBox_Page;

import static org.junit.Assert.assertEquals;

public class TextBox {
	private TextBox_Page textBox_page;

	@Given("That the user is on the Elements page")
	public void thatTheUserIsOnTheElementsPage() throws Exception {
		WebDriver driver = Browser.startBrowser();
		Home_Page home = new Home_Page(driver);
		textBox_page = new TextBox_Page(driver);
		home.goToPage(Home_Page.elements);
		textBox_page.clickTextBoxTab();
	}

	@When("The user fills in the text fields with {string}, {string},{string} and {string}")
	public void theUserFillsInTheTextFieldsWithAnd(String fullName, String email, String currentAddress, String permanentAddress) {
		textBox_page.fillInputs(fullName, email, currentAddress, permanentAddress);
	}

	@And("The user clicks on the submit button")
	public void theUserClicksOnTheSubmitButton() {
		textBox_page.clickSubmit();
	}

	@Then("The user validates that {string}, {string},{string} and {string} appear in a new section")
	public void theUserValidatesThatAndAppearInANewSection(String fullName, String email, String currentAddress, String permanentAddress) {
		assertEquals(textBox_page.getNameLb(), "Name:" + fullName);
		assertEquals(textBox_page.getEmailLb(), "Email:" + email);
		assertEquals(textBox_page.getCurrentAddressLb(), "Current Address :" + currentAddress);
		assertEquals(textBox_page.getPermanentAddressLb(), "Permananet Address :" + permanentAddress);
	}
}
