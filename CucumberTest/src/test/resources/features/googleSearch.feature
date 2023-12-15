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

  @test4 @123
  Scenario Outline: Google Search with Examples
    Given I to launch the google page
    When I search for the text in the search box
      | text   |
      | <text> |
    Then I verify for the result text
      | result   |
      | <result> |

    Examples: 
      | text               | result   |
      | Selenium  Java     | Selenium |
      | Webdriver Selenium | Java     |
