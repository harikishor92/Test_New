package com.alberta.qa.Util;
import java.sql.*;

import com.alberta.qa.Base.BaseTest;
public class MYSQLConnection extends BaseTest{
	public void dataBase(String tableName,String userName) {
		final String JDBC_Driver = prob.getProperty("DB_DriverName");
		final String JDBC_URL = prob.getProperty("DB_URL");
		final String JDBC_USERName = prob.getProperty("DB_UserName");
		final String JDBC_Password = prob.getProperty("DB_Password");
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_Driver);
			System.out.println("Driver is loaded");
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USERName, JDBC_Password);
				System.out.println("Connection  is estiblished");
				stmt = con.createStatement();
				System.out.println("Statement  is created");
				String Query = "select * from "+tableName+" where username = '"+userName+"';";
				ResultSet rs = stmt.executeQuery(Query);
				System.out.println("Query  is executed");
				System.out.println("Results are : ");
				
				while(rs.next())
				{
					System.out.println(rs.getInt(1) +" , "+ rs.getString(2)+" , "+rs.getString(3)+" , "+rs.getInt(4));
				}
				
			} catch (SQLException e) {
				System.out.println("Connection  is not estiblished");
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Driver is not loaded");
			e.printStackTrace();
		}finally
		{
			try {
				con.close();
				System.out.println("Connection is closed");
			} catch (SQLException e) {
				System.out.println("Connection is not closed");
				e.printStackTrace();
			}
		}
	
	}
	
	public void writeDBQuery(String writeQuery)
	{
		//final String JDBC_Driver = "com.mysql.cj.jdbc.Driver";   //"com.mysql.jdbc.Driver";
		//final String JDBC_URL = "jdbc:mysql://arohamysqlrds.cvc8b2isrkrv.us-west-2.rds.amazonaws.com:3306/test_capability";
		//final String JDBC_USERName = "capability";
		//final String JDBC_Password = "ArohCapability!2019";
		final String JDBC_Driver = prob.getProperty("DB_DriverName");
		final String JDBC_URL = prob.getProperty("DB_URL");
		final String JDBC_USERName = prob.getProperty("DB_UserName");
		final String JDBC_Password = prob.getProperty("DB_Password");
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_Driver);
			System.out.println("Driver is loaded");
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USERName, JDBC_Password);
				System.out.println("Connection  is estiblished");
				stmt = con.createStatement();
				System.out.println("Statement  is created");
				//String Query = "select * from "+tableName+" where username = '"+userName+"';";
				ResultSet rs = stmt.executeQuery(writeQuery);
				System.out.println("Query  is executed");
				System.out.println("Results are : ");
				
				while(rs.next())
				{
					System.out.println(rs.getInt(1) +" , "+ rs.getString(2)+" , "+rs.getString(3)+" , "+rs.getInt(4));
				}
				
			} catch (SQLException e) {
				System.out.println("Connection  is not estiblished");
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Driver is not loaded");
			e.printStackTrace();
		}finally
		{
			try {
				con.close();
				System.out.println("Connection is closed");
			} catch (SQLException e) {
				System.out.println("Connection is not closed");
				e.printStackTrace();
			}
		}
	}
	
	

}
