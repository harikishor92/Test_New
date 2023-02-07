package com.alberta.qa.testcases;

public class TestCount {

	public static void main(String[] args) {
		int count = 60;
		double  a = 0;
		
		for (int i = 0; i<count; i++)
		{
			a = Math.pow(2,i);
		}
		System.out.println(a);

	}

}
