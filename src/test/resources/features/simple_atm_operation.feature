Feature: Simple atm operations
  This is test feature to investigate main cucumber functionality.

  Scenario: create an account and send money
    Given user ATM account with $100.20
    When user sends $20.40
    Then user will have $79.80 on account
