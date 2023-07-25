Feature: Editor Page - Right Click an Element
  As a user
  I want to be able to get access to advanced actions over an element
  So that I can delete, duplicate or copy/paste it

  Scenario Outline: Validate context menu items
    Given wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section '<sectionName>' to page
    When prepare the following items to be added to the page:
      | item | position | parent | name   | sectionName   |
      | MAP  | -        | -      | <name> | <sectionName> |
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
      | name  | sectionName |
      | MAP_1 | SECTION_1   |