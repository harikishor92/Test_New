package com.alberta.qa.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.alberta.qa.Base.BaseTest;
import com.alberta.qa.Pages.CustomerPage;
import com.alberta.qa.Pages.DashBoardPage;
import com.alberta.qa.Pages.LoginPage;
import com.aventstack.extentreports.Status;


public class CustomerPageTest extends BaseTest{
	String sheetName ="addCustomer";
	LoginPage lp;
	DashBoardPage dp;
	CustomerPage cp;

	@BeforeClass
	public void setUp() throws InterruptedException
	{
		initialization();
		lp = new LoginPage();
		lp.login(prob.getProperty("userName"), prob.getProperty("password"));
		dp = new DashBoardPage();
		cp = new CustomerPage();

	}


	@Test   //(dataProvider = "getAlbertaData")
	public void customerPageTest() throws InterruptedException
	{
		elogger = extent.createTest("CustomerPageTest_");
		elogger.info("Start executing the test case");
		dp.clickOnCustomerBtn();
		Thread.sleep(3000);
		elogger.info("navigated to Unit page successfully"); 
		cp.createCustomer();
		elogger.log(Status.PASS, "Test case pass");
		elogger.info("Test case execution is completed successfully");



	}

}
