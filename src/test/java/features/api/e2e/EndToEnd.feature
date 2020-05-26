Feature: User do Sign Up via Netflix PI

  Scenario: User do Sign Up successfully
    Given Netflix Middleware API is up and running
    When  User submit POST account
    And   POST account API return with status code as 201
    And   PAI is generated successfully with status "new"


