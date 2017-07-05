Feature: Request creation

  Background: Open URL
    Given Open Login Page
    Given Login with "testempadmin" and "test123test"
    When Search for account "3394040" from region "North America"
    And Select account "3394040" from search results with Sales org "GEIS United States"
    And Close Tooltip pop-up
    And Select "All Requests" option from Post Sales item of the Header menu

  Scenario: Check ability to add products from several invoices to request list
    And Click on Create Request button
    And Search for "thql1120" by "Catalog No."
    Then All Next buttons should be inactive
    And Select Invoice from Search results in line "1"
    And Select First Product from requested list
    And Select Last Product from requested list
    #And Select All Product from requested list
    Then Arrow icon should have color "rgba(70, 173, 0, 1)" for invoices "Invoice line"
    #Then Product list for Invoices should contain "thql1120"
    Then All Next buttons should be active
    And Click on top Next button
    Then Reason for Request step should contain all Catalog № from first Step
    Then All Qty label on Reason for Request step should contain appropriate values from step 1
    Then All Next buttons should be inactive





