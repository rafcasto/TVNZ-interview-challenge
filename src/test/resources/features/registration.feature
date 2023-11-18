Feature: Registration
  @TEST-001
  Scenario: User is un able to signup when PASSWORD is left blank
    Given I am a New Zealand resident
    And I want to register to TVNZ app
    And I provide my account details
  | email|password|
   |      | BLANK  |
    And I provide my personal details
    |firstName|lastName|yearOfBirth|gender|
    |         |        |           |      |
    And I agree to the house rules
      |agreeTermsAndConditions|agreeToReceiveUpdates|
      | true                     |                  |
    When I sign up to TVNZ
    Then I am unable to register

  @TEST-002
  Scenario: User is un able to signup when EMAIL is left blank
    Given I am a New Zealand resident
    And I want to register to TVNZ app
    And I provide my account details
      | email|password|
      | BLANK     |   |
    And I provide my personal details
      |firstName|lastName|yearOfBirth|gender|
      |         |        |           |      |
    And I agree to the house rules
      |agreeTermsAndConditions|agreeToReceiveUpdates|
      | true                     |                  |
    When I sign up to TVNZ
    Then I see the following error message ""


  @TEST-002
  Scenario: User is un able to signup when NAME is left blank
    Given I am a New Zealand resident
    And I want to register to TVNZ app
    And I provide my account details
      | email|password|
      |      |   |
    And I provide my personal details
      |firstName|lastName|yearOfBirth|gender|
      |   BLANK      |        |           |      |
    And I agree to the house rules
    |agreeTermsAndConditions|agreeToReceiveUpdates|
    | true                     |                  |
    When I sign up to TVNZ
    Then I am unable to register