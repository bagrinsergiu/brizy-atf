Feature: Editor Page - Adding a Countdown Element
  As a user
  I want to add a countdown element
  So that I can see some default properties

  Background: Add countdown element
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_1' to page
    When prepare the following items to be added to the page:
      | item      | position | parent | name        | sectionName |
      | COUNTDOWN | -        | -      | COUNTDOWN_1 | SECTION_1   |

  Scenario Outline: Validate countdown default properties
    When prepare elements properties from the 'VerifyCountdownElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get editor properties for the '<name>' item from the section '<sectionName>'
    Then validate default properties of the item '<name>'

    Examples:
      | name        | sectionName |
      | COUNTDOWN_1 | SECTION_1   |

  Scenario Outline: Validate countdown toolbar popup tabs
    And add the item to the page
    When get tabs list from '<toolbarItem>' toolbar item for '<name>' item from section '<sectionName>'
    Then the following tabs should be displayed in the opened popup: <displayedTabs>

    Examples:
      | toolbarItem | name        | sectionName | displayedTabs   |
      | Countdown   | COUNTDOWN_1 | SECTION_1   | Timer, Advanced |

  Scenario Outline: Validate countdown <tabToOpen> default configurations
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    Then the following configurations should be displayed: <displayedConfigurations>
    Examples:
      | tabToOpen | toolbarItem | name        | sectionName | displayedConfigurations               |
      | Timer     | Countdown   | COUNTDOWN_1 | SECTION_1   | Styles, Date,Hour, Minutes, Time Zone |
      | Advanced  | Countdown   | COUNTDOWN_1 | SECTION_1   | Days, Hours, Minutes, Seconds         |

  Scenario Outline: Validate countdown default styles
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    When get active item from 'styles' radio group
    Then the following item is active: STYLE_1
    When get all items from 'styles' radio group
    Then the following items are displayed:
      | STYLE_1 |
      | STYLE_2 |
      | STYLE_3 |

    Examples:
      | tabToOpen | toolbarItem | name        | sectionName |
      | Timer     | Countdown   | COUNTDOWN_1 | SECTION_1   |

  Scenario Outline: Validate countdown <configurationToCheck> default value
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get value of the '<configurationToCheck>' input with population
    Then the following item is active: <expectedValue>

    Examples:
      | tabToOpen | toolbarItem | name        | sectionName | configurationToCheck | expectedValue |
      | Timer     | Countdown   | COUNTDOWN_1 | SECTION_1   | date                 | 27/1/2024     |

  Scenario Outline: Validate countdown <configurationToCheck> default value
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get value of the '<configurationToCheck>' dropdown with population
    Then the following item is active: <expectedValue>

    Examples:
      | tabToOpen | toolbarItem | name        | sectionName | configurationToCheck | expectedValue |
      | Timer     | Countdown   | COUNTDOWN_1 | SECTION_1   | hour                 | 10 am         |
      | Timer     | Countdown   | COUNTDOWN_1 | SECTION_1   | minutes              | 30 m          |

  Scenario Outline: Validate countdown <configurationToCheck> default value
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get selected value of the '<configurationToCheck>' dropdown
    Then the following item is active: <expectedValue>

    Examples:
      | tabToOpen | toolbarItem | name        | sectionName | configurationToCheck | expectedValue                      |
      | Timer     | Countdown   | COUNTDOWN_1 | SECTION_1   | time zone            | + 2:00 (Athens, Istanbul, Romania) |

  Scenario Outline: Validate countdown <configurationToCheck> default value
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    When get value of the '<configurationToCheck>' slider
    Then the following state is active: <expectedValue>

    Examples:
      | tabToOpen | toolbarItem | name        | sectionName | configurationToCheck | expectedValue |
      | Advanced  | Countdown   | COUNTDOWN_1 | SECTION_1   | days                 | true          |
      | Advanced  | Countdown   | COUNTDOWN_1 | SECTION_1   | hours                | true          |
      | Advanced  | Countdown   | COUNTDOWN_1 | SECTION_1   | minutes              | true          |
      | Advanced  | Countdown   | COUNTDOWN_1 | SECTION_1   | seconds              | true          |

