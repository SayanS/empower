Feature: Request creation

  Background: Open URL
    Given Open Login Page
    Given Login with "testempadmin" and "test123test"
    When Search for account "2244410" from region "North America"
    And Select account "2244410" from search results with Sales org "GEIS United States"
    And Close Tooltip pop-up
    And Select "All Requests" option from Post Sales item of the Header menu

  Scenario: Check ability to add products from several invoices to request list
    And Click on Create Request button
    And Search for "thql1120" by "Catalog No."
    Then All Next buttons should be inactive
    And Select Invoice from Search results in line "1"
    And Select All Product from requested list
    Then Arrow icon should have color "rgba(70, 173, 0, 1)" for selected invoice in line "1"
    Then Invoice should contain product "THQL1120"
    Then All Next buttons should be active

    And Select Invoice from Search results in line "3"
    And Select "1" Product from requested list
    Then Arrow icon should have color "rgba(70, 173, 0, 1)" for selected invoice in line "3"
    And Select Last Product from requested list
    Then Arrow icon should have color "rgba(70, 173, 0, 1)" for selected invoice in line "3"
    Then All Next buttons should be active

    And Click on top Next button
    Then Reason for Request step should contain all selected products from Step 1
    Then All Qty label on Reason for Request step should contain appropriate values from Step 1
    Then All Next buttons should be inactive
    Then Select "Defective" from Reason for Request drop-down for Product in line "1"
    Then Select value "Cosmetic" for Requested Type product in line "1"
    Then Select Requested Sub Type value "Product" for Product in line "1"
    Then Select Requested Action "Return & Repair" for Product in line "1"







