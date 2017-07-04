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
    And From Search results select Invoice line number "1" and select Products lines numbers
    |1|
    |3|
    Then Arrow icon should have color "rgba(70, 173, 0, 1)" for invoices in lines
    |1|
    Then All Next buttons should be active
    And Click on top Next button
    Then Reason for Request step should contain all Catalog № from first Step
    Then All Qty label on Reason for Request step should contain appropriate values from step 1
    Then All Next buttons should be inactive





