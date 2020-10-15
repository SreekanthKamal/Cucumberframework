package com.qa.pages;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.helper.TestBase;

public class LoginPage extends TestBase {

	@FindBy(id = "txtUsername")
	WebElement txtUsername;

	@FindBy(id = "txtPassword")
	WebElement txtPassword;

	@FindBy(id = "btnLogin")
	WebElement btnLogIn;

	@FindBy(id = "logInPanelHeading")
	WebElement lblLoginPanel;

	// Intialize all the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateLoginPageTitle() throws Exception {
		return driver.getTitle();
	}

	public Boolean validateLoginForm() throws Exception {
		return lblLoginPanel.isDisplayed();
	}

	/*
	 * @Author Sreekanth
	 * @purpose Login In application
	 * @throws Exception
	 */
	public /*HomePage*/void loginMethod(String uname,String pwd) throws Exception {
		txtUsername.sendKeys(uname);
		txtPassword.sendKeys(pwd);
		//btnLogIn.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btnLogIn);
		
		//return new HomePage();
	}
}
