Feature: Account Page Feature

Background:
Given user has already logged in to application
|userID|password|
|+919543895433| Gokul@20|

@accounts
Scenario: Accounts page title
Given user is on Accounts page
When user gets the title of the page
Then page title should be "Your Account"

@accounts
Scenario: Accounts section count
Given user is on Accounts page
Then user gets accounts section
|Your Orders|
|Login & security|
|Prime|
|Contact Us|
