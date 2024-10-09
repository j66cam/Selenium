@Elements @TextBox
Feature: Test entry
  As a user
  I want to test the functionality to insert text in text fields.

  Scenario Outline: Add text in different fields and validate data insertion
    Given That the user is on the Elements page
    When  The user fills in the text fields with "<Full Name>", "<Email>","<Current Address>" and "<Permanent Address>"
    And   The user clicks on the submit button
    Then  The user validates that "<Full Name>", "<Email>","<Current Address>" and "<Permanent Address>" appear in a new section
    Examples:
      | Full Name                 | Email            | Current Address        | Permanent Address      |
      | Juan Camilo Mejia Montoya | j66cam@gmail.com | Calle 38 sur # 38 - 37 | Carrera 38 # 36 Sur 39 |