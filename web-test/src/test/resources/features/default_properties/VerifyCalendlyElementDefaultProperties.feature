Feature: Editor Page - Adding a Calendly Element
  As a user
  I want to add a calendly element
  So that I can see some default properties

  Background:
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_1' to page
    When prepare the following items to be added to the page:
      | item     | position | parent | name       | sectionName |
      | CALENDLY | -        | -      | CALENDLY_1 | SECTION_1   |

  Scenario Outline: Add calendly element and validate default properties
    When prepare elements properties from the 'VerifyCalendlyElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get editor properties for the '<name>' item from the section '<sectionName>'
    Then validate default properties of the item '<name>'

    Examples:
      | name       | sectionName |
      | CALENDLY_1 | SECTION_1   |

  Scenario Outline: Add calendly element and validate default configurations
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    Then the following configurations should be displayed: <displayedConfigurations>

    Examples:
      | tabToOpen | toolbarItem | name       | sectionName | displayedConfigurations |
      | Calendly  | Calendly    | CALENDLY_1 | SECTION_1   | Link                    |
      | Settings  | Settings    | CALENDLY_1 | SECTION_1   | Width, Height           |