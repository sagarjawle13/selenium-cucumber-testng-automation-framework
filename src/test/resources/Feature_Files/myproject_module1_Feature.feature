#Author: sagarjalwle.qa@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Packt Application Verificaiton and Validation

  @tag1
  Scenario: Verify that all the elements on the page are correct
    Given I am on home page of packt application
    When I verify the elements on homepage
		Then verification should be successfull
	
 #For this below scenario please provide the data input text matching same as on UI(Case sensitive)
	@tag1	
	Scenario Outline: Verify that all the options from the Browse menu go to correct pages
		Given I am on home page of packt application
		And I click on "<top_menu>" top menu
		When I select "<book_name>" Book From "<category_name>" category of browse menu
		Then I will be navigated to search result page of "<navigate_product>" Product and "<navigate_category>" category for "<search_text>" page
		Examples:
		| top_menu | book_name | category_name | navigate_product | navigate_category |search_text |
		| Browse | Python | Data | Book | Data |Python |
		| Browse | JavaScript | Web Development | Book | Web development |JavaScript |
		
 #I have just written small wrapper to check the 1st value of main title. To validate the all the values of title can create excelsheet for data input.
	@tag1
  Scenario: Verify that Your Suggested Title section populated correct data as per main title
    Given I am on home page of packt application
    When I click "Current Status of Python" title of your suggested title
		Then Subtiles contain "Current Status of Python" of main title "Current Status of Python"
		
	@tag1
	Scenario: Verify that user s able to search the details and get valid results
		Given I am on home page of packt application
    And I click on "Browse" top menu
		And I click on View all Books menu
		Then I will be navigated to Search programming and development ebooks and videos page
		When I clear all the filters
		And I set year to "2021"
		Then I search for following texts and verify results
		|Python|Paint|Secure|Tableau|
		
		

