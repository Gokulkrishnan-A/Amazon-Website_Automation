Feature: Validate My Account feature of amazon website

Background:
	Given User is already logged in to the Application
	|  Username   | Password |
	|+919543895433| Gokul@20 |


Scenario: Account Page title
    Given User is on the Account Page 
    When User gets the title of the Account page
    Then Account page title should be "Your Account"
  
  Scenario: My Account scetion count
    Given User is on the Account Page 
    Then User gets the account section 
    |Your Orders|   
    |Login & security|
    |Prime|
    |Your Addresses|
    |Payment options|
    |Amazon Pay balance|
    |Contact Us|
    And The count of account section is 7 
            
            
            
            
            