Feature: Creating a user group with the users created
  Scenario:Adding a user group
    Given The user is on user groups page
    When  The user creates a usergroup with a name and selects users
    Then  The user group should be present in the list of user groups
