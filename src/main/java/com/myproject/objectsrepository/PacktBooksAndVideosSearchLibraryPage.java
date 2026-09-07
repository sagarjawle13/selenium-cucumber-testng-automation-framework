package com.myproject.objectsrepository;

import com.myproject.helperapis.ExtendedSeleniunApi;

public class PacktBooksAndVideosSearchLibraryPage extends ExtendedSeleniunApi{
	
//	private final String PRODUCT_BOOK_FILTER_CHECKBOX_XPATH = "//li[@id='product_type']//div//label[@for='book']/input";
//	private final String CATEGORY_DATA_FILTER_CHECKBOX_XPATH = "//li[@id='category']//div//label[@for='data']/input";
	private String searchResultXpath = "//div[@class='ais-hits--item search-hit']//h2/em[contains(text(),'search_text')]/..";
	
	private final String CLEAR_ALL_FILTER_XPATH = "//div//span[normalize-space()='Clear all']";
	
	private String productionYearCheckBoxXpath = "//li[@id='published_year']//div//label[contains(normalize-space(),'year_value')]/input";
	private String productTypeCheckBoxXpath =  "//li[@id='product_type']//div//label[contains(normalize-space(),'product_name')]/input";
	private String categoryCheckBoxXpath =  "//li[@id='category']//div//label[contains(normalize-space(),'category_value')]/input";
	private final String SEARCH_INPUT_ID = "search-input";
	
	
//	private Map<String, String> productCheckXpaths = new HashMap<String, String>()
//	{{
//		put("Book","//li[@id='product_type']//div//label[@for='book']/input");
//		put("Video","//li[@id='product_type']//div//label[@for='video']/input");
//		put("Path","//li[@id='product_type']//div//label[@for='learning-path']/input");
//	}};
//	
//	private Map<String, String> categoryCheckXpaths = new HashMap<String, String>()
//	{{
//		put("Data","//li[@id='category']//div//label[@for='data']/input");
//		put("Web development","//li[@id='category']//div//label[@for='web-development']/input");
//		put("Programming","//li[@id='category']//div//label[@for='programming']/input");
//		put("Mobile","//li[@id='category']//div//label[@for='mobile']/input");
//		put("Business & other","//li[@id='category']//div//label[@for='business-and-other']/input");
//		put("Cloud & networking ","//li[@id='category']//div//label[@for='cloud-and-networking']/input");
//		
//	}};
//	
	
//	public String getPRODUCT_BOOK_FILTER_CHECKBOX_XPATH() {
//		return PRODUCT_BOOK_FILTER_CHECKBOX_XPATH;
//	}
//	public String getCATEGORY_DATA_FILTER_CHECKBOX_XPATH() {
//		return CATEGORY_DATA_FILTER_CHECKBOX_XPATH;
//	}
	
	public String getCLEAR_ALL_FILTER_XPATH() {
		return CLEAR_ALL_FILTER_XPATH;
	}
	
	public String getSearchResultXpath(String searchText) {
		return searchResultXpath.replaceAll("search_text", searchText);
	}
	


	public String getProductionYearCheckBoxXpath(String year) {
		return productionYearCheckBoxXpath.replaceAll("year_value", year);
	}

	public String getProductTypeCheckBoxXpath(String productName) {
		return productTypeCheckBoxXpath.replaceAll("product_name", productName);
	}

	public String getCategoryCheckBoxXpath(String category) {
		return categoryCheckBoxXpath.replaceAll("category_value", category);
	}

	public String getSEARCH_INPUT_ID() {
		return SEARCH_INPUT_ID;
	}
	
	

//	public String  getProductCheckXpaths(String productName) {	
//		return productCheckXpaths.get(productName);
//	}
//	public String getCategoryCheckXpaths(String categoryName) {
//		return categoryCheckXpaths.get(categoryName);
//	}
//	
	
	
	public void clearAllFiler() {
		clickOnElement(getWebElementByXpath(CLEAR_ALL_FILTER_XPATH), "Clear All filter button");
	}
	
	public void selectYear(String year) {
		clickOnElement(getWebElementByXpath(getProductionYearCheckBoxXpath(year)), year+" checkbox");
	}
	
	public void inputSearchTextInTextBox(String searchText) {
		inputText(getWebElementByID(SEARCH_INPUT_ID), searchText, "Search text inputbox");
	}
	
	public void clearSearchTextInTextBox() {
		clearTextBox(getWebElementByID(SEARCH_INPUT_ID));
	}

}
