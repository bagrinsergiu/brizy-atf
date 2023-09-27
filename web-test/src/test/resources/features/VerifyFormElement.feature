Feature: Editor Page - Adding a Form Element
  As a user
  I want to add a Map element with different properties
  So that I can visualize it in preview

  Background: Add the form item to the page
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_1' to page

  Scenario Outline: Add form element with color border and preview it
    When prepare the following items to be added to the page:
      | item | position | parent | name   | sectionName   |
      | FORM | -        | -      | <name> | <sectionName> |
    When prepare elements properties from the 'VerifyFormElement.json' file
    And add the item to the page
    And configure the item added to the page
    When save draft page
    And publish the page

    Examples:
      | name   | sectionName |
      | FORM_1 | SECTION_1   |

