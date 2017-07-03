Feature: Request creation

  Background: Open URL
    Given Open Login Page

  Scenario: Search product by
    Given Login with "testempadmin" and "test123test"
    When Search for account "3394040" from region "North America"
    And Select account "3394040" from search results with Seles org "GEIS United States"
    And Close Tooltip pop-up
    And Select "All Requests" option from Post Sales item of the Header menu
    And Click on Create Request button
    And Search for value "thql1120" by "Catalog No."
    Then All Next buttons should be inactive
    And Add to Product List for Invoice No line number "1"
    And From Product List for Invoice No select line number
    |1|
    |3|
    Then Arrow icon of "1" line in Search Results should be "green"
    Then Then Top and Bottom "Next" buttons should be active
    And Click on top Next button
    Then All Catalog № from Product List for Invoice No should be displayed on Reason for Request step
    Then All Qty from Product List for Invoice No should be displayed on Reason for Request step
    Then All Next buttons should be inactive





