Feature: Editor Page - Right Click an Element
  As a user
  I want to be able to get access to advanced actions over an element
  So that I can delete, duplicate or copy/paste it

  @Test
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
      | item | position | parent | name   | sectionName   |
      | MAP  | -        | -      | <name> | <sectionName> |
      | MAP  | BOTTOM   | <name> | MAP_2  | <sectionName> |
    And add the item to the page
    When delete the following item '<name>'
    Then section '<sectionName>' contains '1' items

    Examples:
      | name  | sectionName |
      | MAP_1 | SECTION_1   |