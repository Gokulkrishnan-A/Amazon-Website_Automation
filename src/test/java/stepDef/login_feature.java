package stepDef;


import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import junit.framework.Assert;
import qa.factory.DriverFactory;
import qa.pages.HomePage;
import qa.pages.LoginPage;

public class login_feature {

//	WebDriver driver= DriverFactory.getWebDriver();
	private HomePage homepage=new HomePage(DriverFactory.getDriver());
	private LoginPage loginpage;
	private static String loginPageTitle;
	private static String homePageTitle;
	
	@Given("User to open the website in browser")
	public void user_to_open_the_website_in_browser() {
		DriverFactory.getDriver().get("https://www.amazon.in/");
		
	}


	@And("click on signin button")
	public void click_on_signin_button() {
		loginpage = homepage.navigateToLogin();
	}
	@When("User gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		loginPageTitle=loginpage.getLoginPageTitle();
		System.out.println("this is the LoginPage title" + loginPageTitle);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		Assert.assertEquals(expectedTitle, loginPageTitle);
	}


	@When("User enters the phonenumber {string} and click on next")
	public void user_enters_the_phonenumber_and_click_on_next(String MobileNum) {
		loginpage.enterMobileOrMailId(MobileNum);
		loginpage.clickonContinue();
	}

	@Then("forget password link should be dispalyed")
	public void forget_password_link_should_be_dispalyed() {
		Assert.assertTrue(loginpage.isForgotPwdLinkExist());
	}

	@When("I login with correct credentials where user name is {string} and password is {string}")
	public void loginpage(String MobileNum, String password) {
		loginpage.loginToAmazon(MobileNum, password);    
	}
	@And("User should get the title of the homepage")
	public void user_should_get_the_title_of_the_homepage() {
		homePageTitle=loginpage.getHomePageTitle();
		System.out.println("this is the LoginPage title" + homePageTitle);
	}

	@Then("Homepage title should be {string}")
	public void homepage_title_should_be(String expectedTitle) {
		Assert.assertEquals(expectedTitle, homePageTitle);
		
	}

}
