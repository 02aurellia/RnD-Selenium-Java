@All
  Feature: User Login

    @positive @login
      Scenario: user success login
      Given User on page login
      When User input username and password
      And User click button Login
      Then User login success

    @negative @login
      Scenario: user failed login - incorrect password
      Given User on page login
      When User input username and invalid password
      And User click button Login
      Then User get error message

    @negative @login
      Scenario: user failed login - empty username and password
      Given User on page login
      And User click button Login
      Then User get error message