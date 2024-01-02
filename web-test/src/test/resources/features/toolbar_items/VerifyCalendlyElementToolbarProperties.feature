Feature: Editor Page - Calendly element Toolbar
  As a user
  I want to customize a calendly element
  So I need to have a toolbar with different configurations for it

  Background: Navigate to project and create a new one
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_1' to page

  Scenario Outline: Add calendly element and validate toolbar items
    When prepare the following items to be added to the page:
      | item     | position | parent | name   | sectionName   |
      | CALENDLY | -        | -      | <name> | <sectionName> |
    And add the item to the page
    When get the toolbar items for '<name>' item from section '<sectionName>'
    Then the following toolbar items should be displayed:
      | Calendly  |
      | Colors    |
      | Align     |
      | Settings  |
      | Duplicate |
      | Delete    |

    Examples:
      | name       | sectionName |
      | CALENDLY_1 | SECTION_1   |

