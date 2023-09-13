package qa.util;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseThings {

	WebDriver driver;

	public BaseThings(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForElementoVisible(By locator) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitForWebElementoVisible(WebElement webelement) {

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(webelement));
	}

	public void waitForElementoInVisible(By locator) {

//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

	}

	public void JavaScriptExecutor(By locator) {

		JavascriptExecutor ex = (JavascriptExecutor) driver;

		ex.executeScript("arguments[0].click();", driver.findElement(locator));

	}

	public void actionSendkey(String countryname) throws InterruptedException {

		Actions actions = new Actions(driver);

		// Thread.sleep(3000);

//		actions.sendKeys(country, countryname).build().perform();

	}
}
