package com.myproject.helperapis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.myproject.utils.ReportGenerator;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Configuration {

	public WebDriverWait wait;
	public  WebDriver driver;
	public  ReportGenerator reporter;
	public Properties properties;
	private final String propertyFilePath = "src/test/resources/ConfigFiles/";
//	private DesiredCapabilities capabilities = null;
	public static Process process;
	private static Configuration config = null;


	public void setReporter() {
		reporter = ReportGenerator.getReportGenerator();
//		Configuration.reporter.startTest("Test Login Scenario...");
	}

	private Configuration() {

	}
	
	public static Configuration getConfigurationInstance() {
		if(config == null) {
			config= new Configuration();
			return config;
		}
		else 
			return config;
	}

	public void setPropertyFile(String fileName) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath+fileName));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void setWebDriver() {
		System.setProperty("webdriver.edge.driver", "F:\\TestAutomation_VG\\msedgedriver.exe");
		WebDriverManager.edgedriver().setup();
//		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1280x1024");
		options.setExperimentalOption("useAutomationExtension", false);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome (); 
		capabilities.setCapability (CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.merge(capabilities);
//		driver = new ChromeDriver(options);
		
		
	    ChromeOptions chromeOptions = new ChromeOptions();
	    chromeOptions.setBinary("F:\\TestAutomation_VG\\msedgedriver.exe");
//	                "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
	    EdgeOptions edgeOptions = (EdgeOptions) new EdgeOptions().merge(chromeOptions);
	    driver = new EdgeDriver();
	    
	    //WebDriverManager.edgedriver().setup();
		//driver= new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.get(properties.getProperty("URL"));
		driver.manage().window().maximize();
	}
	
	public WebDriverWait getWait(WebDriver driver,int waitTimer) {
		wait = new WebDriverWait(driver, waitTimer);
		return wait;
	}

	
	public WebDriver getDriver(){
		return driver;
	}

}