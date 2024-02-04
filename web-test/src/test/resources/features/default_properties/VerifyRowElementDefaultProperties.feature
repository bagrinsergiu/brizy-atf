Feature: Editor Page - Adding a Gallery Element
  As a user
  I want to add a gallery element
  So that I can see some default properties

  Background:
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_1' to page
    When prepare the following items to be added to the page:
      | item | position | sibling | name  | sectionName | parent | isParent |
      | ROW  | -        | -       | ROW_1 | SECTION_1   | -      | true     |
#      | COLUMN | -        | -       | COLUMN_GROUP_1 | SECTION_1   | -      | true     |

  @Test
  Scenario Outline: Add row element and validate default properties
    And add the item to the page

    Examples:
      | name      | sectionName |
      | GALLERY_1 | SECTION_1   |