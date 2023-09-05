@Smoke
Feature: Editor Page - Adding a Icon Element
  As a user
  I want to add a icon element
  So that I can see some default properties

  Scenario Outline: Add icon element and validate default properties
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section '<sectionName>' to page
    When prepare the following items to be added to the page:
      | item | position | parent | name   | sectionName   |
      | ICON | -        | -      | <name> | <sectionName> |
    When prepare elements properties from the 'VerifyIconElement.json' file
    And add the item to the page
    And configure the item added to the page
#    When get editor properties for the '<name>' item from the section '<sectionName>'
#    Then validate default properties of the item '<name>'

    Examples:
      | name   | sectionName |
      | ICON_1 | SECTION_1   |