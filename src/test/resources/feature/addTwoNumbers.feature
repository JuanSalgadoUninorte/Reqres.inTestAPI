Feature: Add two number on dneonline service
  I as a user want to add two numbers

  Scenario Outline: Add two numbers
    Given Scenario
    When you add two numbers
      | numUno   | numDos   |
      | <numUno> | <numDos> |
    Then I should see the response of the service is 200
    Examples:
      | numUno | numDos |
      | 2      | 4      |