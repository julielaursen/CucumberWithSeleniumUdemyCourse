Feature: Login Feature
    This feature deals with the login feature of the website

    Scenario: Login with username and password
      Given I log into the application
      And I enter following details for login
      | username | password |
      | admin    | admin    |
      And I click the login button
      Then I should see the userform page





