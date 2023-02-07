package com.alberta.qa.testcases;




import java.io.IOException;

//import org.apache.log4j.elogger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alberta.qa.Base.BaseTest;
import com.alberta.qa.Pages.WelcomePage;
import com.alberta.qa.Util.TestUtil;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;



public class WelcomePageTest extends BaseTest{
	
	//elogger elogger = elogger.getelogger(WelcomePageTest.class);
	
	String sheetName = "";
	WelcomePage wlcm;
	
	
	WelcomePageTest()
	{
		super();
	}
	
	@BeforeClass
	public void setUp()
	{
		initialization();
		
	}
	
	/*@DataProvider()
	public Object[][] getCapabilityTestData()
	{
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
		
	}*/
	
	
	
	@Test //(dataProvider = "getCapabilityTestData")
	public void WelcomePageTitleTest()
	{
		elogger = extent.createTest("WelcomePageTitleTest");
		elogger.info("Start executing the test case");
		elogger.info("Browser has launched and Navigated to Welcome page successfully");
		wlcm = new WelcomePage();
		String title = wlcm.validateWelcomePageTitle();
		Assert.assertEquals(title, "Administration | Login");
		elogger.log(Status.PASS, "Welcome page title has displayed");
		elogger.info("Test case execution completed");
	}
	
	
	/*
	 * @Test public void WelcomePageLOGOTextTest() throws IOException { eelogger =
	 * extent.createTest("WelcomePageLogoTest");
	 * eelogger.info("Start executing the test case");
	 * eelogger.info("Welcome page launched successfully"); wlcm = new WelcomePage();
	 * boolean logo = wlcm.validateWelcomePageLOGOText(); Assert.assertTrue(true);
	 * eelogger.log(Status.PASS, "Welcome page logo has displayed");
	 * eelogger.info("Test case execution completed");
	 * eelogger.info("Test case pass");
	 * 
	 * }
	 */

}
