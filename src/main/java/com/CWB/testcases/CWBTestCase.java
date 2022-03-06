package com.CWB.testcases;



import org.testng.annotations.Test;

import com.CWB.pageObjects.BusPage;
import com.CWB.pageObjects.LandingPage;
import com.CWB.pageObjects.LeadBoardPage;
import com.CWB.pageObjects.LoginPage;
import com.CWB.testbase.TestBase;


public class CWBTestCase extends TestBase {
	
	@Test
	public void covid19() {
		
		test = rep.startTest("COVID-19 Challenge Testcase");
		
		LoginPage login = new LoginPage(driver);
		LandingPage chooseChallenge = new LandingPage(driver);
		BusPage completeChallenge = new BusPage(driver);
		LeadBoardPage leadBoard  = new LeadBoardPage(driver);
		
		
		
		login.loginToCovid19Game();
		chooseChallenge.clickOnBusChallenge();
		completeChallenge.CompleteBusChallenge();
		leadBoard.userScore();

		
	}
	

}
