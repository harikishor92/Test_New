package com.alberta.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alberta.qa.Base.BaseTest;
import com.alberta.qa.Pages.DashBoardPage;
import com.alberta.qa.Pages.LoginPage;
import com.alberta.qa.Pages.UnitPage;
import com.alberta.qa.Util.TestUtil;
import com.aventstack.extentreports.Status;

public class UnitPageTest extends BaseTest{
	String sheetName ="addUnit";
	LoginPage lp;
	DashBoardPage dp;
	UnitPage up;
	
	@BeforeClass
	public void setUp() throws InterruptedException
	{
		initialization();
		lp = new LoginPage();
		lp.login(prob.getProperty("userName"), prob.getProperty("password"));
		dp = new DashBoardPage();
		up = new UnitPage();
			
	}
	
	@DataProvider()
	public Object[][] getAlbertaData() throws InvalidFormatException
	{
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider = "getAlbertaData")
	public void unitPageTest(String Sl_no, String uCode, String uName, String uDesc, String uStatus) throws InterruptedException
	{
		elogger = extent.createTest("UnitPageTest_");
		elogger.info("Start executing the test case");
		dp.clickOnUnitBtn();
		Thread.sleep(2000);
		elogger.info("navigated to Unit page successfully");
		up.createUnit(uCode,uName,uDesc,uStatus);
		elogger.log(Status.PASS, "Test case pass");
		elogger.info("Test case execution is completed successfully");
	}

}
