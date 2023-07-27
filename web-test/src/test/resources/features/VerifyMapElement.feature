@Test
Feature: Editor Page - Adding a Map Element
  As a user
  I want to add a Map element with different properties
  So that I can visualize it in preview

  Background: Add the map item to the page
    When navigate to home page
#    And open dashboard page
#    When select 'Project #1' from projects list
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_1' to page

  Scenario: Add map element with color border and preview it
    When prepare the following items to be added to the page:
      | item | position | parent | name  | sectionName |
      | MAP  | -        | -      | MAP_1 | SECTION_1   |
    When prepare elements properties from the 'VerifyMapElement.json' file
    And add the item to the page
    And configure the item added to the page
    When save draft page
    And publish the page
    Then validate item properties

  Scenario Outline: Add map element, resize and preview it
    When prepare the following items to be added to the page:
      | item | position | parent | name   | sectionName   |
      | MAP  | -        | -      | <name> | <sectionName> |
    When prepare elements properties from the 'VerifyMapElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get css properties for the '<name>' editor item from the section '<sectionName>'
    When save draft page
    And publish the page
    Then validate css properties of the components

    Examples:
      | name  | sectionName |
      | MAP_1 | SECTION_1   |

