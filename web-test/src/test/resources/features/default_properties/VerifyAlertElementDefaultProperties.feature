Feature: Editor Page - Adding a Alert Element
  As a user
  I want to add a alert element
  So that I can see some default properties

  Background:
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_1' to page
    When prepare the following items to be added to the page:
      | item  | position | parent | name    | sectionName |
      | ALERT | -        | -      | ALERT_1 | SECTION_1   |

  Scenario Outline: Add alert element and validate default properties
    When prepare elements properties from the 'VerifyAlertElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get editor properties for the '<name>' item from the section '<sectionName>'
    Then validate default properties of the item '<name>'

    Examples:
      | name    | sectionName |
      | ALERT_1 | SECTION_1   |

  Scenario Outline: Add alert element and validate default configurations
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    Then the following configurations should be displayed: <displayedConfigurations>

    Examples:
      | tabToOpen | toolbarItem | name    | sectionName | displayedConfigurations                          |
      | Alert     | Alert       | ALERT_1 | SECTION_1   | Display Close Button, Delay, Display Description |

  Scenario Outline: Add alert element and validate default configurations no close button
    When prepare elements properties from the 'VerifyAlertElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    Then the following configurations should be displayed: <displayedConfigurations>

    Examples:
      | tabToOpen | toolbarItem | name    | sectionName | displayedConfigurations                   |
      | Alert     | Alert       | ALERT_1 | SECTION_1   | Display Close Button, Display Description |

  Scenario Outline: Add alert element and validate <sliderToCheck> slider default value
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get value of the '<sliderToCheck>' slider
    Then the following state is active: <expectedDefaultValue>

    Examples:
      | tabToOpen | toolbarItem | name    | sectionName | sliderToCheck        | expectedDefaultValue |
      | Alert     | Alert       | ALERT_1 | SECTION_1   | display close button | true                 |
      | Alert     | Alert       | ALERT_1 | SECTION_1   | display description  | true                 |

  Scenario Outline: Add alert element and validate delay default value
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get value of the 'delay' input with units
    Then the following number value is set: 0

    Examples:
      | tabToOpen | toolbarItem | name    | sectionName |
      | Alert     | Alert       | ALERT_1 | SECTION_1   |