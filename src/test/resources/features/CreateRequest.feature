Feature: Request creation

  Background: Open URL
    Given Open Login Page

  Scenario: Search product by
    Given Login with "testempadmin" and "test123test"
    When Search for account "9000023" from region "North America"
    And Select account "9000023" from search results
    And Select "All Requests" option from Post Sales item of the Header menu
    And Click on Create Request button
    And Search for value "thql1120" by "Catalog №"


