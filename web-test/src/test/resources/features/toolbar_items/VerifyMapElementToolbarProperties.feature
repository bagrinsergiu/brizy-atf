@Smoke
Feature: Editor Page - Map element Toolbar
  As a user
  I want to customize a map element
  So I need to have a toolbar with different configurations for it

  Background: Navigate to project and create a new one
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_1' to page

  Scenario Outline: Add map element and validate toolbar items
    When prepare the following items to be added to the page:
      | item | position | parent | name   | sectionName   |
      | MAP  | -        | -      | <name> | <sectionName> |
    And add the item to the page
    When get the toolbar items for '<name>' item from section '<sectionName>'
    Then the following toolbar items should be displayed:
      | Map       |
      | Colors    |
      | Align     |
      | Settings  |
      | Duplicate |
      | Delete    |

    Examples:
      | name  | sectionName |
      | MAP_1 | SECTION_1   |

