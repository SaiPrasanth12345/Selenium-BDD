@googleSearchDatatable
Feature: Google Search from Datatable

  @test1 @test2
  Scenario: Google Search with data from datatable
    Given I to launch the google page
    When I search for the text in the search box through datatable
      | Search Word |
      | Selenium    |
      | Java        |
    Then Search is displayed

  #This method is depricated. SO used list to convert to Pojo
  @test2
  Scenario: Google Search with data from datatable by converting to POJO
    Given I to launch the google page
    When I search for the text by joininig SearchText through datatable
      | Search Word 1 | Search Word 2 |
      | Selenium      | Java          |
      | Java          | Training      |
    Then Selenium java search is displayed

  @test3
  Scenario: Google Search with data from datatable by converting to Map
    Given I to launch the google page
    When I search for the text by joininig SearchText through datatable
      | Search Word 1 | Search Word 2 |
      | Selenium      | Java          |
      | Java          | Training      |
    Then Selenium java search is displayed

  @testamazon
  Scenario: Google Search with data from datatable
    Given Navigate to amazon website
    When Add the Product
    Then validate for amazon Product
