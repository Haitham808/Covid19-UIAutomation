package com.CWB.pagebase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CBW.utils.Constants;
import com.CBW.utils.TestUtil;
import com.CWB.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class PageBase {

	protected WebDriver driver;

	public PageBase(WebDriver driver) {
		this.driver = driver;
	}
	
	public static String user="test1";

	// **********************************************
	// taking screenshot

	public static void pass(String messege) {
		TestUtil.captureScreenshot();
		TestBase.test.log(LogStatus.PASS, messege);
		TestBase.test.log(LogStatus.PASS, TestBase.test.addScreenCapture(TestUtil.screenshotName));
	}

	public static void fail(String messege) {
		TestUtil.captureScreenshot();
		TestBase.test.log(LogStatus.FAIL, messege);
		TestBase.test.log(LogStatus.FAIL, TestBase.test.addScreenCapture(TestUtil.screenshotName));
	}

	public static void warning(String message) {
		TestUtil.captureScreenshot();
		TestBase.test.log(LogStatus.WARNING, message);
		TestBase.test.log(LogStatus.PASS, TestBase.test.addScreenCapture(TestUtil.screenshotName));
	}

	// ***********************************************

	public void findElementClick(WebDriver driver, By locator) {// ==Find element and click=====>

		waitElementUntilClickable(driver, locator);
		driver.findElement(locator).click();

	}

	public void findBSOIncomeClick(WebDriver driver, By locator) throws InterruptedException {// ==Find element and
																								// click=====>

		waitElementUntilClickableShortWait(driver, locator);
		driver.findElement(locator).click();
	}

	public void waitElementUntilVisible(WebDriver driver, By locator) {// ===Wait for element until displayed
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitElementUntilClickable(WebDriver driver, By locator) {// ===Wait for element until displayed

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void waitElementUntilClickableShortWait(WebDriver driver, By locator) {// ===Wait for element until displayed

		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void selectByselectByVisibleText(WebDriver driver, By locator, String value) {// ===Wait for element until
																							// displayed

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		Select dropdown = new Select(driver.findElement(locator));
		dropdown.selectByVisibleText(value);
	}

	public void selectByValue(WebDriver driver, By locator, String value) {// ===Wait for element until displayed

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		Select dropdown = new Select(driver.findElement(locator));
		dropdown.selectByValue(value);
	}

	public boolean isElementsPresent(WebDriver driver, By locator) {// ===Find elements presence
		try {
			WebDriverWait wait = new WebDriverWait(driver, Constants.shortWait);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			return true;
		} catch (Exception e) {
			System.out.println(locator + " Not found");
			return false;
		}
	}

	

	public boolean isElementPresentShortWait(WebDriver driver, By locator) {// ===Find elements presence
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			return true;
		} catch (Exception e) {
			System.out.println(locator + " Not found. (this is not an error.)");
			return false;
		}
	}

	public void MoveMouseByAction(WebDriver driver, By locator) {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(locator);
		action.moveToElement(we).build().perform();

	}

	public void clickByAction(WebDriver driver, By locator) {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(locator);
		action.moveToElement(we).perform();
		action.click().build().perform();
	}

	public void moveToElementByJSE(WebDriver driver, By locator) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
	}

	public boolean verifyPageTitle(WebDriver driver, String pagetitle) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Constants.shortWait);
			wait.until(ExpectedConditions.titleContains(pagetitle));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public String getText(WebDriver driver, By locator) {// Find element and send keys
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		WebElement text = driver.findElement(locator);
		String textRetrieved = text.getText();
		return textRetrieved;
	}

	public void findElementSendKey(WebDriver driver, By locator, String SendkeyData) {// Find element and send keys
		WebDriverWait wait = new WebDriverWait(driver, Constants.shortWait);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(SendkeyData);
	}

	public void findElementSendIntKey(WebDriver driver, By locator, int SendkeyData) {// Find element and send keys
		WebDriverWait wait = new WebDriverWait(driver, Constants.shortWait);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		driver.findElement(locator).clear();
		String input = Integer.toString(SendkeyData);
		driver.findElement(locator).sendKeys(input);
	}

	public void findElementSendKeys(WebDriver driver, By locator, Keys SendkeyData) {// Find element and send keys
		WebDriverWait wait = new WebDriverWait(driver, Constants.shortWait);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(SendkeyData);
	}

}
