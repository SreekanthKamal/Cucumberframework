package com.qa.stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.log4testng.Logger;

import com.qa.helper.TestBase;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends TestBase {

	//Logger log = Logger.getLogger(Hooks.class);

	// global hooks applicable for all scenarios
	@Before
	public void setup() throws Exception {
		System.out.println("Launching the URL");
		intialization();
	}

	@After
	public void endSession(Scenario scenario) throws Exception {
		if (scenario.isFailed()) {
				try {
					//log.info(scenario.getName() + " is Failed");
					final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
					scenario.embed(screenshot, "image/png");
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				try {
					//log.info(scenario.getName() + " is Pass");
					final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
					scenario.embed(screenshot, "image/png");
				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
		TerminateBrowser();
		System.out.println("Terminating the Session");
	}

	/*// local hooks applicable for a single scenario
	@Before("@ID-4209")
	public void preConditionForParticularTestCase() throws Exception {
		System.out.println("Define precond for particular scenario");
	}

	@After("@ID-4209")
	public void postCondtionForParticularTestCase() throws Exception {
		System.out.println("Define post condition for particular scenario");
	}*/
}
