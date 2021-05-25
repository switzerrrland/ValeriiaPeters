Feature: JDI page selecting checkboxes

  Scenario: JDI page. Select elements checkboxes
    Given I open JDI home page
    And I login with name = 'Roman' and password = 'Jdi1234'
    And I open 'Different Elements Page' in header menu 'Service'
    When I select checkboxes 'Water' and 'Wind'
    And I select radiobutton 'Selen'
    And I select 'Yellow' in dropdown
    Then log entries should contain "Water: condition changed to true"
    And log entries should contain "Wind: condition changed to true"
    And log entries should contain "metal: value changed to Selen"
    And log entries should contain "Colors: value changed to Yellow"