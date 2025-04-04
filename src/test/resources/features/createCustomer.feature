Feature: Creating a client within the client module

  Scenario: successfull client creation
    Given that Mike is on the website
    When he attempts to create a client
    Then he will see the client created