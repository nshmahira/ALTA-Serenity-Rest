Feature: Request to API Reqres
  Scenario Outline: Get list user
    Given Get list user with parameter "<parameter>"
    When Send request get list user
    Then Status code should be 200 OK
    And Response body should contain first name "<firstName>" and last name "<lastName>"
    And Get list user assert json validation
    Examples:
      |parameter|firstName|lastName|
      |1        |George  |Bluth    |
      |2        |Michael |Lawson   |
  Scenario: Post create user
    Given Post create new user with valid json file
    When Send request post create user
    Then Status code should be 201 Created
    And Response body should contain name "Nashuha Mahira" and job "QA Engineer"
    And Post list user assert json validation
  Scenario Outline: Put update user
    Given Put update user with id <id> and with valid json file
    When Send request put update user
    Then Status code should be 200 OK
    And Response body should contain name "Nashuha Mahira Update" and job "QA Engineer Update"
    Examples:
    |id|
    |1 |
    |2 |

Scenario Outline: Delete user
  Given Delete user with id <id>
  When Send request delete user
  Then Status code should be 204 No content
  Examples:
  |id|
  |2 |









