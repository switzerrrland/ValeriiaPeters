Feature: Different elements page selecting checkboxes

  Scenario: Different elements page. Select elements checkboxes
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    When I click on "Service" button in Header
    And I click on 'Different Elements Page' in Service dropdown
    And I select checkboxes 'Water' and 'Wind'
    And I select radiobutton 'Selen'
    And I select 'Yellow' in dropdown
    Then log entries should contain "Water: condition changed to true"
    And log entries should contain "Wind: condition changed to true"
    And log entries should contain "metal: value changed to Selen"
    And log entries should contain "Colors: value changed to Yellow"