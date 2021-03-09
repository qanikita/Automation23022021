Feature: Login test scenario
  @loginTest
  Scenario Outline: Login with valid username and password
    When I go to login page
    And I enter username as "<username>"
    And I enter password as "<password>"
    And I click submit button
    When Count of error messages must be <errorCount>
    Examples:
      |username                 |password        |errorCount|
      |yurii.voronenko@gmail.com|12345678        |  0       |
      |yurii.voronenko@gmail.com|12312222        |  1       |
      |invalidUsername          |12345678        |  1       |