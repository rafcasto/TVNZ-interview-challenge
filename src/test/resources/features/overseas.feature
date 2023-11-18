Feature: Overseas Access
 @overseas   @TEST-020
  Scenario: User is unable to access TVNZ app from Overseas
    Given I am Overseas
    When I Access TVNZ app
    Then I see an error message "Sorry, our app is only available for our lucky viewers in NZ. If you are in NZ, please click here for help."