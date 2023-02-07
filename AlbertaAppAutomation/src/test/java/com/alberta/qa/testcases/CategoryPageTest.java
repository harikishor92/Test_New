package com.alberta.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alberta.qa.Base.BaseTest;
import com.alberta.qa.Pages.CategoryPage;
import com.alberta.qa.Pages.DashBoardPage;
import com.alberta.qa.Pages.LoginPage;
import com.alberta.qa.Util.TestUtil;
import com.aventstack.extentreports.Status;

public class CategoryPageTest extends BaseTest {
	String sheetName = "addCategory";
	LoginPage lp;
	DashBoardPage dp;
	CategoryPage cp;

	CategoryPageTest() {
		super();
	}

	@BeforeClass
	public void setUp() throws InterruptedException {
		initialization();
		lp = new LoginPage();
		lp.login(prob.getProperty("userName"), prob.getProperty("password"));
		Thread.sleep(2000);
		dp = new DashBoardPage();
		cp = new CategoryPage();
	}

	@DataProvider()
	public Object[][] getAlbertaData() throws InvalidFormatException {
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(dataProvider = "getAlbertaData")
	public void categoryPageTest(String Sl_no, String catName, String catDesc, String catType, String deptType)
			throws InterruptedException {
		elogger = extent.createTest("CategoryPageTest_" + Sl_no);
		elogger.info("Start executing the test case");
		dp.clickOnCatBtn();
		elogger.info("navigated to Category page successfully");
		Thread.sleep(2000);
		cp.createCategory(catName, catDesc, catType, deptType);
		elogger.log(Status.PASS, "Test case pass");
		elogger.info("Test case execution is completed successfully");
	}
}
