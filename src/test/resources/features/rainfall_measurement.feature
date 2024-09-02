Feature: Rainfall API

  Scenario: Limit the number of rainfall measurements returned
    Given I set the endpoint to "/rainfall/{station_id}"
    When I request the rainfall measurements with a limit of 5
    Then the response should contain 5 measurements

  Scenario: Request rainfall measurements for a specific date
    Given I set the endpoint to "/rainfall/{station_id}"
    When I request the rainfall measurements for the date "2024-08-29"
    Then the response should contain measurements for "2024-08-29"
