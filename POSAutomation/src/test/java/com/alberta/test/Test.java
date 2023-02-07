package com.alberta.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.AfterMethod;

public class Test {
	WiniumDriver driver = null;
	@org.testng.annotations.Test
	public  void mainTest()  {
		DesktopOptions option = new DesktopOptions();
		option.setApplicationPath("C:\\Program Files (x86)\\AlbertaPOS\\POS2020.exe");
		//option.setApplicationPath("C:\\Windows\\System32\\notepad.exe");
		try {
			driver = new WiniumDriver(new URL("http://localhost:9999"), option);
			//driver.findElementByName("Help").click();
			//driver.findElementByName("About Notepad").click();
			//driver.findElementByName("OK").click();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("txtUserName")).sendKeys("567");
		
		

	}
	
	@AfterMethod
	public void tearadown()
	{
		//driver.quit();
	}

}
