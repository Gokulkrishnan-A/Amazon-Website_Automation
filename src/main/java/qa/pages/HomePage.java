package qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import qa.util.BaseThings;
import qa.webElements.HomePageWebElements;


public class HomePage extends BaseThings{

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(how = How.ID, using = HomePageWebElements.homePageSignInButton)
	@CacheLookup
	WebElement signHomePage;
	
	@FindBy(how = How.CSS, using = HomePageWebElements.myAccount)
	@CacheLookup
	WebElement myAccount;
	
	@FindBy(how = How.XPATH, using = HomePageWebElements.accountAndList)
	@CacheLookup
	WebElement myAccountList;
	
	public LoginPage navigateToLogin() {
		signHomePage.click();
		return new LoginPage(driver);
	}

	public AccountPage getAccountSection() {
		myAccountList.click();
		myAccount.click();
		return new AccountPage(driver);
	}
}
