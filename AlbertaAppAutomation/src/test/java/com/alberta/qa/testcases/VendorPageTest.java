 package com.alberta.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alberta.qa.Base.BaseTest;
import com.alberta.qa.Pages.DashBoardPage;
import com.alberta.qa.Pages.LoginPage;
import com.alberta.qa.Pages.VendorPage;
import com.alberta.qa.Util.TestUtil;
import com.aventstack.extentreports.Status;

public class VendorPageTest extends BaseTest{
	String sheetName = "addVendor";
	LoginPage lp;
	DashBoardPage dp;
	VendorPage vp;
	
	@BeforeClass
	public void setUp() throws InterruptedException
	{
		initialization();
		lp = new LoginPage();
		lp.login(prob.getProperty("userName"), prob.getProperty("password"));
		Thread.sleep(2000);
		dp = new DashBoardPage();
		dp.clickOnVendorBtn();
		Thread.sleep(2000);
		vp = new VendorPage();
		
	}
	
	@DataProvider
	public Object[][] getAlbertaData() throws InvalidFormatException
	{
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(dataProvider = "getAlbertaData")
	public void vendorPageTest(String Sl_no,String vName,String vType,String vFname,String vLname,String vCode,String vAdress,String vCity,String vState,String vPhone,String vZip,String vEmail,String vPlcbType, String vEdi) throws InterruptedException
	{
		elogger = extent.createTest("VendorPageTest_"+Sl_no);
		elogger.info("Start executing the test case");
		vp.createVendor(vName,vType,vFname,vLname,vCode,vAdress,vCity,vState,vPhone,vZip,vEmail,vPlcbType,vEdi);
		elogger.log(Status.PASS, "Test case pass");
		elogger.info("Test case execution is completed successfully");
	}

}
