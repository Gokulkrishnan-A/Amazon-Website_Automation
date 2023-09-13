package stepDef;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import qa.factory.DriverFactory;
import qa.pages.AccountPage;
import qa.pages.HomePage;
import qa.pages.LoginPage;

public class AccountPage_def {
	private String title;
	private String username;
	private String password;
	AccountPage accountPage;
	private HomePage homepage = new HomePage(DriverFactory.getDriver());
	private LoginPage loginPage;

	@Given("User is already logged in to the Application")
	public void user_is_already_logged_in_to_the_application(DataTable credTable) {

		List<Map<String, String>> credList = credTable.asMaps();
		username = credList.get(0).get("Username");
		password = credList.get(0).get("Password");
		DriverFactory.getDriver().get("https://www.amazon.in/");
		loginPage = homepage.navigateToLogin();
		accountPage = loginPage.loginToAmazon(username, password);
	}

	@Given("User is on the Account Page")
	public void user_is_on_the_account_page() throws InterruptedException {
		accountPage = homepage.getAccountSection();
	}

	@When("User gets the title of the Account page")
	public void user_gets_the_title_of_the_account_page() {
		title = accountPage.getTitle();
		System.out.println(title);
	}

	@Then("Account page title should be {string}")
	public void account_page_title_should_be(String expectedTitle) {
		Assert.assertEquals(title, expectedTitle);
	}

	@Then("User gets the account section")
	public void user_gets_the_account_section(DataTable accountTable) {

		List<String> expectedAccountSection = accountTable.asList();
		System.out.println(expectedAccountSection);
		List<String> actualAccountSection = accountPage.getAccountSectionList();
		System.out.println(actualAccountSection);
		Assert.assertTrue(expectedAccountSection.containsAll(actualAccountSection));

	}

	@Then("The count of account section is {int}")
	public void the_count_of_account_section_is(Integer expectedCount) {
		System.out.println(accountPage.getAccountSectionCount());
			Assert.assertTrue(expectedCount== accountPage.getAccountSectionCount());
	}
}
