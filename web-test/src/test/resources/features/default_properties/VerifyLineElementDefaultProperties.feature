Feature: Editor Page - Adding a Line Element
  As a user
  I want to add a line element
  So that I can see some default properties

  Background:
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_1' to page
    When prepare the following items to be added to the page:
      | item | position | sibling | name   | sectionName |
      | LINE | -        | -      | LINE_1 | SECTION_1   |

  Scenario Outline: Add line element and validate default properties
    When prepare elements properties from the 'VerifyLineElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get editor properties for the '<name>' item from the section '<sectionName>'
    Then validate default properties of the item '<name>'

    Examples:
      | name   | sectionName |
      | LINE_1 | SECTION_1   |

  Scenario Outline: Add line element and validate default displayed configurations
    When add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    Then the following configurations should be displayed: <displayedConfigurations>

    Examples:
      | tabToOpen | toolbarItem | name   | sectionName | displayedConfigurations |
      | Line      | Style       | LINE_1 | SECTION_1   | Style, Type, Height     |

  Scenario Outline: Add line element and validate default value for style configuration
    When add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    When get active item from 'style' radio group
    Then the following item is active: SOLID

    Examples:
      | tabToOpen | toolbarItem | name   | sectionName |
      | Line      | Style       | LINE_1 | SECTION_1   |

  Scenario Outline: Add line element and validate default value for type configurations
    When add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get value content of 'type' dropdown
    Then dropdown contains the following values:
      | solid         |
      | dashed        |
      | dotted        |
      | double        |
      | groove        |
      | ridge         |
      | inset         |
      | outset        |
      | diagonal-dash |
      | fence         |
      | fence2        |
      | hand-dashes   |
      | hand-dots     |
      | hand-flows    |
      | hand-leaves   |
      | line-dot      |
      | stars         |
      | waves         |

    Examples:
      | tabToOpen | toolbarItem | name   | sectionName |
      | Line      | Style       | LINE_1 | SECTION_1   |

  Scenario Outline: Add line element and validate default value for type configurations
    When add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get all item from 'style' radio group
    Then the following items are displayed:
      | SOLID |
      | TEXT  |
      | ICON  |

    Examples:
      | tabToOpen | toolbarItem | name   | sectionName |
      | Line      | Style       | LINE_1 | SECTION_1   |

  Scenario Outline: Add line element and validate configurations for <type> line type
    When add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And set '<type>' as value for 'type' dropdown
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    Then the following configurations should be displayed: <displayedConfigurations>

    Examples:
      | tabToOpen | toolbarItem | name   | sectionName | type          | displayedConfigurations             |
      | Line      | Style       | LINE_1 | SECTION_1   | solid         | Style, Type, Height                 |
      | Line      | Style       | LINE_1 | SECTION_1   | dashed        | Style, Type, Height                 |
      | Line      | Style       | LINE_1 | SECTION_1   | dotted        | Style, Type, Height                 |
      | Line      | Style       | LINE_1 | SECTION_1   | double        | Style, Type, Height                 |
      | Line      | Style       | LINE_1 | SECTION_1   | groove        | Style, Type, Height                 |
      | Line      | Style       | LINE_1 | SECTION_1   | ridge         | Style, Type, Height                 |
      | Line      | Style       | LINE_1 | SECTION_1   | inset         | Style, Type, Height                 |
      | Line      | Style       | LINE_1 | SECTION_1   | outset        | Style, Type, Height                 |
      | Line      | Style       | LINE_1 | SECTION_1   | diagonal-dash | Style, Type, Weight, Amount, Height |
      | Line      | Style       | LINE_1 | SECTION_1   | fence         | Style, Type, Weight, Amount, Height |
      | Line      | Style       | LINE_1 | SECTION_1   | fence2        | Style, Type, Weight, Amount, Height |
      | Line      | Style       | LINE_1 | SECTION_1   | hand-dashes   | Style, Type, Weight, Amount, Height |
      | Line      | Style       | LINE_1 | SECTION_1   | hand-dots     | Style, Type, Weight, Amount, Height |
      | Line      | Style       | LINE_1 | SECTION_1   | hand-flows    | Style, Type, Weight, Amount, Height |
      | Line      | Style       | LINE_1 | SECTION_1   | hand-leaves   | Style, Type, Weight, Amount, Height |
      | Line      | Style       | LINE_1 | SECTION_1   | line-dot      | Style, Type, Amount, Height         |
      | Line      | Style       | LINE_1 | SECTION_1   | stars         | Style, Type,  Amount, Height        |
      | Line      | Style       | LINE_1 | SECTION_1   | waves         | Style, Type, Weight, Amount, Height |

  Scenario Outline: Add line element and validate default value for height configurations
    When add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get value of the 'height' input with units
    Then the following number value is set: 2

    Examples:
      | tabToOpen | toolbarItem | name   | sectionName |
      | Line      | Style       | LINE_1 | SECTION_1   |

  Scenario Outline: Add line element and validate default value for height configurations
    When add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get range of values for the 'height' input with units
    Then the following range is set: [1..50]

    Examples:
      | tabToOpen | toolbarItem | name   | sectionName |
      | Line      | Style       | LINE_1 | SECTION_1   |

  Scenario Outline: Add text line element and validate tabs
    When prepare elements properties from the 'VerifyLineElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get tabs list from '<toolbarItem>' toolbar item for '<name>' item from section '<sectionName>'
    Then the following tabs should be displayed in the opened popup: <displayedTabs>

    Examples:
      | displayedTabs | toolbarItem | name   | sectionName |
      | Line,Text     | Style       | LINE_1 | SECTION_1   |

  Scenario Outline: Add text line element and validate default properties
    When prepare elements properties from the 'VerifyLineElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    Then the following configurations should be displayed: <displayedConfigurations>

    Examples:
      | tabToOpen | toolbarItem | name   | sectionName | displayedConfigurations |
      | Text      | Style       | LINE_1 | SECTION_1   | Align, Spacing          |

  Scenario Outline: Add text line element and validate configurations default properties
    When prepare elements properties from the 'VerifyLineElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    When get active item from 'align' radio group
    Then the following item is active: CENTER
    And get value of the 'spacing' input with units
    Then the following number value is set: 10

    Examples:
      | tabToOpen | toolbarItem | name   | sectionName |
      | Text      | Style       | LINE_1 | SECTION_1   |

  Scenario Outline: Add text line element and validate configurations default properties
    When prepare elements properties from the 'VerifyLineElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get all item from 'align' radio group
    Then the following items are displayed:
      | LEFT   |
      | CENTER |
      | RIGHT  |

    Examples:
      | tabToOpen | toolbarItem | name   | sectionName |
      | Text      | Style       | LINE_1 | SECTION_1   |

  Scenario Outline: Add icon line element and validate tabs
    When prepare elements properties from the 'VerifyLineElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get tabs list from '<toolbarItem>' toolbar item for '<name>' item from section '<sectionName>'
    Then the following tabs should be displayed in the opened popup: <displayedTabs>

    Examples:
      | displayedTabs | toolbarItem | name   | sectionName |
      | Line,Icon     | Style       | LINE_1 | SECTION_1   |

  Scenario Outline: Add icon line element and validate configurations default properties
    When prepare elements properties from the 'VerifyLineElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get value of the '<configuration>' input with units
    Then the following number value is set: <expectedValue>

    Examples:
      | tabToOpen | configuration | toolbarItem | name   | sectionName | expectedValue |
      | Icon      | spacing       | Style       | LINE_1 | SECTION_1   | 10            |
      | Icon      | padding       | Style       | LINE_1 | SECTION_1   | 0             |
      | Icon      | rotate        | Style       | LINE_1 | SECTION_1   | 0             |

  Scenario Outline: Add icon line element and validate configurations default properties
    When prepare elements properties from the 'VerifyLineElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get range of values for the '<configuration>' input with units
    Then the following range is set: <expectedValue>

    Examples:
      | tabToOpen | configuration | toolbarItem | name   | sectionName | expectedValue |
      | Icon      | spacing       | Style       | LINE_1 | SECTION_1   | [0..100]      |
      | Icon      | padding       | Style       | LINE_1 | SECTION_1   | [0..100]      |
      | Icon      | rotate        | Style       | LINE_1 | SECTION_1   | [0..360]      |

  Scenario Outline: Add icon line element and validate configurations default properties
    When prepare elements properties from the 'VerifyLineElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get active item from '<configuration>' radio group
    Then the following item is active: <expectedValue>

    Examples:
      | tabToOpen | configuration | toolbarItem | name   | sectionName | expectedValue |
      | Icon      | align         | Style       | LINE_1 | SECTION_1   | CENTER        |

  Scenario Outline: Add icon line element and validate configurations default properties
    When prepare elements properties from the 'VerifyLineElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get all item from '<configuration>' radio group
    Then the following items are displayed:
      | LEFT   |
      | CENTER |
      | RIGHT  |

    Examples:
      | tabToOpen | configuration | toolbarItem | name   | sectionName |
      | Icon      | align         | Style       | LINE_1 | SECTION_1   |

  Scenario Outline: Add icon line element and validate configurations default properties
    When prepare elements properties from the 'VerifyLineElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get active item from '<configuration>' size
    Then the following item is active: <expectedValue>

    Examples:
      | tabToOpen | configuration | toolbarItem | name   | sectionName | expectedValue |
      | Icon      | size          | Style       | LINE_1 | SECTION_1   | CUSTOM        |

  Scenario Outline: Add icon line element and validate configurations default properties
    When prepare elements properties from the 'VerifyLineElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get from '<configuration>' item custom size
    Then the following numeric value is set: 16

    Examples:
      | tabToOpen | configuration | toolbarItem | name   | sectionName |
      | Icon      | size          | Style       | LINE_1 | SECTION_1   |

  Scenario Outline: Add icon line element and validate configurations default properties
    When prepare elements properties from the 'VerifyLineElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get all item from '<configuration>' size
    Then the following items are displayed:
      | SIZE_16 |
      | SIZE_24 |
      | SIZE_32 |
      | CUSTOM  |

    Examples:
      | tabToOpen | configuration | toolbarItem | name   | sectionName |
      | Icon      | size          | Style       | LINE_1 | SECTION_1   |

  Scenario Outline: Add line element and validate setting text properties
    When prepare elements properties from the 'VerifyLineElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get editor properties for the '<name>' item from the section '<sectionName>'
    Then validate default properties of the item '<name>'

    Examples:
      | name   | sectionName |
      | LINE_1 | SECTION_1   |

  Scenario Outline: Add line element and validate setting icon properties
    When prepare elements properties from the 'VerifyLineElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get editor properties for the '<name>' item from the section '<sectionName>'
#    Then validate default properties of the item '<name>'

    Examples:
      | name   | sectionName |
      | LINE_1 | SECTION_1   |

