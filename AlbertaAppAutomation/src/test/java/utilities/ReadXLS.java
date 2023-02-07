package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadXLS {

	public static void main(String[] args)  {
		
	

	}
	public void getData(String excelSheetName) throws EncryptedDocumentException, IOException
	{
		File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\Alberta_testData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet("excelSheetName");
	}

}
