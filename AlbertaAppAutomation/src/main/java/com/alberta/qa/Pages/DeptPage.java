package com.alberta.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.alberta.qa.Base.BaseTest;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class DeptPage extends BaseTest{
	@FindBy(xpath = "//input[@id = 'autocomplete-product']")
	private WebElement searchDept;
	@FindBy(xpath = "(//input[@type='text'])[4]")
	private WebElement matchText;
	@FindBy(xpath = "//button[contains(@onclick,'addDepartment();')]")
	private WebElement addNewDept;
	@FindBy(xpath = "//input[@id = 'add_vdepartmentname']")
	private WebElement deptNameBtn;
	@FindBy(xpath = "//textarea[@id = 'add_vdescription']")
	private WebElement deptDescBtn;
	@FindBy(xpath = "//input[@name = 'departtmentGppercentage']")
	private WebElement gpPerBtn;
	@FindBy(xpath = "//button[. = 'Save']")
	private WebElement saveBtn;
	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement succMsg;
	@FindBy(xpath = "//div[@class='alert alert-danger text-center']")
	private WebElement failMsg;
	@FindBy(xpath = "(//button[@class= 'close'])[2]")
	private WebElement closeBtn;
	
	public DeptPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createDept(String deptName,String deptDesc) throws InterruptedException
	{
		 addNewDept.click();
		  Thread.sleep(1000);
		  deptNameBtn.sendKeys(deptName);
		  Thread.sleep(1000);
		  deptDescBtn.sendKeys(deptDesc);
		  Thread.sleep(1000);
		  gpPerBtn.sendKeys("50");
		  Thread.sleep(1000);
		  saveBtn.click();
		  Thread.sleep(2000);
		  
		
		  try {
			  succMsg.getText().contains("Deparment Added Successfully!!");
			  elogger.info("Deparment Added Successfully!!");
			  System.out.println("Deparment Added Successfully!!");
		} catch (Exception e) {
			//e.printStackTrace();
			//System.out.println("EXception*e** "+e);
			try {
				failMsg.getText().contains("The name of that department already exists.");
				elogger.info("The name of that department already exists.");
				Thread.sleep(2000);
				closeBtn.click();
				System.out.println("The name of that department already exists.");
			} catch (Exception e1) {
				
				e1.printStackTrace();
				System.out.println("EXception*e1** "+e1);
			}
		}
		 // Assert.assertEquals(msg.getText(), "Deparment Added Successfully!!\r\n"
		//	  		+ "×");
		//  if(succMsg.getText().contains("Deparment Added Successfully!!"))
			/*
			 * System.out.println("Text***** "+succMsg.getText()); boolean oo =
			 * succMsg.isDisplayed(); System.out.println("boo***** "+oo);
			 * System.out.println("Text***** "+succMsg.getText());
			 * 
			 * if(succMsg.isDisplayed()) { elogger.info("Deparment Added Successfully!!");
			 * }else
			 * if(failMsg.getText().contains("The name of that department already exists."))
			 * { elogger.info("Deparment already exits."); }
			 */
		 
		/*searchDept.sendKeys("Dept_B");
		Thread.sleep(2000);
		if(matchText.getAttribute("value").equals("Dept_B"))
		{
			elogger.info("Department already created");
			System.out.println("******Department already created******");
			
		}else {
			 addNewDept.click();
			  Thread.sleep(1000);
			  deptName.sendKeys("Dept_B");
			  Thread.sleep(1000);
			  deptDesc.sendKeys("Creating Dept_B");
			  Thread.sleep(1000);
			  saveBtn.click();
			  System.out.println("Text********** "+msg.getText());
			  Assert.assertEquals(msg.getText(), "Deparment Added Successfully!!");
		}
		//searchDept.sendKeys("Dept_A");
		//Thread.sleep(2000);
		//System.out.println("Print the value***** "+matchText.getAttribute("value"));	
	}*/

}
}
