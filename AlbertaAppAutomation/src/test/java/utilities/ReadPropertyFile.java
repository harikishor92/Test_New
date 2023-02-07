package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("E:\\Alberta_Project_Automation\\AlbertaAppAutomation\\src\\test\\resources\\configFile\\config.properties");
		Properties prop = new Properties();
		prop.load(fr);
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("url"));
		

	}

}
