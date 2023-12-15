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
  Scenario Outline: Google Search with data from datatable by converting to POJO
    Given I to launch the google page
    When I search for the text by joininig SearchText through datatable
      | Search Word 1 | Search Word 2 |
      | <Word 1>      | <Word 2>      |
    Then Selenium java search is displayed

    Examples: 
      | Word 1    | Word 2   |
      | Selenium  | Java     |
      | Webdriver | Selenium |

  @test3
  Scenario Outline: Google Search with data from datatable by converting to Map
    Given I to launch the google page
    When I search for the text by joininig SearchText through datatable
      | Search Word 1 | Search Word 2 |
      | <Word 1>      | <Word 2>      |
    Then Selenium java search is displayed

    Examples: 
      | Word 1    | Word 2   |
      | Selenium  | Java     |
      | Webdriver | Selenium |

  @testamazon
  Scenario: Amazon Add Product
    Given Navigate to amazon website
    When Add the Product
    Then validate for amazon Product
