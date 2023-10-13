Feature:Login functionality
  In order to do internet banking
  As a valid para bank customer
  I want to login successfully

  Scenario Outline: Login Successful
    Given I am in the login page of para bank application
    When I enter valid <username> and <password> with <userFullName>
    Then I should be taken to the overview page
  Examples:
    |username|password|userFullName|
    |"autotester"|"password"|Auto Tester|
    |"tautester" |"password"|TAU Tester |

