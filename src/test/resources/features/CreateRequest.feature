Feature: Request creation

  Scenario: Search product by
    Given Login with "User ID" and "Password"
    When Search for account "9000023" from region "North America"
    And Select account "9000023" from search results
    And Select "All Requests" option from Post Sales item of the Header menu
    And Click on "Create Request" button
    And Search for value "thql1120" by "Catalog №"

