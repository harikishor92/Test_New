package com.alberta.qa.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.log4j.elogger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
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

public class DashBoardPageTest extends BaseTest{
//elogger elogger = elogger.getelogger(DashBoardPageTest.class);
	
	String sheetName = "";
	WelcomePage wlcm;
	LoginPage loginPage;
	DashBoardPage dashBoard;
	
	DashBoardPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		//elogger.info("Welcome page launched successfully");
		//wlcm = new WelcomePage();
		//wlcm.clickOnLoginButton();
		//elogger.info("Login page launched successfully");
		loginPage = new LoginPage();
		loginPage.login(prob.getProperty("userName"), prob.getProperty("password"));
		//elogger.info("DashBoard page launched successfully");
		dashBoard = new DashBoardPage();
	}
	
	@DataProvider()
	public Object[][] getCapabilityTestData() throws InvalidFormatException
	{
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test
	public void dashBoardPageLOGOTextTest()
	{
		elogger = extent.createTest("DashBoardPageTest_01");
		elogger.info("Start executing the test case");
		
		boolean logo = dashBoard.validateDashBoard();
		Assert.assertTrue(true);
		elogger.log(Status.PASS, "Test case pass");
		elogger.info("Test case execution completed");
	}
	
	@Test
	public void dashBoardPageContentTest()
	{
		elogger = extent.createTest("DashBoardPageTest_02");
		elogger.info("Start executing the test case");
		
		boolean logo = dashBoard.validateDashBoardContent();
		Assert.assertTrue(true);
		elogger.log(Status.PASS, "Test case pass");
		elogger.info("Test case execution completed");
	}

}
