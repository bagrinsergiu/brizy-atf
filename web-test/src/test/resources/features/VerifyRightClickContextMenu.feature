@Smoke
Feature: Editor Page - Right-Click Context Menu Actions
  As a user of Brizy application,
  I want to be able to perform various actions on items using the right-click context menu,
  So that I can efficiently interact with the application and manage web items as needed.

  Background:
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    And switch to 'Blocks' tab

  Scenario Outline: Validate right-click context menu options are displayed correctly
    When add section '<sectionName>' to page
    When prepare the following items to be added to the page:
      | item | position | sibling | name   | sectionName   |
      | TEXT | -        | -      | <name> | <sectionName> |
    And add the item to the page
    When get context menu items for '<name>'
    Then validate that the following menu items are displayed:
      | title        | keyShortcut   | isEnabled |
      | Copy         | ctrl + C      | true      |
      | Paste        | ctrl + V      | false     |
      | Paste Styles | ctrl + ⇧ + V  | false     |
      | Duplicate    | ctrl + D      | true      |
      | Delete       | ctrl + delete | true      |

    Examples:
      | name   | sectionName |
      | TEXT_1 | SECTION_1   |

  Scenario Outline: Validate <action> action
    When add section '<sectionName>' to page
    And prepare the following items to be added to the page:
      | item | position | sibling | name   | sectionName   |
      | MAP  | -        | -      | <name> | <sectionName> |
      | MAP  | BOTTOM   | <name> | MAP_2  | <sectionName> |
    And add the item to the page
    When <action> the following item '<name>'
    Then validate that section '<sectionName>' contains '<itemsCount>' items

    Examples:
      | name  | sectionName | itemsCount | action    |
      | MAP_1 | SECTION_1   | 1          | delete    |
      | MAP_1 | SECTION_1   | 3          | duplicate |

  Scenario Outline: Validate copy and paste action
    When add section '<sectionName>' to page
    And prepare the following items to be added to the page:
      | item | position | sibling | name         | sectionName   |
      | MAP  | -        | -      | <name>       | <sectionName> |
      | MAP  | BOTTOM   | <name> | <secondName> | <sectionName> |
    And add the item to the page
    When copy the following item '<name>'
    And paste the following item '<secondName>'
    Then validate that section '<sectionName>' contains '3' items

    Examples:
      | name  | secondName | sectionName |
      | MAP_1 | MAP_2      | SECTION_1   |

  Scenario Outline: Validate copy and paste styles action on existing element
    When add section '<sectionName>' to page
    And prepare the following items to be added to the page:
      | item | position | sibling | name         | sectionName   |
      | TEXT | -        | -      | <name>       | <sectionName> |
      | TEXT | BOTTOM   | <name> | <secondName> | <sectionName> |
    When prepare elements properties from the 'VerifyRightClickContextMenu.json' file
    And add the item to the page
    And configure the item added to the page
    When copy the following item '<name>'
    And paste styles the following item '<secondName>'
    Then validate that section '<sectionName>' contains '2' items
    When get for compare editor properties for the first '<name>' item from the section '<sectionName>'
    And get for compare editor properties for the second '<secondName>' item from the section '<sectionName>'
    Then compare and validate properties for the items

    Examples:
      | name   | secondName | sectionName |
      | TEXT_1 | TEXT_2     | SECTION_1   |
