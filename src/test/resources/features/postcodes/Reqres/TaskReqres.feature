Feature: Task Request to API Reqres
  Scenario Outline: Get Single User
    Given Get single user with id 2
    When Send request get single user
    Then Status code should be 200 OK
    And Response body should contain email "<email>"
    And Get single user assert json validation
    Examples:
   |email|
   |janet.weaver@reqres.in|


  Scenario: Post Login Success
    Given Post login user with valid json file
    When Send request post login user
    Then Status code should be 200 OK
    And Post login user assert json validation

  Scenario: Post Login Unsuccess
    Given Post login unsuccess user with valid json file
    When Send request post login user unsuccess
    Then Status code should be 400 error
    And Response body should contain error "Missing password"
    And Post login unsuccess assert json validation

  Scenario Outline: Patch Update User
    Given Patch update user with id <id> and with valid json file
    When Send request patch update user
    Then Status code should be 201 Created
    And Response body should contain name "morpheus" and job "zion resident"
    And Patch update user assert json validation
    Examples:
      |id|
      |1 |








