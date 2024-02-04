Feature: Editor Page - Carousel element Toolbar
  As a user
  I want to customize a carousel element
  So I need to have a toolbar with different configurations for it

  Background: Navigate to project and create a new one
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_1' to page

  Scenario Outline: Add carousel element and validate toolbar items
    When prepare the following items to be added to the page:
      | item     | position | sibling | name   | sectionName   |
      | CAROUSEL | -        | -      | <name> | <sectionName> |
    And add the item to the page
#    When get the toolbar items for '<name>' item from section '<sectionName>'
#    Then the following toolbar items should be displayed:
#      | Carousel  |
#      | Colors    |
#      | Settings  |
#      | Duplicate |
#      | Delete    |

    Examples:
      | name       | sectionName |
      | CAROUSEL_1 | SECTION_1   |

