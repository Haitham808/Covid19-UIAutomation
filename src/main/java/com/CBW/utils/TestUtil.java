package com.CBW.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.CWB.testbase.TestBase;





public class TestUtil extends TestBase {
	
	public static String screenshotName;
	
	public static void captureScreenshot() {
		Date d = new Date();
	    screenshotName = d.toString().replace(":", "_").replace(" ", "_")+".png";
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File (System.getProperty("user.dir")+"\\extent\\CWB\\"+screenshotName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	}
	
	
}
