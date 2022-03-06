package com.CWB.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.CWB.pagebase.PageBase;

public class BusPage extends PageBase {

	public BusPage(WebDriver driver) {
		super(driver);

	}

	// **************Web Elements *******************
	
	
	// ********** Bus ************
	public By busStart = By.id("bus_timer_start");
	public By busAnswer1 = By.id("bus_answer_1");
	public By busAnswer2 = By.id("bus_answer_2");

	// ************* Restaurant ***************
	public By restaurantStart = By.id("restaurant_timer_start");
	public By restaurantAnswer1 = By.id("restaurant_answer_1");
	public By restaurantAnswer2 = By.id("restaurant_answer_2");

	// ************* Restaurant ***************
	public By officeStart = By.id("start");
	public By officeAnswer1 = By.id("office_answer_1");
	public By officeAnswer2 = By.id("office_answer_2");

	
//**************** True Answer ***************
	public By nextBattle = By.id("close_correct_modal_btn");
	public By leadBoard = By.id("leaderboard_link");
	
	
	//**************** LEADERBOARD ***************
	
	public By leadBoardHeadLine = By.xpath("//p[contains(text(),'COVID-19 THE GAME - LEADERBOARD')]");

	public void CompleteBusChallenge() {

		findElementClick(driver, busStart);
		findElementClick(driver, busAnswer1);
		findElementClick(driver, nextBattle);
		findElementClick(driver, restaurantStart);
		findElementClick(driver, restaurantAnswer1);
		findElementClick(driver, nextBattle);
		findElementClick(driver, officeStart);
		findElementClick(driver, officeAnswer2);
		findElementClick(driver, leadBoard);
		
		if(isElementsPresent(driver,leadBoardHeadLine)) {
			pass("Challenge completed successfully");
		}else {
			fail("Challenge failed to complete");
			
		}

	}

}
