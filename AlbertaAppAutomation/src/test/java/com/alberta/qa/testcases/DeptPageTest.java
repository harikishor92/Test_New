package com.alberta.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alberta.qa.Base.BaseTest;
import com.alberta.qa.Pages.DashBoardPage;
import com.alberta.qa.Pages.DeptPage;
import com.alberta.qa.Pages.LoginPage;
import com.alberta.qa.Pages.WelcomePage;
import com.alberta.qa.Util.TestUtil;
import com.aventstack.extentreports.Status;

public class DeptPageTest extends BaseTest{
	
	String sheetName = "addDept";
	WelcomePage wlcm;
	LoginPage loginPage;
	DashBoardPage dashboard;
	DeptPage dp;
	
	DeptPageTest()
	{
		super();
	}
	
	@BeforeClass
	public void setUp() throws InterruptedException
	{
		initialization();
		loginPage = new LoginPage();
		loginPage.login(prob.getProperty("userName"), prob.getProperty("password"));
		Thread.sleep(2000);
		dashboard = new DashBoardPage();
		dashboard.clickOnDeptBtn();
		Thread.sleep(2000);
		dp = new DeptPage();
	}
	
	@DataProvider()
	public Object[][] getAlbertaTestData() throws InvalidFormatException
	{
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(dataProvider = "getAlbertaTestData")
	public void deptPageTest(String sl_no, String deptName,String deptDesc) throws InterruptedException
	{
		elogger = extent.createTest("DeptPageTest_"+sl_no);
		elogger.info("Start executing the test case");
		elogger.info("Start executing the Dept test case");
		dp.createDept(deptName,deptDesc);
		elogger.log(Status.PASS, "Test case pass");
		elogger.info("Test case execution is completed successfully");
	}

}
