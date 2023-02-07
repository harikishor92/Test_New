package com.alberta.qa.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import com.alberta.qa.Base.BaseTest;

public class TestUtil extends BaseTest{
	static Logger logger = Logger.getLogger(TestUtil.class);
	static String TESTDATA_SHEET_PATH = "./src/main/java/com/alberta/qa/Testdata/AlbertaApp_testData.xlsx";
	static Workbook book;
	static Sheet sheet;

	public static Object[][] getTestData(String sheetName) throws InvalidFormatException {
		logger.info("Start reading the excel sheet");
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString().trim();
				// System.out.println(data[i][k]);

			}
		}
		logger.info("Excel sheet data read successfully");
		return data;

	}

	public void switchToFrame()
	{
		driver.switchTo().frame("");
	}
	public static String concate =".";

	public static String takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		String screenshotPath = currentDir + "/Reports/screenshots/"+"Alberta_"+System.currentTimeMillis()+ ".png";
		//String screenshotPath =currentDir+"/Reports/screenshots/"+"Capability_" + timestamp()+ ".png";
		//String path = concate + "./Reports/screenshots/" + timestamp()+ ".png";
		//FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		FileUtils.copyFile(scrFile, new File(screenshotPath));
		//elogger.log(Status.INFO, "<br>  <img src='" + screenshotPath + "' height='90' width='160' /><br>");
		// elogger.log(Status.INFO, "<a href=" + screenshotPath + "></a>");
		return screenshotPath;
	}


	/*public static String takeScreenshotAtEndOfTest() throws IOException {
		Date date = new Date();
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    String dateForScreenshots = dateFormat.format(date);
	    File localScreenshots = new File(new File("Reports/screenshots"), dateForScreenshots);
	    if (!localScreenshots.exists() || !localScreenshots.isDirectory()) {
	        localScreenshots.mkdirs();
	    }
	    System.setProperty("org.uncommons.reportng.escape-output", "false");// this is to create a link in ReportNG
	    File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    String destination = System.getProperty("user.dir") + "/Reports/screenshots/" + dateForScreenshots +".png";
	    File screenshotName = new File(destination);
	    //Now add screenshot to results by copying the file
	    FileUtils.copyFile(scrFile, screenshotName);
	    elogger.log(Status.INFO, "<br>  <img src='" + destination + "' height='90' width='160' /><br>");
	    elogger.log(Status.INFO, "<a href=" + destination + "></a>");
		return destination;
	}*/

	////////////////////////////////////////////////////////////////////////////////////////

	public static String getScreenshot(String screenShotname) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		String imgPath = "./Reports/screenshots/"+screenShotname+System.currentTimeMillis()+ ".png";
		//String screenshotPath ="./Reports/screenshots/" + timestamp()+ ".png";
		//String path = concate + "./Reports/screenshots/" + timestamp()+ ".png";
		//FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		File path = new File(imgPath);
		FileUtils.copyFile(scrFile, path);
		return imgPath;
	}
	///////////////////////////////////////////////////////////////////////////////////////


	public static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(new Date());
	}

	//Common methods

	public static void selectDropDown(WebElement sValue, String option) throws InterruptedException
	{
		Select sel = new Select(sValue);
		Thread.sleep(1000);
		sel.selectByVisibleText(option);
	}

	public static void selectSearchDropDown(WebElement cEle,WebElement eEle, String option,WebElement sOpsEle) throws InterruptedException
	{
		cEle.click();
		Thread.sleep(1000);
		eEle.sendKeys(option);
		Thread.sleep(1000);
		sOpsEle.click();
	}
	public static void scrollPage(int ftomValue, int toValue)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+ftomValue+","+toValue+")", "");
	}

	public static void waitTillElementClickable(WebElement xpath)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(xpath));
		ele.click();
	}

}
