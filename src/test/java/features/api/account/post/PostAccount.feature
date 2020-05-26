Feature: POST /account API


  Scenario: Verify POST /account API successfully with JWT and PDI
    Given Netflix Middleware API is up and running
    When  User submit POST account
    Then  POST account API return with status code as 201
    And   Verify body have id as "c0a8e271-720b-1e92-8172-111f8a880000"
    And   Verify body have token as "d0gaZcDvErFKNUQIcwp5_oBTU3c"
    And   Verify body have created as "2020-05-14T02:59:39+0000"
    And   Verify body have updated as "2020-05-14T02:59:39+0000"