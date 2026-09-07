package com.myproject.stepdefinations;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.myproject.helperapis.Configuration;
import com.myproject.objectsrepository.PacktBooksAndVideosSearchLibraryPage;
import com.myproject.utils.Assertions;
import com.myproject.utils.ReportGenerator;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class PacktBooksAndVideosLibSteps extends PacktBooksAndVideosSearchLibraryPage{
	private Configuration config = null;
	private ReportGenerator report = null;
	private WebDriver driver = null;
	public WebDriverWait wait = null;
	

	public PacktBooksAndVideosLibSteps() {
		config = Configuration.getConfigurationInstance();
		report = ReportGenerator.getReportGenerator();
		driver = config.getDriver();
		wait = config.getWait(driver, 100);
	}
	
	@Then("I will be navigated to search result page of {string} Product and {string} category for {string} page")
	public void iWillBeNavigatedToSearchResultPageOfProductAndCategoryForPage(String productType, String category, String searchText) {

		String currentWindow = driver.getWindowHandle();
		
		
	    Assertions.assertTrue(checkIfElementIsChecked(getWebElementByXpath(getProductTypeCheckBoxXpath(productType))), "Product type "+productType+" is not checked");
	    Assertions.assertTrue(checkIfElementIsChecked(getWebElementByXpath(getCategoryCheckBoxXpath(category))), "Category "+category+" is not checked");
	    
	    List<WebElement> searchResultElements = getWebElementsByXpath(getSearchResultXpath(searchText));
	    
	    if (searchResultElements.size()>1)
	    	report.pass("User has navigated to search result for "+searchText+" Product "+productType+" Category "+category, true);
	    else
	    	report.fail("User is not navigated to search result for "+searchText+" Product "+productType+" Category "+category);
	    
	    closeMainWindowsAndSwitchToNewWindow(currentWindow);
	}
	

	@Then("I will be navigated to Search programming and development ebooks and videos page")
	public void iWillBeNavigatedToSearchProgrammingAndDevelopmentEbooksAndVideosPage() {
		wait.until(ExpectedConditions.titleContains("Programming & Development eBooks & Videos | Packt Subscription"));
		report.pass("Navigated to '"+driver.getTitle()+"' page", true);
	}

	@When("I clear all the filters")
	public void iClearAllTheFilters() {
	    // Write code here that turns the phrase above into concrete actions
	    clearAllFiler();
	}

	@When("I set year to {string}")
	public void iSetYearTo(String year) {
	    // Write code here that turns the phrase above into concrete actions
		selectYear(year);
	}

	@Then("I search for following texts and verify results")
	public void iSearchForFollowingTextsAndVerifyResults(DataTable dataTable) {
		
		String currentWindow = driver.getWindowHandle();
	    List<String> searchTexts = dataTable.asList(String.class);
	    
	    for (String search:searchTexts) {
	    	inputSearchTextInTextBox(search);
	    	List<WebElement> searchResultElements = getWebElementsByXpath(getSearchResultXpath(search));
	    		for(int i=0;i<searchResultElements.size();i++) {
	    			String titleOfSearchResult = searchResultElements.get(i).getText();
	    			if (titleOfSearchResult.contains(search))
	    				Assertions.assertTrue(true, "Search result contains Text: "+search);
	    			else
	    				Assertions.assertTrue(false, "Search does not contain Text: "+search+ " and is '"+titleOfSearchResult+"'");
	    		}
	    	clearSearchTextInTextBox();
	    }
	    
	    closeMainWindowsAndSwitchToNewWindow(currentWindow);
	}

}
