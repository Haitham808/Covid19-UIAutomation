package com.CWB.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.CBW.utils.ExtentManager;
import com.CWB.pagebase.PageBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static String browser;
	public static ExtentReports rep = ExtentManager.getInstance1();
	public static ExtentTest test;
	public static String baseURL;

	@BeforeSuite
	public void setUp() {

		if (driver == null) {

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}

			try {
				config.load(fis);
			} catch (IOException e) {
				
				e.printStackTrace();
			}

			if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {

				browser = System.getenv("browser");
			} else {

				browser = config.getProperty("browser");

			}

			config.setProperty("browser", browser);
			baseURL = config.getProperty("baseURL");

			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "Lib\\chromedriver.exe");
				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", chromePrefs);
				options.addArguments("disable-infobars");
				options.addArguments("disable-extensions");
				// options.addArguments("--headless");
				// options.addArguments("window-size=1920x1080");
				options.addArguments("--start-maximized");
				options.addArguments("--incognito");

				driver = new ChromeDriver(options);

				
			} else if (browser.equalsIgnoreCase("Edge")) {
				
				System.setProperty("webdriver.edge.driver", "Lib\\msedgedriver.exe");
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
			} else if (browser.equalsIgnoreCase("firefox")) {
				
				System.setProperty("webdriver.gecko.driver", "Lib\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
			}

			driver.get(baseURL);

			new PageBase(driver);

		}
	}

	@AfterSuite
	public void tearDown() {

		if (rep != null) {
			rep.endTest(test);
			rep.flush();
		}
		

		if (driver != null) {
			driver.close();
			driver.quit();
			driver = null;
		}

	}

}
