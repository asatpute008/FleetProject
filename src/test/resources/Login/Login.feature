Feature: User sign IN

Scenario Outline: Signin with email and password
Given I have login panel-test
When I provide <ID> and <password>-test  
And Tap on submit button-test
Then User should be logged in-test 
And Close Window

Examples:
| ID 										| password |
|fokisaj290@edectus.com | Fleet@123|
|fokisaj290@edectus.com | wrong    |
|Wrong.mail							| Fleet@123|
|Wrong.mail 						| wrong    |
