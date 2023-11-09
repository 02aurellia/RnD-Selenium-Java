@All
Feature: Para bank Registration

    @positive @register
      Scenario: Success Register
      Given User is on parabank homepage
      When User click register link button
      Then User is in register page
      When User input name
      And User input address detail
      And User fill valid username and password
      And User input password confirmation
      When User click button Register
      Then User regist successfully

    @negative @register
    Scenario: Failed Register - Missmatch Password
      Given User is on parabank homepage
      When User click register link button
      Then User is in register page
      When User input name
      And User input address detail
      And User fill valid username and password
      And User input invalid password confirmation
      When User click button Register
      Then User get error message password did not match