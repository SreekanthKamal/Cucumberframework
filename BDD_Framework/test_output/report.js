$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:/Nagineni/CucumberFramework/BDD_Framework/src/main/java/com/qa/features/Login.Feature");
formatter.feature({
  "line": 1,
  "name": "OrangeHRM application Test",
  "description": "",
  "id": "orangehrm-application-test",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Validate OrangeHRM HomePage",
  "description": "",
  "id": "orangehrm-application-test;validate-orangehrm-homepage",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "User Opens Browser",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User Is On LoginPage",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "User Enters Username And Password and Clicks On Login Button",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Validate OrangeHRM HomePage",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdefs.user_Opens_Browser()"
});
formatter.result({
  "duration": 15102887600,
  "status": "passed"
});
formatter.match({
  "location": "Stepdefs.user_Is_On_LoginPage()"
});
formatter.result({
  "duration": 91493800,
  "status": "passed"
});
formatter.match({
  "location": "Stepdefs.user_Enters_Username_And_Password()"
});
formatter.result({
  "duration": 6362109100,
  "status": "passed"
});
formatter.match({
  "location": "Stepdefs.validate_OrangeHRM_HomePage()"
});
formatter.result({
  "duration": 1449464300,
  "status": "passed"
});
});