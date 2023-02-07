package com.alberta.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alberta.qa.Base.BaseTest;
import com.alberta.qa.Pages.DashBoardPage;
import com.alberta.qa.Pages.LoginPage;
import com.alberta.qa.Pages.ManufacturerPage;
import com.alberta.qa.Util.TestUtil;
import com.aventstack.extentreports.Status;


public class ManufacturerPageTest extends BaseTest{

	String sheetName ="addManufacturer";
	LoginPage lp;
	DashBoardPage dp;
	ManufacturerPage mp;

	@BeforeClass
	public void setUp() throws InterruptedException
	{
		initialization();
		lp = new LoginPage();
		lp.login(prob.getProperty("userName"), prob.getProperty("password"));
		dp = new DashBoardPage();
		mp = new ManufacturerPage();

	}
	
	@DataProvider()
	public Object[][] getAlbertaData() throws InvalidFormatException
	{
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(dataProvider = "getAlbertaData")
	public void manufacturerPageTest(String Sl_no, String mName, String mCode) throws InterruptedException
	{
		elogger = extent.createTest("ManufacturerPageTest_"+Sl_no);
		elogger.info("Start executing the test case");
		dp.clickOnManufacturerBtn();
		Thread.sleep(2000);

		elogger.info("navigated to Unit page successfully"); 
		mp.createManufacturer(mName,mCode);
		elogger.log(Status.PASS, "Test case pass");
		elogger.info("Test case execution is completed successfully");


	}

}
