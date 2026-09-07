package com.myproject.objectsrepository;

import com.myproject.helperapis.ExtendedSeleniunApi;

public class PacktHomePage extends ExtendedSeleniunApi {
	public static  final String ACCOUNT_MENU = "Account";
	public static  final String LIBRARY_MENU = "Library";
	public static final String BROWSE_MENU = "Browse";
	
	private final String MAIN_LOGO_ID = "main-logo";
	private final String TOP_SEARCH_BAR_XPATH = "//input[@class='search-bar__input']";

	private final String READ_NOW_BUTTON_XPATH = "//button[text()='Read now']";
	private final String CHAPTERS_LIST_XPATH = "//div[starts-with(@class,'chapterList shadow')]";
	
	private final String LOGOUT_LIST_BUTTON_XPATH = "//li[text()='Logout']";
	private final String VIEW_ALL_BOOKS_XPATH = "//li[@class='menu__item']//li[contains(normalize-space(),'View All Books')]";
	
	private String browseMenuOptions = " //div//span[text()='menu_name']";
	private String topMenuOptions = "//li[@class='menu__item']//span[contains(text(),'top_menu_name')]";
	
	private String yourSuggestedTitleXpath = "//div[text()='main_title']";
//	private String youSuggestionSubTitleXpath = "//div[@class='collapse show']//a[text()='subtitle']";
	
//	private String yourSuggestedSubTitlesXpath = "//div[contains(text(),'main_title')]/../../following-sibling::div[@class='collapse show']//div/p/a";
	private String yourSuggestedSubTitlesXpath = "//div[text()='main_title']/../../following-sibling::div[@class='collapse show']//div/p/a";
	
	
	public String getMAIN_LOGO_ID() {
		return MAIN_LOGO_ID;
	}
	public String getTOP_SEARCH_BAR_XPATH() {
		return TOP_SEARCH_BAR_XPATH;
	}
	
	
	public String getREAD_NOW_BUTTON_XPATH() {
		return READ_NOW_BUTTON_XPATH;
	}
	public String getCHAPTERS_LIST_XPATH() {
		return CHAPTERS_LIST_XPATH;
	}
	public String getLOGOUT_LIST_BUTTON_XPATH() {
		return LOGOUT_LIST_BUTTON_XPATH;
	}

	public String getVIEW_ALL_BOOKS_XPATH() {
		return VIEW_ALL_BOOKS_XPATH;
	}
	public void clickLogOut() {
		clickOnElement(getWebElementByXpath(LOGOUT_LIST_BUTTON_XPATH), "Logout");
	}
	public String getBrowseMenuOptionsXpath(String menuName) {
		return browseMenuOptions.replaceAll("menu_name", menuName);
	}
	
	public void clickOnBrowseSubMenu(String browseSubMenuName) {
		clickOnElement(getWebElementByXpath(getBrowseMenuOptionsXpath(browseSubMenuName)), browseSubMenuName+" Submenu of Browse");
	}

	public String getTopMenuOptionsXpath(String topMenuName) {
		return topMenuOptions.replaceAll("top_menu_name", topMenuName);
	}
	
	public void clickTopMenu(String topMenuName) {
		clickOnElement(getWebElementByXpath(getTopMenuOptionsXpath(topMenuName)), topMenuName+" from Top Menu");
	}

	public String getYourSuggestedTitleXpath(String titleName) {
		return yourSuggestedTitleXpath.replaceAll("main_title", titleName);
	}
	
//	public String getYouSuggestionSubTitleXpath(String subTitle) {
//		return youSuggestionSubTitleXpath.replace("subtitle", subTitle);
//	}
	
	public String getYourSuggestedSubTitlesXpath(String mainTitle) {
		return yourSuggestedSubTitlesXpath.replace("main_title", mainTitle);
	}
	
	public void clickViewAllBooks() {
		clickOnElement(getWebElementByXpath(VIEW_ALL_BOOKS_XPATH), "View All Books menu");
	}
	
}
