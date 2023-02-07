package com.alberta.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.alberta.qa.Base.BaseTest;
import com.alberta.qa.Util.TestUtil;

public class CategoryPage extends BaseTest {
	@FindBy(xpath = "//input[@placeholder='Search Department']")
	private WebElement searchDept;
	@FindBy(xpath = "//a[@class='addCategory text-light']//i[@class='fa fa-plus']")
	private WebElement addCatBtn;
	@FindBy(xpath = "//input[@id = 'add_vcategoryname']")
	private WebElement enterCatName;
	@FindBy(xpath = "//textarea[@id= 'category_add_vdescription']")
	private WebElement enterCatDesc;
	@FindBy(xpath = "//select[@class= 'form-control ']")
	private WebElement selectType;
	@FindBy(xpath = "//input[@name = 'vgrossProfitPercentage']")
	private WebElement gpPer;
	
	@FindBy(xpath = "//select[@id= 'add_dept_code']")
	private WebElement selectDept;
	@FindBy(xpath = "(//input[@class='btn button-blue basic-button-small'])[1]")
	private WebElement saveBtn;
	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement succMsg;
	@FindBy(xpath = "//div[@class='alert alert-danger']")
	private WebElement failMsg;

	public CategoryPage() {
		PageFactory.initElements(driver, this);
	}

	public void createCategory(String catName, String catDesc, String catType, String deptType) throws InterruptedException {
		searchDept.sendKeys("Music");
		addCatBtn.click();
		Thread.sleep(1000);
		enterCatName.sendKeys("Music Cat");
		Thread.sleep(1000);
		enterCatDesc.sendKeys("Music Cat Desc");
		Thread.sleep(1000);
		TestUtil.selectDropDown(selectType, "Sales");
		Thread.sleep(1000);
		gpPer.clear();
		Thread.sleep(1000);
		gpPer.sendKeys("10");
		Thread.sleep(1000);
		//TestUtil.selectDropDown(selectDept, deptType);
		//Thread.sleep(1000);
		saveBtn.click();
		try {
			succMsg.getText().contains("Successfully Added Category!!");
			elogger.info("Successfully Added Category!!");
			System.out.println("Successfully Added Category!!");
		} catch (Exception e) {
			// e.printStackTrace();
			// System.out.println("EXception*e** "+e);
			try {
				failMsg.getText().contains(" Category Already Exist!!");
				elogger.info(" Category Already Exist!!");
				System.out.println(" Category Already Exist!!");
			} catch (Exception e1) {

				e1.printStackTrace();
				System.out.println("EXception*e1** " + e1);
			}
		}

	}

}
