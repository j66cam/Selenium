package seleniumgluecode.elements;

import base.Browser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pom.Home_Page;
import pom.elements.CheckBox_Page;

import static org.junit.Assert.assertEquals;

public class CheckBox {
	CheckBox_Page checkBox_page;

	@Given("That the user is on the Check Box page")
	public void thatTheUserIsOnTheCheckBoxPage() throws Exception {
		WebDriver driver = Browser.startBrowser();
		Home_Page home = new Home_Page(driver);
		checkBox_page = new CheckBox_Page(driver);
		home.goToPage(Home_Page.elements);
		checkBox_page.clickCheckBoxTab();
	}

	@When("The user selects different checkboxes until arriving at a final {string}")
	public void theUserSelectsDifferentCheckboxesUntilArrivingAtAFinal(String finalItem) {
		checkBox_page.checkItems(finalItem);
	}

	@Then("The user should see the selected {string}")
	public void theUserShouldSeeTheSelected(String finalItem) {
		assertEquals(finalItem.toLowerCase(), checkBox_page.getOutputSelectedLb());
	}
}
