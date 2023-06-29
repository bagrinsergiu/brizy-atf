Feature: Test counter tabs settings

  Background: Reach on page and create an section
    When navigate to home page
    And open dashboard page
    When select 'Project #1' from projects list
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_1' to page

  Scenario Outline: Add Map element to page in editor mode
    When prepare the following items to be added to the page:
      | item    | position | parent | name           | Sections  |
      | COUNTER | -        | -      | <tab_1> | Section 1 |
    When prepare elements properties from the 'editorPageAddingAMapElement.json' file
    And add the items to the page
    Then Validate item default values

    Examples:
      | tab_1     | Style | Start | End | Duration | tab_2    | Prefix | Suffix | Separator | Text |
      | COUNTER_1 | 1     | 0     | 100 | 2.0      | Advanced | empty  | empty | ,         | V    |
      | COUNTER_2 | 2     | -     | 100 | 2.0      | Advanced | empty  | %     | ,         | V    |
      | COUNTER_3 | 3     | -     | 100 | 2.0      | -        |        |       |           | X    |
      | COUNTER_4 | 4     | -     | 100 | 2.0      | -        |        |       |           | X    |
