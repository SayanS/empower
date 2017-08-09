Feature: Request creation

  Scenario: Search invoices for return request by Date range
    Given Open Login Page
    Given Login with "testempadmin" and "test123test"
    When Search for account "2244410" from region "North America"
    And Select account "2244410" from search results with Sales org "GEIS United States"
    And Close Tooltip pop-up
    And Select "All Requests" option from Post Sales item of the Header menu
    When Click on Create Request button
    And Search for "THQL1120" by "Catalog No."
    When Select Invoice date range from "01-01-2014" to "01-01-2017"
    And Click on "Go" button
    Then All Next buttons should be inactive
    Then All Invoices in Search results should be from date range "01-01-2010" to "01-01-2017"
    Then Amount of invoices should be equal to Total Search Results

    Scenario: Check ability to reset the Search filters
      When Click on "Reset" button
      Then For "Search" range-input should be selected option "PO No."
      #Then "Search" range-input should be displayed with prompt "Search by PO No."


  Scenario: Check ability to add products from several invoices to request list
    And Search and Select products from invoices for return from file "./src/test/resources/TestingData/InvoiceDataForReturns.json"

  Scenario: Check ability to add products from several invoices to request list
    And Click on Create Request button
    And Search for "THQL1120" by "Catalog No."
    And Click on "Go" button
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
    Then Select Reason for Request "Defective" >> Requested Type "Performance" >> Requested Sub Type "Visual Indication Incorrect" for all products
    #Then Select Reason for Request "Technical Question" >> Requested Type "Other" for all products
    #Then Select Reason for Request "Order or Shipping Error" >> Requested Type "Shipped to Wrong Location" for all products
    #Then Select Reason for Request "Defective" >> Requested Type "Cosmetic" >> Requested Sub Type "Product" for all products
    #Then Select Reason for Request "Other"
    #Then Select Reason for Request "Wrong Product"
    Then Select Requested Action "Return & Repair" for all products
    And Enter Requested Qty value "1" for all products
    Then All Next buttons should be active
    And Click on top Next button






