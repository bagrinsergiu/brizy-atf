Feature: Editor Page - Adding a Map Element
  As a user
  I want to add a Map element with a colored border
  So that I can visualize it in preview

  Background: Reach on page and create an section
    When navigate to home page
    And open dashboard page
    When select 'Project #1' from projects list
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_1' to page

  Scenario: Add map element and preview it
    When prepare the following items to be added to the page:
      | item   | position | parent | name     | sectionName |
      | MAP    | -        | -      | MAP_1    | SECTION_1   |
    When prepare elements properties from the 'editorPageAddingAMapElement.json' file
    And add the items to the page
    When save draft page
    And publish the page
    Then validate item properties

  Scenario: Verify map resize functionality
    When prepare the following items to be added to the page:
      | item | position | parent | name       | Sections  |
      | MAP  | -        | -      | MAP_MODULE | Section 1 |
    When prepare elements properties from the 'editorMapEditSize.json' file
    And add the items to the page
    When save draft page
    And publish the page
    Then validate item properties