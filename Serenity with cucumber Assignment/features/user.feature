Feature: Adding a user
    Background:
        Given the user is on feature page
  Scenario: Add a new user

      When the user clicks the IAM button
      And  clicks the user button
      And  clicks the invite users button
      And  Enters email to send invite
      Then the new user should be added in the users list





