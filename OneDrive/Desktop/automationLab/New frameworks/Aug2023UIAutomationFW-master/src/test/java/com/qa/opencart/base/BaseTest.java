package com.qa.opencart.base;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.SearchResultsPage;

public class BaseTest {
	
	protected WebDriver driver;
	protected Properties prop;
	DriverFactory df;
	protected LoginPage loginPage;
	protected AccountsPage accPage;
	protected SearchResultsPage searchResultsPage;
	protected ProductInfoPage productInfoPage;
	protected RegisterPage registerPage;
	
	
	protected SoftAssert softAssert;
	
    private static final Logger log = LogManager.getLogger(BaseTest.class);

	
//	@Parameters({"browser", "browserversion", "testname"})
	@Parameters({"browser"})

	@BeforeTest
//	public void setup(String browserName, String browserVersion, String testName) {
	public void setup(String browserName) {
//		log.info(browserName + " : " + browserVersion + " " + testName);
		log.info("Browser Name is : " + browserName);

		df = new DriverFactory();
		prop = df.initProp();
		
		if(browserName!=null) {
			prop.setProperty("browser", browserName);
//			prop.setProperty("browserversion", browserVersion);
//			prop.setProperty("testname", testName);
		}
		else {
			log.info("no browser foundddddddd");
		}
		
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();
	}
	
	
	@AfterTest
	public void tearDown() {
		
		driver.quit();
		log.info("browser is closed....");
	}
	

}
