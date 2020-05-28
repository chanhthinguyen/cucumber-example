Feature: User do Sign Up via Netflix PI

  Scenario: User do Sign Up successfully with postpaid account
    Given Netflix Middleware API is up and running
    And   Get JWT token of "postpaid" account from OTT
    When  User submit POST account with PDI "2nR5rKYELAs2B9XpWBrpI6KaB01"
    And   POST account API return with status code as 201
    And   PAI is generated successfully with status "new"
    And   Get Account Info with PDI "2nR5rKYELAs2B9XpWBrpI6KaB01" return MOP "true"
    And   Waiting for subscriber is created
    And   Subscriber is generated for "postpaid" account
    And   Subscriber has "active" status with amount 419 and package_plan "Premium"
    And   Purchase is generated for "postpaid" account
    And   Clean data test of "postpaid" account

  Scenario: User do Sign Up successfully with prepaid account
    Given Netflix Middleware API is up and running
    And   Get JWT token of "prepaid" account from OTT
    When  User submit POST account with PDI "2nR5rKYELAs2B9XpWBrpI6KaB01"
    And   POST account API return with status code as 201
    And   PAI is generated successfully with status "new"
    And   Get Account Info with PDI "2nR5rKYELAs2B9XpWBrpI6KaB01" return MOP "false"
    #And   Waiting for subscriber is created
    #And   Subscriber is generated for "prepaid" account
    #And   Subscriber has "active" status with amount 419 and package_plan "Premium"
    #And   Purchase is generated for "postpaid" account
    And   Clean data test of "prepaid" account