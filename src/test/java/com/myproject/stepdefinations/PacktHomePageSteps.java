package com.myproject.stepdefinations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import com.myproject.helperapis.Configuration;
import com.myproject.objectsrepository.PacktHomePage;
import com.myproject.utils.Assertions;
import com.myproject.utils.ReportGenerator;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/*
 * This the page object class for Step definations for the Home page of the application. 
 */
public class PacktHomePageSteps extends PacktHomePage {
	private Configuration config = null;
	private ReportGenerator report = null;
	private WebDriver driver = null;
	public WebDriverWait wait = null;

	private boolean elementValidation = false;

	public PacktHomePageSteps() {
		config = Configuration.getConfigurationInstance();
		report = ReportGenerator.getReportGenerator();
		driver = config.getDriver();
		wait = config.getWait(driver, 100);
	}

	@Given("I am on home page of packt application")
	public void iAmOnHomePageOfPacktApplication() throws InterruptedException {

		wait.until(ExpectedConditions.titleContains("Packt Subscription | Advance your knowledge in tech"));

		String title = driver.getTitle();
		Assertions.assertEquals(title, "Packt Subscription | Advance your knowledge in tech",
				"Expected Title of page is 'Packt Subscription | Advance your knowledge in tech' but recieved :"
						+ title);

		report.pass("USer in on homepage.!", true);
	}

	@When("I verify the elements on homepage")
	public void iVerifyTheElementsOnHomepage() {
		String backgroundColor = "";
		String colour = "";
		Point point = null;

		backgroundColor = getBackgroundColourOfElement(getWebElementByXpath(getTopMenuOptionsXpath(ACCOUNT_MENU)));
		Assertions.assertEquals("rgba(0, 0, 0, 0)", backgroundColor,
				"Expected Backgroud color of Account menu is rgba(0, 0, 0, 0) but recieved:" + backgroundColor);

		backgroundColor = getBackgroundColourOfElement(getWebElementByID(getMAIN_LOGO_ID()));
		Assertions.assertEquals("rgba(0, 0, 0, 0)", backgroundColor,
				"Expected Backgroud color of Main Logo is rgba(0, 0, 0, 0) but recieved:" + backgroundColor);

		backgroundColor = getBackgroundColourOfElement(getWebElementByXpath(getTOP_SEARCH_BAR_XPATH()));
		Assertions.assertEquals("rgba(255, 255, 255, 1)", backgroundColor,
				"Expected Backgroud color of Top Search is rgba(255, 255, 255, 1) but recieved:" + backgroundColor);

		backgroundColor = getBackgroundColourOfElement(getWebElementByXpath(getTopMenuOptionsXpath(BROWSE_MENU)));
		Assertions.assertEquals("rgba(0, 0, 0, 0)", backgroundColor,
				"Expected Backgroud color of Browser menu is rgba(0, 0, 0, 0) but recieved:" + backgroundColor);

		backgroundColor = getBackgroundColourOfElement(getWebElementByXpath(getREAD_NOW_BUTTON_XPATH()));
		Assertions.assertEquals("rgba(236, 102, 17, 1)", backgroundColor,
				"Expected Backgroud color of Read now button is rgba(236, 102, 17, 1) but recieved:" + backgroundColor);

		backgroundColor = getBackgroundColourOfElement(getWebElementByXpath(getCHAPTERS_LIST_XPATH()));
		Assertions.assertEquals("rgba(36, 39, 46, 0.85)", backgroundColor,
				"Expected Backgroud color of Chapter list is rgba(36, 39, 46, 0.85) but recieved:" + backgroundColor);

		backgroundColor = getBackgroundColourOfElement(getWebElementByXpath(getTopMenuOptionsXpath(LIBRARY_MENU)));
		Assertions.assertEquals("rgba(0, 0, 0, 0)", backgroundColor,
				"Expected Backgroud color of Libraray menu is rgba(0, 0, 0, 0) but recieved:" + backgroundColor);

		// Now validate Colors of the elements

		colour = getColourOfElement(getWebElementByXpath(getTopMenuOptionsXpath(ACCOUNT_MENU)));
		Assertions.assertEquals("rgba(255, 255, 255, 1)", colour,
				"Expected color of Account menu is rgba(255, 255, 255, 1) but recieved:" + colour);

		colour = getColourOfElement(getWebElementByID(getMAIN_LOGO_ID()));
		Assertions.assertEquals("rgba(74, 185, 213, 1)", colour,
				"Expected color of Main Logo is rgba(74, 185, 213, 1) but recieved:" + colour);

		colour = getColourOfElement(getWebElementByXpath(getTOP_SEARCH_BAR_XPATH()));
		Assertions.assertEquals("rgba(0, 0, 0, 1)", colour,
				"Expected color of Top Search is rgba(0, 0, 0, 1) but recieved:" + colour);

		colour = getColourOfElement(getWebElementByXpath(getTopMenuOptionsXpath(BROWSE_MENU)));
		Assertions.assertEquals("rgba(255, 255, 255, 1)", colour,
				"Expected color of Browser menu is rgba(255, 255, 255, 1) but recieved:" + colour);

		colour = getColourOfElement(getWebElementByXpath(getREAD_NOW_BUTTON_XPATH()));
		Assertions.assertEquals("rgba(255, 255, 255, 1)", colour,
				"Expected color of Read now button is rgba(255, 255, 255, 1) but recieved:" + colour);

		colour = getColourOfElement(getWebElementByXpath(getCHAPTERS_LIST_XPATH()));
		Assertions.assertEquals("rgba(255, 255, 255, 1)", colour,
				"Expected color of Chapter list is rgba(255, 255, 255, 1) but recieved:" + colour);

		colour = getColourOfElement(getWebElementByXpath(getTopMenuOptionsXpath(LIBRARY_MENU)));
		Assertions.assertEquals("rgba(255, 255, 255, 1)", colour,
				"Expected color of Libraray menu is rgba(255, 255, 255, 1) but recieved:" + colour);

		// Now validate locations of the elements

		point = getLocationOfElement(getWebElementByXpath(getTopMenuOptionsXpath(ACCOUNT_MENU)));
		Assertions.assertEquals("(1217, 28)", point.toString(),
				"Expected location of Account menu is coordinates(1217, 28) but recieved:" + point.toString());

		point = getLocationOfElement(getWebElementByID(getMAIN_LOGO_ID()));
		Assertions.assertEquals("(49, 15)", point.toString(),
				"Expected location of Account menu is coordinates(49, 15) but recieved:" + point.toString());

		point = getLocationOfElement(getWebElementByXpath(getTOP_SEARCH_BAR_XPATH()));
		Assertions.assertEquals("(196, 17)", point.toString(),
				"Expected location of Top search bar is coordinates(196, 17) but recieved:" + point.toString());

		point = getLocationOfElement(getWebElementByXpath(getTopMenuOptionsXpath(BROWSE_MENU)));
		Assertions.assertEquals("(564, 28)", point.toString(),
				"Expected location of Browser menu is coordinates(564, 28) but recieved:" + point.toString());

		point = getLocationOfElement(getWebElementByXpath(getREAD_NOW_BUTTON_XPATH()));
		Assertions.assertEquals("(653, 205)", point.toString(),
				"Expected location of Read now is coordinates(653, 205) but recieved:" + point.toString());

		point = getLocationOfElement(getWebElementByXpath(getCHAPTERS_LIST_XPATH()));
		Assertions.assertEquals("(863, 175)", point.toString(),
				"Expected location of Chapter list is coordinates(863, 175) but recieved:" + point.toString());

		point = getLocationOfElement(getWebElementByXpath(getTopMenuOptionsXpath(LIBRARY_MENU)));
		Assertions.assertEquals("(1114, 28)", point.toString(),
				"Expected location of Library menu is coordinates(1114, 28) but recieved:" + point.toString());

		elementValidation = true;
	}

	@Then("verification should be successfull")
	public void verificationShouldBeSuccessfull() {
		if (elementValidation)
			report.pass("All the Elements on the screen verified!", true);
		else
			report.fail("Verification of home page elements failed.");
	}

	@Given("I click on {string} top menu")
	public void iClickOnTopMenu(String menuName) {
		// Write code here that turns the phrase above into concrete actions
		if (menuName.equals("Browse")) {
			clickTopMenu(BROWSE_MENU);
		} else if (menuName.equals("Account")) {
			clickTopMenu(ACCOUNT_MENU);
		} else if (menuName.equals("My Libraray")) {
			clickTopMenu(LIBRARY_MENU);
		} else {
			report.fail("Menu name should be Browse or Account or My Libraray");
		}
	}

	@When("I select {string} Book From {string} category of browse menu")
	public void iSelectBookFromCategoryOfBrowseMenu(String bookName, String categoryName) {
		// Write code here that turns the phrase above into concrete actions
		String parrentWindow = "";
		moveToWebElement(getWebElementByXpath(getBrowseMenuOptionsXpath(categoryName)), categoryName, true);
		List<WebElement> bookNameElements = getWebElementsByXpath(getBrowseMenuOptionsXpath(bookName));
		parrentWindow = driver.getWindowHandle();
		if (bookNameElements.size() > 0)
			clickOnElementUsingJavaScriptExecutor(bookNameElements.get(0), bookName);
		else
			report.fail("No Book name " + bookName + " available under category " + categoryName);

		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		switchToChildWindowFromParrent(parrentWindow);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("I click {string} title of your suggested title")
	public void iClickTitleOfYourSuggestedTitle(String mainTitle) {
		scrollDownPage();
		List<WebElement> element = driver.findElements(By.xpath(getYourSuggestedTitleXpath(mainTitle)));
		clickOnElement(element.get(0), mainTitle + "title", true);
	}

	@Then("Subtiles contain {string} of main title {string}")
	public void subtilesContainOfMainTitle(String subTitle, String mainTitle) {
		// Write code here that turns the phrase above into concrete actions
		List<WebElement> subTitles = getWebElementsByXpath(getYourSuggestedSubTitlesXpath(mainTitle));

		String actualSubTitle = subTitles.get(0).getText();
		Assertions.assertEquals(subTitle, actualSubTitle,
				"Main title '" + mainTitle + " contains " + actualSubTitle + " instead of " + subTitle);

		String allSubtitles = "";
		for (WebElement element : subTitles) {
			allSubtitles = allSubtitles + ", " + element.getText();
		}

		report.pass("All Sub titles of " + mainTitle + " are:" + allSubtitles, true);
	}

	@Given("I click on View all Books menu")
	public void iClickOnViewAllBooksMenu() {
		String parrentWindow = driver.getWindowHandle();
		clickViewAllBooks();
		switchToChildWindowFromParrent(parrentWindow);
	}

}
