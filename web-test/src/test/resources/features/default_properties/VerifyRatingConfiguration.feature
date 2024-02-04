Feature: Editor Page - Adding a Rating Element
  As a user
  I want to add a rating element
  So that I can see some default properties

  Background:
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_1' to page
    When prepare the following items to be added to the page:
      | item   | position | sibling | name     | sectionName |
      | RATING | -        | -      | RATING_1 | SECTION_1   |

  Scenario Outline: Add rating element and validate default properties
    When prepare elements properties from the 'VerifyRatingElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get editor properties for the '<name>' item from the section '<sectionName>'

    Examples:
      | name     | sectionName |
      | RATING_1 | SECTION_1   |

  Scenario Outline: Validate configurations inside rating popup in <tabToOpen> tab
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    Then the following configurations should be displayed: <displayedConfigurations>

    Examples:
      | tabToOpen | toolbarItem | name     | sectionName | displayedConfigurations                     |
      | Rating    | Rating      | RATING_1 | SECTION_1   | Rating scale, Style, Label, Spacing, Rating |
      | Icons     | Rating      | RATING_1 | SECTION_1   | Icon, Size, Spacing                         |

  Scenario Outline: Add rating element and validate rating scales
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get selected value of the 'rating scale' dropdown
    Then the following item is active: 0-5
    When get text content of 'rating scale' dropdown
    Then dropdown contains the following values:
      | 0-5  |
      | 0-10 |

    Examples:
      | tabToOpen | toolbarItem | name     | sectionName |
      | Rating    | Rating      | RATING_1 | SECTION_1   |

  Scenario Outline: Add rating element and validate <radioItem> value in <tabToOpen> tab
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    When get active item from '<radioItem>' radio group
    Then the following item is active: <expectedValue>

    Examples:
      | tabToOpen | toolbarItem | name     | sectionName | radioItem | expectedValue |
      | Rating    | Rating      | RATING_1 | SECTION_1   | style     | NO_FILL       |
      | Rating    | Rating      | RATING_1 | SECTION_1   | label     | LEFT          |
      | Icons     | Rating      | RATING_1 | SECTION_1   | size      | SIZE_16       |

  Scenario Outline: Add rating element and validate <inputItem> value in <tabToOpen> tab
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    When get value of the '<inputItem>' input with units
    Then the following number value is set: <expectedValue>

    Examples:
      | tabToOpen | toolbarItem | name     | sectionName | inputItem | expectedValue |
      | Rating    | Rating      | RATING_1 | SECTION_1   | spacing   | 15            |
      | Icons     | Rating      | RATING_1 | SECTION_1   | spacing   | 3             |

  Scenario Outline: Add rating element and validate <inputItem> value in <tabToOpen> tab
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    When get value of the '<inputItem>' input with population
    Then the following item is active: <expectedValue>

    Examples:
      | tabToOpen | toolbarItem | name     | sectionName | inputItem | expectedValue |
      | Rating    | Rating      | RATING_1 | SECTION_1   | rating    | 2.5           |

  Scenario Outline: Validate configurations inside rating popup in <tabToOpen> tab for style fill
    When prepare elements properties from the 'VerifyRatingElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    Then the following configurations should be displayed: <displayedConfigurations>

    Examples:
      | tabToOpen | toolbarItem | name     | sectionName | displayedConfigurations                     |
      | Rating    | Rating      | RATING_1 | SECTION_1   | Rating scale, Style, Label, Spacing, Rating |
      | Icon      | Rating      | RATING_1 | SECTION_1   | Icon, Size                                  |

  Scenario Outline: Validate configurations inside rating popup in <tabToOpen> tab for style fill
    When prepare elements properties from the 'VerifyRatingElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    Then the following configurations should be displayed: <displayedConfigurations>

    Examples:
      | tabToOpen | toolbarItem | name     | sectionName | displayedConfigurations                     |
      | Rating    | Rating      | RATING_1 | SECTION_1   | Rating scale, Style, Label, Spacing, Rating |
      | Icon      | Rating      | RATING_1 | SECTION_1   | Icon, Size                                  |

  Scenario Outline: Validate rating tabs for style fill and no label
    When prepare elements properties from the 'VerifyRatingElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get tabs list from '<toolbarItem>' toolbar item for '<name>' item from section '<sectionName>'
    Then the following tabs should be displayed in the opened popup: <displayedTabs>
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    Then the following configurations should be displayed: <displayedConfigurations>

    Examples:
      | tabToOpen | toolbarItem | name     | sectionName | displayedTabs | displayedConfigurations            |
      | Rating    | Rating      | RATING_1 | SECTION_1   | [blank]       | Rating scale, Style, Label, Rating |
