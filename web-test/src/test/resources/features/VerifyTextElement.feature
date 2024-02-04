Feature: Editor Page - Adding a Text Element
  As a user
  I want to customize a text element
  So that I can visualize it in preview

  Scenario Outline: Add <name> element and validate default properties
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section '<sectionName>' to page
    When prepare the following items to be added to the page:
      | item | position | sibling | name   | sectionName   |
      | TEXT | -        | -      | <name> | <sectionName> |
    When prepare elements properties from the 'VerifyTextElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get editor properties for the '<name>' item from the section '<sectionName>'
    Then validate default properties of the item '<name>'

    Examples:
      | name   | sectionName |
      | TEXT_1 | SECTION_1   |