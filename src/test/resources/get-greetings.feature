Feature: Get Greetings API

  Background:
    * url baseUrl

  Scenario: Check Content-Type value contains Latin-1 charset
    Given path '/api/greetings'
    When method get
    Then status 200
    And match header Content-Type == 'application/json;charset=ISO-8859-1'
