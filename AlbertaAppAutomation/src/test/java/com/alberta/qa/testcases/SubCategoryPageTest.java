package com.alberta.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alberta.qa.Base.BaseTest;
import com.alberta.qa.Pages.DashBoardPage;
import com.alberta.qa.Pages.LoginPage;
import com.alberta.qa.Pages.SubCategoryPage;
import com.alberta.qa.Util.TestUtil;
import com.aventstack.extentreports.Status;

public class SubCategoryPageTest extends BaseTest{
	String sheetName ="addSubCat";
	LoginPage lp;
	DashBoardPage dp;
	SubCategoryPage scp;
	
	@BeforeClass
	public void setUp() throws InterruptedException
	{
		initialization();
		lp = new LoginPage();
		lp.login(prob.getProperty("userName"), prob.getProperty("password"));
		Thread.sleep(2000);
		dp = new DashBoardPage();
		scp = new SubCategoryPage();
	}
	@DataProvider()
	public Object[][] getAlbertaData() throws InvalidFormatException
	{
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider = "getAlbertaData")
	public void subCatPageTest(String Sl_no, String subCatName, String catType) throws InterruptedException
	{
		elogger = extent.createTest("SubCatPageTest_"+Sl_no);
		elogger.info("Start executing the test case");
		dp.clickOnSubCatBtn();
		Thread.sleep(2000);
		elogger.info("navigated to Sub Category page successfully");
		scp.createSubCat(subCatName,catType);
		elogger.log(Status.PASS, "Test case pass");
		elogger.info("Test case execution is completed successfully");
		
	}

}
