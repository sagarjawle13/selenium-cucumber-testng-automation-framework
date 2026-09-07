package com.myproject.utils;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.myproject.helperapis.Configuration;

/*
 * This a singleton class to provide reporting utility to the framework.
 */

public class ReportGenerator {

	 ExtentTest parrentTest;
	 ExtentReports extentReport;

	private  WebDriver driver;
	private  String newReportFileName = "";
	
	private  ExtentHtmlReporter htmlReporter;
	
	private  ExtentTest childTest;
	private static ReportGenerator reporter = null;
	
	private Configuration config = Configuration.getConfigurationInstance();
	

	private ReportGenerator() {
		 driver = config.getDriver();
	}

	public static ReportGenerator getReportGenerator() {
		if(reporter == null) {
			reporter= new ReportGenerator();
			return reporter;
		}
		else 
			return reporter;
	}

	/**
	 * Use to display the start of exeution of test.
	 * @param scenario_name
	 */
	public void startTest(String scenario_name) {
		childTest = parrentTest.createNode(scenario_name);
		childTest.log(Status.INFO, "Starting test: " + scenario_name);
		System.out.println("Starting test: " + scenario_name);
	}

	/**
	 * initialize the object of ExtentReports class.
	 */
	public void initializeReport(String newTestName) {
		if (!newReportFileName.equals(newTestName)){
			parrentTest = extentReport.createTest(newTestName);
			newReportFileName = newTestName;	
		}
	}
	
	public void setUpReport(){
		extentReport = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter("F:\\TestAutomation_VG\\BDD_TestAutomation\\target\\ExtentReport\\BDD_AutomationTestReport.html");
		extentReport.attachReporter(htmlReporter);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		 htmlReporter.config().setChartVisibilityOnOpen(true);
		 htmlReporter.config().setTheme(Theme.DARK);
		 htmlReporter.config().setDocumentTitle("BDD Automation Framework");
		 htmlReporter.config().setEncoding("utf-8");
		 htmlReporter.config().setReportName("BDD Automation Framework Test Report");
		 

	}

	/**
	 * This method is used to log the info message if any during the execution
	 * 
	 * @param log_message
	 * @param take_screenshot
	 */
	public void info(String log_message, boolean take_screenshot) {
		try {
			if (take_screenshot) {
				String screenshotPath = takeScreenShot(driver);
				System.out.println("INFO: " + log_message);
				childTest.log(Status.INFO, log_message, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

			} else {
				childTest.log(Status.INFO, log_message);
				System.out.println("INFO: " + log_message);
			}
		} catch (Exception io) {
			io.printStackTrace();
		}
	}

	/**
	 * This method is used to log the pass message of unit testing if any during
	 * the execution
	 * 
	 * @param log_message
	 * @param take_screenshot
	 */
	public void pass(String log_message, boolean take_screenshot) {
		try {
			if (take_screenshot) {
				String screenshotPath = takeScreenShot(driver);
				System.out.println("PASS: " + log_message);
				childTest.log(Status.PASS, log_message, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} else {
				childTest.log(Status.PASS, log_message);
				System.out.println("PASS: " + log_message);
			}
		} catch (Exception io) {
			io.printStackTrace();
		}
	}

	/**
	 * This method is used to log the fail message if any during the execution
	 * 
	 * @param log_message
	 */
	public void fail(String log_message) {
		try {
			String screenshotPath = takeScreenShot(driver);
			System.out.println("FAIL: " + log_message);
			childTest.log(Status.FAIL, log_message, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			Assert.fail(log_message);
		} catch (Exception io) {
			io.printStackTrace();
		}
	}

	/**
	 * This method is used to log the error message if any during the execution
	 * of text cases.
	 * 
	 * @param log_message
	 * @param take_screenshot
	 */
	public void error(String log_message, boolean take_screenshot) {
		try {
			if (take_screenshot) {
				String screenshotPath = takeScreenShot(driver);
				System.out.println("ERROR: " + log_message);
				childTest.log(Status.ERROR, log_message, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} else {
				childTest.log(Status.ERROR, log_message);
				System.out.println("ERROR: " + log_message);
			}
		} catch (Exception io) {
			io.printStackTrace();
		}
	}

	/**
	 * This method is used to log the warning message if any during the
	 * execution of test cases.
	 * 
	 * @param log_message
	 * @param take_screenshot
	 */
	public void warning(String log_message, boolean take_screenshot) {
		try {
			if (take_screenshot) {
				String screenshotPath = takeScreenShot(driver);
				System.out.println("WARNING: " + log_message);
				childTest.log(Status.WARNING, log_message, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} else {
				childTest.log(Status.WARNING, log_message);
			}
		} catch (Exception io) {
			io.printStackTrace();
		}
	}

	/**
	 * This method is used to the screenshot of test output.
	 * 
	 * @param driver
	 * @return
	 * @throws IOException
	 */
	private String takeScreenShot(WebDriver driver) throws IOException {
		// This function takes a screenshot on the local machine and then copies
		// it to
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "\\target\\ExtentReport\\Screenshots\\" + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	/**
	 * This method is used to confirm the execution of the test.
	 */
	public void endTest() {
//		report.endTest(test);
		extentReport.flush();
	}
	public void closeReport() {
		
		
//		report.close();
	}

}
