Feature: Place Bet Action

  Scenario: Place bet as not registered user
    Given User is on Home Page
    When User selects "football" event
    And User bet on Home team to win
    And User sets "0.05" amount of the bet and clicks Place bet
    Then Error Message is displayed