Feature: Login Feature
    This feature deals with the login feature of the website

    Scenario: Login with username and password
      Given I navigate to the login page
      And I log into the application
      And I enter the users email address as Email:admin
      And I verify the county of my salary digits for Rs 1000
      And I just need to see how the step looks for Cucumber-Java8
      And I enter following details for login
      | username | password |
      | admin    | admin    |
      And I click the login button
      Then I should see the userform page
 
  



