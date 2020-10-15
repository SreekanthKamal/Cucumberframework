package com.qa.Runner;

import java.io.File;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;



@CucumberOptions(
		features ={"./src/main/java/com/qa/features/Login.Feature"}, 
		glue ={"com/qa/stepdefinitions"},
		tags = {"@SmokeTest"}, 
        format = {
                "pretty",
              //  "html:target/cucumber-reports/cucumber-pretty",
               // "json:target/cucumber-reports/CucumberTestReport.json",
               // "rerun:target/cucumber-reports/rerun.txt"
        },plugin = "json:target/cucumber-reports/CucumberTestReport.json")

public class TestRunner {
    private TestNGCucumberRunner testNGCucumberRunner;
 
    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
 
    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }
 
    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }
    
   /* @AfterClass(alwaysRun = true)
    private static void generateReport(File reportFolder, File outputFolder) throws Exception {
    	  File rd = new File(outputFolder + "/cucumber-html-reports");
    	  List<String> jsonFileList = findJsonReports(reportFolder);
    	  System.out.println("About to generate Cucumber Report into: " + rd.getAbsoluteFile());
    	  Configuration configuration = new Configuration(rd, "cucumber-jvm");
    	  ReportBuilder reportBuilder = new ReportBuilder(jsonFileList, configuration);
    	  reportBuilder.generateReports();
    	  System.out.println("Finished generating Cucumber Report into: " + rd.getAbsoluteFile());
    	}*/

    
    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }
}