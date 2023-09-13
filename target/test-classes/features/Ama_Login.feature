
Feature: Validate Login feature of amazon website

Scenario: Title of the page
    Given User to open the website in browser
    And click on signin button
    When User gets the title of the page
    Then page title should be "Amazon Sign In"
  
  Scenario: Forget password link
    Given User to open the website in browser
    And click on signin button
    When User enters the phonenumber "+919543895433" and click on next
    Then forget password link should be dispalyed
    
    
  Scenario: Title of the page
    Given User to open the website in browser
    And click on signin button
    When I login with correct credentials where user name is "+919543895433" and password is "Gokul@20" 
    And User should get the title of the homepage
    Then Homepage title should be "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"


