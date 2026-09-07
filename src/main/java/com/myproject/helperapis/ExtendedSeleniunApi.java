package com.myproject.helperapis;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.myproject.utils.ReportGenerator;

public class ExtendedSeleniunApi {
	private Configuration config = Configuration.getConfigurationInstance();
	private ReportGenerator report = ReportGenerator.getReportGenerator();
	private WebDriver driver = config.getDriver();
	public WebDriverWait wait = config.getWait(driver, 30);

	/**
	 * This method is used to perform the click functionality on the given element
	 * 
	 * @param element, element name and optional parameter to take screenshot(by
	 *                 default it is false.
	 */
	public void clickOnElement(WebElement element, String elementName, boolean... takesceenshot) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			if (takesceenshot.length < 1) {
				takesceenshot = new boolean[1];
				takesceenshot[0] = false;
			}

			if (takesceenshot[0])
				report.info("Click on Element: " + elementName, true);
			else
				report.info("Click on Element: " + elementName, false);

		} catch (StaleElementReferenceException e) {
		} catch (Exception e) {
			report.fail(e.getMessage());
		}
	}
	
	public void clickOnElementUsingJavaScriptExecutor(WebElement element, String elementName, boolean... takesceenshot) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			if (takesceenshot.length < 1) {
				takesceenshot = new boolean[1];
				takesceenshot[0] = false;
			}

			if (takesceenshot[0])
				report.info("Click on Element: " + elementName, true);
			else
				report.info("Click on Element: " + elementName, false);

		} catch (StaleElementReferenceException e) {
		} catch (Exception e) {
			report.fail(e.getMessage());
		}
	}

	/*
	 * Get element by ID
	 * 
	 * @return type: WebElement
	 */

	public WebElement getWebElementByID(String elementID) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(elementID)));
			return driver.findElement(By.id(elementID));
		} catch (Exception e) {
			report.fail(e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	/*
	 * Get element by Xpath
	 * 
	 * @return type: WebElement
	 */
	public WebElement getWebElementByXpath(String elementXpath) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
			return driver.findElement(By.xpath(elementXpath));
		} catch (Exception e) {
			report.fail(e.getMessage());
			e.printStackTrace();
			return null;
		}

	}
	
	public List<WebElement> getWebElementsByXpath(String elementXpath) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
			return driver.findElements(By.xpath(elementXpath));
		} catch (Exception e) {
			report.fail(e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * This method is used to perform the click functionality on the given element
	 * 
	 * @param element, input Text, Element name, and optional parameter to take
	 *                 screenshot(by default it is false.
	 */
	public void inputText(WebElement element, String inputText, String elementName, boolean... takesceenshot) {
		try {

			element.sendKeys(inputText);

			if (takesceenshot.length < 1) {
				takesceenshot = new boolean[1];
				takesceenshot[0] = false;
			}

			if (takesceenshot[0])
				report.info("Input '" + inputText + "' in " + elementName, takesceenshot[0]);
			else
				report.info("Input '" + inputText + "' in " + elementName, takesceenshot[0]);

		} catch (StaleElementReferenceException e) {
		} catch (Exception e) {
			report.fail(e.getMessage());
		}
	}
	
	public void clearTextBox(WebElement element) {
		try {

			element.clear();

		} catch (StaleElementReferenceException e) {
		} catch (Exception e) {
			report.fail(e.getMessage());
		}
	
	}

	/*
	 * Get text of element
	 * 
	 * @return type: String
	 */
	public String getTextOfElement(WebElement element) {
		try {

			return element.getText();

		} catch (StaleElementReferenceException e) {
			return null;
		} catch (Exception e) {
			report.fail(e.getMessage());
			return null;
		}
	}

	public Point getLocationOfElement(WebElement element) {
		try {

			return element.getLocation();

		} catch (StaleElementReferenceException e) {
			return null;
		} catch (Exception e) {
			report.fail(e.getMessage());
			return null;
		}
	}
		
	public String getBackgroundColourOfElement(WebElement element) {
		try {
			return element.getCssValue("background-color");
		} catch (StaleElementReferenceException e) {
			return null;
		} catch (Exception e) {
			report.fail(e.getMessage());
			return null;
		}
	}
	
	public String getColourOfElement(WebElement element) {
		try {
			return element.getCssValue("color");
		} catch (StaleElementReferenceException e) {
			return null;
		} catch (Exception e) {
			report.fail(e.getMessage());
			return null;
		}
	}
	
	public void closeOtherWindowsAndSwitchToMainWindow(String windowName) {
		Set<String> allWindows = driver.getWindowHandles();
		
		for (String window : allWindows){
			if (!window.equals(windowName)) {
				driver.switchTo().window(window);
				driver.close();
			}
		}
		driver.switchTo().window(windowName);
	}
	
	public void switchToChildWindowFromParrent(String windowName) {
		Set<String> allWindows = driver.getWindowHandles();
		
		for (String window : allWindows){
			if (!window.equals(windowName)) {
				driver.switchTo().window(window);
			}
		}
	}
	
	public void closeMainWindowsAndSwitchToNewWindow(String windowName) {
		Set<String> allWindows = driver.getWindowHandles();
		String childWindow = "";
		
		for (String window : allWindows){
			if (window.equals(windowName)) {
				driver.switchTo().window(window);
				driver.close();
			}
			else {
				childWindow = window;
			}
		}
		driver.switchTo().window(childWindow);
	}
	
	
	public void moveToWebElement(WebElement element, String elementName, boolean... takesceenshot) {
		try {
			
			Actions action = new Actions(driver);
			action.moveToElement(element);
			action.perform();
			if (takesceenshot.length < 1) {
				takesceenshot = new boolean[1];
				takesceenshot[0] = false;
			}

			if (takesceenshot[0])
				report.info("Move to: " + elementName, true);
			else
				report.info("Move to: " + elementName, false);

		} catch (StaleElementReferenceException e) {
		} catch (Exception e) {
			report.fail(e.getMessage());
		}
	}
	
	public boolean checkIfElementIsChecked(WebElement element) {
		try {

			return element.isSelected();

		} catch (StaleElementReferenceException e) {
			return false;
		} catch (Exception e) {
			report.fail(e.getMessage());
			return false;
		}
	}
	
	public void scrollDownPage() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
	}
}
