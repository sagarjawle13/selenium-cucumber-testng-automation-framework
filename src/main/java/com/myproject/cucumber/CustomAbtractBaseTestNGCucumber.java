package com.myproject.cucumber;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.myproject.helperapis.Configuration;
import com.myproject.utils.ReportGenerator;

import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

/**
 * This is Customised Cucumber test runner class.
 * This has been customised to perform all our configurations before the framework test execution starts.
 * Runs each cucumber scenario found in the features as separated test
 */
public abstract class CustomAbtractBaseTestNGCucumber {
    private TestNGCucumberRunner testNGCucumberRunner;
    private Configuration config = Configuration.getConfigurationInstance();
    private ReportGenerator reporter = null;
    public static Process process= null;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
    	config.setPropertyFile("myproject_configs.properties");
		config.setWebDriver();
    	reporter = ReportGenerator.getReportGenerator();
    	reporter.setUpReport();
  
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void runScenario(PickleEventWrapper pickleWrapper, CucumberFeatureWrapper featureWrapper) throws Throwable {
        // the 'featureWrapper' parameter solely exists to display the feature file in a test report
        testNGCucumberRunner.runScenario(pickleWrapper.getPickleEvent());
    }

    /**
     * Returns two dimensional array of PickleEventWrapper scenarios with their associated CucumberFeatureWrapper feature.
     *
     * @return a two dimensional array of scenarios features.
     */
    @DataProvider
    public Object[][] scenarios() {
        if (testNGCucumberRunner == null) {
            return new Object[0][0];
        }
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        if (testNGCucumberRunner == null) {
            return;
        }
        testNGCucumberRunner.finish();
        config.driver.close();
    }
}
