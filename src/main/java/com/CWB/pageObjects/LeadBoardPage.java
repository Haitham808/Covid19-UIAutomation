package com.CWB.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.CWB.pagebase.PageBase;

public class LeadBoardPage extends PageBase {

	public LeadBoardPage(WebDriver driver) {
		super(driver);

	}

	// ********** Bus ************
	public By userScore = By.xpath("//p[@id='showData']//td[contains(text(),'"+user+"')]/following-sibling::td[1]");
	

	// ************* Restaurant ***************

	public void userScore() {

		String score=getText(driver, userScore);
		System.out.println(score);
		pass("The score is "+score);
		

	}

}
