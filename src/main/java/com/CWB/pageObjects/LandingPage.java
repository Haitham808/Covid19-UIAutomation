package com.CWB.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.CWB.pagebase.PageBase;

public class LandingPage extends PageBase {

	public LandingPage(WebDriver driver) {
		super(driver);

	}

	// **************Web Elements *******************
	public By news = By.id("news");
	public By bus = By.id("bus");
	public By restaurant = By.id("restaurant");
	public By office = By.id("office");
	public By busStart = By.id("bus_timer_start");

	// **********************************************

	public void clickOnBusChallenge() {

		findElementClick(driver, bus);
		
		if(isElementsPresent(driver,busStart)) {
			pass("Challenge started successfully");
		}else {
			fail("Challenge failed to start");
			
		}
	}

}
