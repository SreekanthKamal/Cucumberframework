Feature: OrangeHRM application Test 


@ID-4209 @SmokeTest
Scenario: Validate OrangeHRM HomePage
#Given User Opens Browser 
When User Is On LoginPage 
When User Enters Username And Password and Clicks On Login Button
Then Validate OrangeHRM HomePage

@ID-4210 @SmokeTest
Scenario: Validate OrangeHRM HomePage Duplicate
#Given User Opens Browser 
When User Is On LoginPage 
When User Enters Username And Password and Clicks On Login Button
Then Validate Dashboard Tab In HomePage