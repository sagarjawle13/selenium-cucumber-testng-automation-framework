package com.myproject.utils;

import org.testng.Assert;

import com.myproject.helperapis.Configuration;

public class Assertions {
	
	public static void assertTrue(boolean result,String message){
		try{
			Assert.assertTrue(result);
		}
		catch (AssertionError e) {
			ReportGenerator.getReportGenerator().fail(message);
		}
	}
	
	public static void assertEquals(String actual, String expected,String message){
		try{
			Assert.assertEquals(actual, expected);
		}
		catch (AssertionError e) {
			ReportGenerator.getReportGenerator().fail(message);
		}
	}
	
	public static void assertFalse(boolean result,String message){
		try{
			Assert.assertFalse(result);
		}
		catch (AssertionError e) {
			ReportGenerator.getReportGenerator().fail(message);
		}
	}
	
	public static void assertNotEquals(String actual, String expected,String message){
		try{
			Assert.assertNotEquals(actual, expected);
		}
		catch (AssertionError e) {
			ReportGenerator.getReportGenerator().fail(message);
		}
	}
	
	public static void assertEquals(int actual, int expected,String message){
		try{
			Assert.assertEquals(actual, expected);
		}
		catch (AssertionError e) {
			ReportGenerator.getReportGenerator().fail(message);
		}
	}
}
