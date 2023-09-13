Feature: Login page feature


@Login
Scenario: Login page title
Given user is on home page
When user gets the title of the page
And page title should be "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"
Then click on home page sign in

@Login
Scenario: Forgot Password link
And user is on login page
When user gets the title of the page
Then page title should be "Amazon Sign In"
When user enters username "+917904664951"
And user clicks on Continue button
Then forgot your password link should be displayed

@Login
Scenario: Login with correct credentials
Given user is on login page
When user gets the title of the page
Then page title should be "Amazon Sign In"
When user enters username "+917904664951"
And user clicks on Continue button
And user enters password "Gokul@20"
And user clicks on Login button
When user gets the title of the page
And page title should be "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"