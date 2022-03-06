package com.CBW.utils;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	
	public static ExtentReports getInstance1() {
		if(extent==null) {
			extent =new ExtentReports(System.getProperty("user.dir")+"//extent//CWB//CWB.html", true, DisplayOrder.OLDEST_FIRST);
			extent.loadConfig(new File (System.getProperty("user.dir")+"//src//main//resources//extentconfig//ReportsConfig.xml"));
		}
		
		return extent;
	}
	

}
