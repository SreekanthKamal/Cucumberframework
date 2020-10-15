package com.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.helper.TestBase;
import com.qa.helper.TestUtil;

public class HomePage extends TestBase {

	@FindBy(css = "img[alt='OrangeHRM']")
	@CacheLookup
	WebElement imgOrangeHrm;

	@FindBy(id = "menu_dashboard_index")
	WebElement tabDashboard;

	@FindBy(id = "Subscriber_link")
	WebElement lnkSubscribe;

	// Intializes all the HomePage WebElements
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyPageTitle() throws Exception {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		return driver.getTitle();
	}

	public Boolean verifyOrangeHRMLogo() throws Exception {
		return imgOrangeHrm.isDisplayed();
	}

	public Boolean verifyDashboardTab() throws Exception {
		return tabDashboard.isDisplayed();
	}

	public Boolean verifySubscribeLinkIsEnabled() throws Exception {
		return lnkSubscribe.isEnabled();
	}

}
