@Smoke
Feature: Editor Page - Adding a Counter Element
  As a user
  I want to customize a counter element
  So that I can visualize it in preview

  Scenario Outline: Add <name> element and validate default properties
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section '<sectionName>' to page
    When prepare the following items to be added to the page:
      | item    | position | sibling | name   | sectionName   |
      | COUNTER | -        | -      | <name> | <sectionName> |
    When prepare elements properties from the 'VerifyCounterElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab 'counter' of 'counter' toolbar item of the '<name>' item from section '<sectionName>'
    When get active item from 'style' radio group
    Then the following item is active: <expectedStyle>
    When get value of the 'start' input with population
    Then the following item is active: <expectedStartValue>
    When get value of the 'end' input with population
    Then the following item is active: <expectedEndValue>
    When get value of the 'duration' input
    Then the following item is active: <expectedDuration>
    When get available configurations in the tab 'advanced' of 'counter' toolbar item of the '<name>' item from section '<sectionName>'
    When get value of the 'prefix' input with population
    Then the following item is active: <expectedPrefixValue>
    When get value of the 'suffix' input with population
    Then the following item is active: <expectedSuffixValue>
    When get value of the 'separator' input with population
    Then the following item is active: <expectedSeparatorValue>

    Examples:
      | name      | sectionName | expectedStyle | expectedStartValue | expectedEndValue | expectedDuration | expectedPrefixValue | expectedSuffixValue | expectedSeparatorValue |
      | COUNTER_1 | SECTION_1   | TEXT          | 0                  | 100              | 2.0              |                     |                     | ,                      |

  Scenario Outline: Add <name> element and validate default properties
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section '<sectionName>' to page
    When prepare the following items to be added to the page:
      | item    | position | sibling | name   | sectionName   |
      | COUNTER | -        | -      | <name> | <sectionName> |
    When prepare elements properties from the 'VerifyCounterElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab 'counter' of 'counter' toolbar item of the '<name>' item from section '<sectionName>'
    When get active item from 'style' radio group
    Then the following item is active: <expectedStyle>
    When get value of the 'end' input with population
    Then the following item is active: <expectedEndValue>
    When get value of the 'duration' input
    Then the following item is active: <expectedDuration>
    When get available configurations in the tab 'advanced' of 'counter' toolbar item of the '<name>' item from section '<sectionName>'
    When get value of the 'prefix' input with population
    Then the following item is active: <expectedPrefixValue>
    When get value of the 'suffix' input with population
    Then the following item is active: <expectedSuffixValue>
    When get value of the 'separator' input with population
    Then the following item is active: <expectedSeparatorValue>

    Examples:
      | name      | sectionName | expectedStyle | expectedEndValue | expectedDuration | expectedPrefixValue | expectedSuffixValue | expectedSeparatorValue |
      | COUNTER_2 | SECTION_1   | CIRCLE_TEXT   | 100              | 2.0              |                     | %                   | ,                      |

  Scenario Outline: Add <name> element and validate default properties
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section '<sectionName>' to page
    When prepare the following items to be added to the page:
      | item    | position | sibling | name   | sectionName   |
      | COUNTER | -        | -      | <name> | <sectionName> |
    When prepare elements properties from the 'VerifyCounterElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab 'counter' of 'counter' toolbar item of the '<name>' item from section '<sectionName>'
    When get active item from 'style' radio group
    Then the following item is active: <expectedStyle>
    When get value of the 'end' input with population
    When the following item is active: <expectedEndValue>
    When get value of the 'duration' input
    When the following item is active: <expectedDuration>

    Examples:
      | name      | sectionName | expectedStyle | expectedEndValue | expectedDuration |
      | COUNTER_3 | SECTION_1   | CIRCLE        | 100              | 2.0              |
      | COUNTER_4 | SECTION_1   | PIE           | 100              | 2.0              |