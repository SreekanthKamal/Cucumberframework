package com.qa.stepdefinitions;

import java.util.HashMap;

import org.testng.Assert;

import com.qa.helper.TestBase;
import com.qa.helper.TestUtil;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import junit.framework.Assert;

public class Stepdefs extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	HashMap<String, String> testData = new HashMap<String, String>();

	/*@Given("^User Opens Browser$")
	public void user_Opens_Browser() throws Throwable {
		TestBase.intialization();
	}*/

	@When("^User Is On LoginPage$")
	public void user_Is_On_LoginPage() throws Throwable {
		loginPage = new LoginPage();
		testData = TestUtil.readTestDataFromJson("ID-4209");
		String PageTitle = loginPage.validateLoginPageTitle();
		Assert.assertEquals(PageTitle, testData.get("pageTitle"));
	}

	@When("^User Enters Username And Password and Clicks On Login Button$")
	public void user_Enters_Username_And_Password() throws Throwable {
		loginPage.loginMethod(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Then("^Validate OrangeHRM HomePage$")
	public void validate_OrangeHRM_HomePage() throws Throwable {
		homePage = new HomePage();
		String homePageTitle = homePage.verifyPageTitle();
		Assert.assertEquals(homePageTitle, testData.get("pageTitle"));
		Assert.assertTrue(homePage.verifyOrangeHRMLogo());
	}
	
	@Then("^Validate Dashboard Tab In HomePage$")
	public void validate_DashboardTabIn_HomePage() throws Throwable {
		homePage = new HomePage();
		boolean status = homePage.verifyDashboardTab();
		Assert.assertEquals(status,false); 
	}
}
