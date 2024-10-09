@Elements @CheckBox
Feature: Test check
  As a user
  I want to test the functionality to check checkboxes

  Scenario Outline: Add text in different fields and validate data insertion
    Given That the user is on the Check Box page
    When  The user selects different checkboxes until arriving at a final "<Item>"
    Then  The user should see the selected "<Item>"
    Examples:
      | Item    |
      | Angular |