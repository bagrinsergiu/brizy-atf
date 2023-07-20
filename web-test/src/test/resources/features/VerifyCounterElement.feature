Feature: Editor Page - Adding a Counter Element
  As a user
  I want to customize a counter element
  So that I can visualize it in preview

  Scenario Outline: Add <name> element and validate default properties
    When navigate to home page
    And open dashboard page
    When select 'Project #1' from projects list
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section '<sectionName>' to page
    When prepare the following items to be added to the page:
      | item    | position | parent | name   | sectionName   |
      | COUNTER | -        | -      | <name> | <sectionName> |
    When prepare elements properties from the 'VerifyCounterElement.json' file
    And add the item to the page
    When get editor properties for the '<name>' item from the section '<sectionName>'
    Then validate default properties of the item '<name>'

    Examples:
      | name      | sectionName |
      | COUNTER_1 | SECTION_1   |
      | COUNTER_2 | SECTION_1   |
      | COUNTER_3 | SECTION_1   |
      | COUNTER_4 | SECTION_1   |