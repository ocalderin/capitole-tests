@web
Feature: Searching on Google

  Scenario: Searching word
    Given The user goes to the Google homepage
    When The user searches for the word "automatización"
    And the user selects the Wikipedia result
    Then The year of the first automation process on the Wikipedia page should be "2000"