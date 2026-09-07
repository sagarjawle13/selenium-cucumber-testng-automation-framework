package com.myproject.objectsrepository;

import org.openqa.selenium.StaleElementReferenceException;

import com.myproject.helperapis.ExtendedSeleniunApi;
import com.myproject.utils.ReportGenerator;

public class PacktLoginPage extends ExtendedSeleniunApi {

	final String USERNAME_INPUT_ID = "login-input-email";
	final String PASSWORD_INPUT_ID = "login-input-password";
	final String SIGNIN_BUTTON_XPATH = "//button//span[contains(text(),'Sign In')]";

	public void inputUserName(String userName) {
		inputText(getWebElementByID(USERNAME_INPUT_ID), userName, "User name");
	}

	public void inputPassword(String password) {
		try {

			getWebElementByID(PASSWORD_INPUT_ID).sendKeys(password);
			ReportGenerator.getReportGenerator().info("Input ************ as Password",false);

		} catch (StaleElementReferenceException e) {
		} catch (Exception e) {
			ReportGenerator.getReportGenerator().fail(e.getMessage());
		}

	}

	public void clickSignInButton() {
		clickOnElement(getWebElementByXpath(SIGNIN_BUTTON_XPATH), "Sign In Button");
	}

}
