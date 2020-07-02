Feature: Application Login

Scenario: Home Page Default Login
Given user is on net Banking landing page
When user login to application with user name "Vishal" and password "123"
Then Home page is populated
And All payments cards "should" displayed

Scenario: Home Page Default Login
Given user is on net Banking landing page
When user login to application with user name "ABC" and password "456"
Then Home page is populated
And All payments cards "should not" displayed

