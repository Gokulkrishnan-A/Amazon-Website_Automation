package qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import qa.util.BaseThings;
import qa.webElements.AccountWebElements;

public class AccountPage extends BaseThings {

	WebDriver driver;

	public AccountPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = AccountWebElements.myAccountList)
	@CacheLookup
	List<WebElement> myAccountList;

	public String getTitle() {
		return driver.getTitle();
	}

	public int getAccountSectionCount() {
		return myAccountList.size() ;
	}
	public List<String> getAccountSectionList() {
		List<String> myAccParts = new ArrayList<String>();
		for (WebElement e : myAccountList) {
			myAccParts.add(e.getText());
		}
		return myAccParts;
	}

}
