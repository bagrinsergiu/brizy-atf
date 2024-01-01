Feature: Editor Page - Adding a Progress Bar Element
  As a user
  I want to add a progress bar element
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
      | PROGRESS | -        | -      | PROGRESS_1 | SECTION_1   |

  Scenario Outline: Add progress bar element and validate default properties
    When prepare elements properties from the 'VerifyProgressBarElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get editor properties for the '<name>' item from the section '<sectionName>'
    Then validate default properties of the item '<name>'

    Examples:
      | name       | sectionName |
      | PROGRESS_1 | SECTION_1   |

  Scenario Outline: Add progress bar element and validate <sliderToCheck> slider
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    When get value of the '<sliderToCheck>' slider
    Then the following state is active: <state>

    Examples:
      | tabToOpen    | toolbarItem  | name       | sectionName | sliderToCheck | state |
      | Progress Bar | Progress Bar | PROGRESS_1 | SECTION_1   | title         | true  |
      | Progress Bar | Progress Bar | PROGRESS_1 | SECTION_1   | percentage    | true  |

  Scenario Outline: Add progress bar element and validate default progress bar style
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    When get selected items from '<configurationToCheck>' radio group
    Then the following item is active: <expectedStyle>
    When get all items from '<configurationToCheck>' radio group
    Then the following items are displayed:
      | STYLE_1 |
      | STYLE_2 |

    Examples:
      | tabToOpen    | toolbarItem  | name       | sectionName | configurationToCheck | expectedStyle |
      | Progress Bar | Progress Bar | PROGRESS_1 | SECTION_1   | style                | STYLE_1       |

  Scenario Outline: Add progress bar element and validate <option> style configurations
    When prepare elements properties from the 'VerifyProgressBarElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    Then the following configurations should be displayed: <displayedConfigurations>

    Examples:
      | option   | tabToOpen    | toolbarItem  | name       | sectionName | displayedConfigurations        |
      | no title | Progress Bar | Progress Bar | PROGRESS_1 | SECTION_1   | Style, Fill, Percentage        |
      | title    | Progress Bar | Progress Bar | PROGRESS_1 | SECTION_1   | Style, Fill, Title, Percentage |
