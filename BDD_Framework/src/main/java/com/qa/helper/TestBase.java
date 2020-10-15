package com.qa.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			String environment = "qa";
			FileInputStream fis = new FileInputStream(
					"./src/main/java/com/qa/config/"+environment+".properties");
			prop.load(fis);

		} catch (IOException e) {
			e.getMessage();
		}
	}
	
	public static void intialization() throws Exception{
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecho.driver", "./Drivers/gechodriver.exe");
			//driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	public static void TerminateBrowser() throws Exception{
		driver.quit();		
	}
}
