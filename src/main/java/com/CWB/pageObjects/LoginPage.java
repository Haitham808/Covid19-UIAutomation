package com.CWB.pageObjects;




import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import com.CWB.pagebase.PageBase;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
		
	//**************Web Elements *******************
	public By login = By.id("login");
	public By userName = By.id("worrior_username");
	public By createWarrier = By.id("warrior");
	public By startJourny = By.id("start");
	public By landingPageHeadLine = By.xpath("//p[contains(text(),'COVID-19 THE GAME')]");
	
	
	//**********************************************

	public void loginToCovid19Game() {

		findElementClick(driver, login);
		findElementSendKey(driver, userName, user);
		findElementClick(driver, createWarrier);
		findElementClick(driver, startJourny);
		
		
		if(isElementsPresent(driver,landingPageHeadLine)) {
			pass("logged in successfuly as "+user);
		}else {
			fail("login failed");
			
		}
		

	}

}
