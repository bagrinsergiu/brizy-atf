Feature: Editor Page - Adding Text element
  As a user
  I want to add a Text element to check revisions(Copy, Paste, Paste Styles, Duplicate, Delete)
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
      | item | position | parent | name   | sectionName   |
      | Text | -        | -      | <name> | <sectionName> |
    And add the item to the page
    When right click '<name>' item
    Then validate menu actions:
      | title | keyShortcut | isEnabled |
      | Copy  | ctrl + C    | true      |

    Examples:
      | name   | sectionName |
      | TEXT_1 | SECTION_1   |

  Scenario Outline: Validate <action> action
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
    When <action> the following item '<name>'
    Then validate that section '<sectionName>' contains '<itemsCount>' items

    Examples:
      | name  | sectionName | itemsCount | action    |
      | MAP_1 | SECTION_1   | 1          | delete    |
      | MAP_1 | SECTION_1   | 3          | duplicate |


  Scenario Outline: Validate copy and paste action
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
    When copy the following item '<name>'
    And paste the following item 'MAP_2'
    Then validate that section '<sectionName>' contains '3' items

    Examples:
      | name  | sectionName |
      | MAP_1 | SECTION_1   |
      | MAP_1 | SECTION_1   |

  Scenario Outline: Validate copy and paste styles action
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
      | TEXT | -        | -      | <name> | <sectionName> |
      | TEXT | BOTTOM   | <name> | TEXT_2 | <sectionName> |
    When prepare elements properties from the 'VerifyMapElement.json' file
    And add the item to the page
    When copy the following item '<name>'
    And paste styles the following item 'TEXT_2'
    Then validate that section '<sectionName>' contains '2' items
    And validate css properties of the components

    Examples:
      | name   | sectionName |
      | TEXT_1 | SECTION_1   |
