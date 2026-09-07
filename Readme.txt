Reason for choosing BDD(Gherkin), TestNG:

1. Feature file of gherkin provides more readability to any non technical user to understand what automation tests are being performed.
2. Steps defination provides more usability of code in better way.
3. Anyone can easily adapt it as its very easy to understand with having basic JAVA and Selenium knowledge.
4. TestNG provides simplest way to upgrade the framework to any webdriver by using parameterisation.(To Add any browser, mobile driver etc)
5. Using testNG , we can easily acheive parellal execution.
6. For Reporting Extent report provides a clear view of test results.


Installation:
1. Install Eclipse.
2. Import project.
3. Through eclipse marketspace install these 2 softwares:
	a. Cucumber
	b. TestNG

Run the script:

1. There is on properties file "myproject_configs.properties" under src/test/resources/ConfigFiles. Provide the username and password details to this file.
2. To run the script just Right click on the TestNG.xml file and run as TestNG.


OTher comments:

1. This is just start of the framework design, there will more inhancement to this as when we will start working on this ahead.
2. Report will be generated in "target\ExtentReport\BDD_AutomationTestResport.html".
3. Will work on this framework to run through command line using maven test command.