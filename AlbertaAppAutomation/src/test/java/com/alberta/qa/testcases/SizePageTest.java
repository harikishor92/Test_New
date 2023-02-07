package com.alberta.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alberta.qa.Base.BaseTest;
import com.alberta.qa.Pages.DashBoardPage;
import com.alberta.qa.Pages.LoginPage;
import com.alberta.qa.Pages.SizePage;
import com.alberta.qa.Util.TestUtil;
import com.aventstack.extentreports.Status;



public class SizePageTest extends BaseTest{

	String sheetName ="addSize";
	LoginPage lp;
	DashBoardPage dp;
	SizePage sp;

	@BeforeClass
	public void setUp() throws InterruptedException
	{
		initialization();
		lp = new LoginPage();
		lp.login(prob.getProperty("userName"), prob.getProperty("password"));
		dp = new DashBoardPage();
		sp = new SizePage();

	}
	
	@DataProvider()
	public Object[][] getAlbertaData() throws InvalidFormatException
	{
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(dataProvider = "getAlbertaData")
	public void sizePageTest(String Sl_no, String sName) throws InterruptedException
	{
		elogger = extent.createTest("SizePageTest_"+Sl_no);
		elogger.info("Start executing the test case");
		dp.clickOnSizeBtn();
		Thread.sleep(2000);
		elogger.info("navigated to Size page successfully"); 
		sp.createSize(sName);
		elogger.log(Status.PASS, "Test case pass");
		elogger.info("Test case execution is completed successfully");

	}

}
