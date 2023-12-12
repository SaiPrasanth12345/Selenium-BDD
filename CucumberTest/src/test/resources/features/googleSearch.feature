@GoogleSearch
Feature: Google Search

  @test1
  Scenario: Google Search
    Given I to launch the google page
    When I search for the text "Selenium" in the search box
    Then Search is displayed

  @test2
  Scenario: Google Search with data from excel sheet
    Given I to launch the google page
    When I search for the text in the search box through excel
    Then Search is displayed

  @test4
  Scenario Outline: Google Search with Examples
    Given I to launch the google page
    When I search for the text <text> in the search box
    Then i verify for the result text <result>

    Examples: 
      | text     | result   |
      | Selenium | Selenium |
      | Java     | Java     |
