package com.alberta.qa.testcases;


import java.io.IOException;

//import org.apache.log4j.elogger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alberta.qa.Base.BaseTest;
import com.alberta.qa.Pages.DashBoardPage;
import com.alberta.qa.Pages.LoginPage;
import com.alberta.qa.Pages.WelcomePage;
import com.alberta.qa.Util.TestUtil;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class LoginPageTest extends BaseTest{
//elogger elogger = elogger.getelogger(LoginPageTest.class);
	
	String sheetName = "Login_Details";
	LoginPage lp;
	DashBoardPage dashBoardPage;
	
	
	LoginPageTest()
	{
		super();
	}
	
	@BeforeClass
	public void setUp() throws InterruptedException
	{
		initialization();
		//elogger.info("Welcome page launched successfully");
		//wlcm = new WelcomePage();
		//wlcm.clickOnLoginButton();
		//elogger.info("Login page launched successfully");
		lp = new LoginPage();
	}
	
	@DataProvider()
	public Object[][] getAlbertaTestData() throws InvalidFormatException
	{
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test
	public void loginPageLOGOTextTest()
	{
		elogger = extent.createTest("LoginPageLOGOTest");
		elogger.info("Start executing the test case");
		boolean logo = lp.validateLoginPage();
		Assert.assertTrue(true);
		elogger.log(Status.PASS, "Test case pass");
		elogger.info("Test case execution completed");
	}
	
	//Login app by using config file for username and password 
	
	@Test(dataProvider = "getAlbertaTestData")
	public void loginPageTest(String un,String pwd) throws InterruptedException
	{
		elogger = extent.createTest("LoginPageTest");
		elogger.info("Start executing the test case");
		lp.login(un, pwd);
		elogger.log(Status.PASS, "Test case pass");
		elogger.info("Test case execution completed");
	}

}
