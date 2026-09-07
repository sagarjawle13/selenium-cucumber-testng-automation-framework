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
 * This class has methods to perform the initial and ending acicities for the application like launch url, login, logout etc.
 */
public class StartUp extends ExtendedSeleniunApi{
	private Configuration config = null;
	private WebDriver driver = null;
	public  WebDriverWait wait = null ;
	private PacktLoginPage loginPage = null;
	private PacktHomePage homePage = null;
	private ReportGenerator report = null;
	
	@FindBy(xpath="//settings-ui")
	private WebElement chromeSetting;
	
	public StartUp(){
		config = Configuration.getConfigurationInstance();
		driver = config.getDriver();
		wait = config.getWait(driver, 100) ;
		loginPage = new PacktLoginPage();
		homePage = new  PacktHomePage();
		report = ReportGenerator.getReportGenerator();
	}
	
	
	public void loginToPacktApplication(String url,String userName, String password) {
		try {

//			driver.get("chrome://settings/clearBrowserData");
//			driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);	 // This will clear the cache of application to avoid any failure in case of session is not stopped from previous execution.
			report.info("Launch URL: "+url, false);
			driver.get(url);
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
			report.fail("Unable to Open Browser" + e.toString());
		}
		loginPage.inputUserName(userName);
		loginPage.inputPassword(password);
		loginPage.clickSignInButton();
	}
	
	
}
