package com.alberta.qa.testcases;

import org.testng.annotations.Test;

import com.alberta.qa.Util.MYSQLConnection;

public class DataBaseTest {
	MYSQLConnection db;
	
	@Test
	public void data()
	{
		System.out.println("dataBase Connection");
		db = new MYSQLConnection();
		db.dataBase("tbl_admin","admin");
		
	}
	
	@Test
	public void my()
	{
		System.out.println("writing query");
		db = new MYSQLConnection();
		db.writeDBQuery("select * from tbl_admin;");
	}

}
