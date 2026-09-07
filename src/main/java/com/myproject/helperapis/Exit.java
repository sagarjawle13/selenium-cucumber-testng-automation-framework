package com.myproject.helperapis;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.myproject.objectsrepository.PacktHomePage;
import com.myproject.objectsrepository.PacktLoginPage;
import com.myproject.utils.ReportGenerator;
/*
 * This class has methods to perform the ending acicities for the application like launch url, login, logout etc.
 */
public class Exit extends ExtendedSeleniunApi{
	private Configuration config = null;
	private WebDriver driver = null;
	public  WebDriverWait wait = null ;
	private PacktLoginPage loginPage = null;
	private PacktHomePage homePage = null;
	private ReportGenerator report = null;
	
	@FindBy(xpath="//settings-ui")
	private WebElement chromeSetting;
	
	public Exit(){
		config = Configuration.getConfigurationInstance();
		driver = config.getDriver();
		wait = config.getWait(driver, 100) ;
		loginPage = new PacktLoginPage();
		homePage = new  PacktHomePage();
		report = ReportGenerator.getReportGenerator();
	}
	
		
	public void logOut() {
		String parrentWindow = driver.getWindowHandle();
		homePage.clickTopMenu(PacktHomePage.ACCOUNT_MENU);
		homePage.clickLogOut();
		closeMainWindowsAndSwitchToNewWindow(parrentWindow);

	}
	public void closeDriver(){
		driver.close();
	}
	public void quitDriver(){
		driver.quit();
	}
}
