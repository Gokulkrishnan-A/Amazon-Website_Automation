package qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import qa.util.BaseThings;
import qa.webElements.LoginWebElements;

public class LoginPage extends BaseThings {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = LoginWebElements.emailId)
	WebElement emailId;

	@FindBy(how = How.ID, using = LoginWebElements.continueNextID)
	WebElement continueNextID;

	@FindBy(how = How.ID, using = LoginWebElements.forgetPasswordLinkID)
	WebElement forgetPasswordLinkID;

	@FindBy(how = How.ID, using = LoginWebElements.passwordID)
	WebElement passwordID;

	@FindBy(how = How.ID, using = LoginWebElements.singInID)
	WebElement singInID;

	@FindBy(how = How.ID, using = LoginWebElements.logoID)
	WebElement logoID;

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public void enterMobileOrMailId(String mobileNum) {
		emailId.sendKeys(mobileNum);
	}

	public void clickonContinue() {
		continueNextID.click();
	}

	public void clickonSigninButton() {
		singInID.click();
	}

	public void signInWithPassword() {
		continueNextID.click();
	}
//	public void signInWithOTP(String otp)
//	{
//		continueNextID.click();
//	}

	public void enterPassword(String passwprd) {
		passwordID.sendKeys(passwprd);
	}

	public boolean isForgotPwdLinkExist() {
		return forgetPasswordLinkID.isDisplayed();
	}

	public AccountPage loginToAmazon(String mobileNum, String password) {
		enterMobileOrMailId(mobileNum);
		clickonContinue();
		enterPassword(password);
		clickonSigninButton();
		return new AccountPage(driver);
	}

}
