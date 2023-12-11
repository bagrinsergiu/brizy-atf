@Smoke
Feature: Editor Page - Adding a Lottie Element
  As a user
  I want to add a lottie element
  So that I can see some default properties

  Background:
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_1' to page
    When prepare the following items to be added to the page:
      | item   | position | parent | name     | sectionName |
      | LOTTIE | -        | -      | LOTTIE_1 | SECTION_1   |

  Scenario Outline: Add lottie element and validate default properties
    When prepare elements properties from the 'VerifyLottieElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get editor properties for the '<name>' item from the section '<sectionName>'
    Then validate default properties of the item '<name>'

    Examples:
      | name     | sectionName |
      | LOTTIE_1 | SECTION_1   |

  Scenario Outline: Add lottie element and validate renderer types
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get selected value of the 'renderer' dropdown
    Then the following item is active: SVG
    When get text content of 'renderer' dropdown
    Then dropdown contains the following values:
      | SVG    |
      | Canvas |

    Examples:
      | tabToOpen | toolbarItem | name     | sectionName |
      | Lottie    | Lottie      | LOTTIE_1 | SECTION_1   |

  Scenario Outline: Add lottie element and validate sliders
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    When get value of the '<sliderToCheck>' slider
    Then the following state is active: <state>

    Examples:
      | tabToOpen | toolbarItem | name     | sectionName | sliderToCheck | state |
      | Lottie    | Lottie      | LOTTIE_1 | SECTION_1   | autoplay      | true  |
      | Lottie    | Lottie      | LOTTIE_1 | SECTION_1   | reverse       | false |
      | Lottie    | Lottie      | LOTTIE_1 | SECTION_1   | loop          | true  |

  Scenario Outline: Add lottie element and validate autoplay false tab configurations
    When prepare elements properties from the 'VerifyLottieElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    Then the following configurations should be displayed: <displayedConfigurations>

    Examples:
      | tabToOpen | toolbarItem | name     | sectionName | displayedConfigurations                             |
      | Lottie    | Lottie      | LOTTIE_1 | SECTION_1   | Lottie Link, Lottie File, Renderer, Autoplay, Speed |

  Scenario Outline: Add lottie element and validate autoplay false tab configurations for canvas renderer
    When prepare elements properties from the 'VerifyLottieElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    Then the following configurations should be displayed: <displayedConfigurations>

    Examples:
      | tabToOpen | toolbarItem | name     | sectionName | displayedConfigurations                             |
      | Lottie    | Lottie      | LOTTIE_1 | SECTION_1   | Lottie Link, Lottie File, Renderer, Autoplay, Speed |

  Scenario Outline: Add lottie element and validate tab configurations for canvas renderer
    When prepare elements properties from the 'VerifyLottieElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    Then the following configurations should be displayed: <displayedConfigurations>

    Examples:
      | tabToOpen | toolbarItem | name     | sectionName | displayedConfigurations                                            |
      | Lottie    | Lottie      | LOTTIE_1 | SECTION_1   | Lottie Link, Lottie File, Renderer, Autoplay, Reverse, Loop, Speed |

  Scenario Outline: Validate configurations in case of lottie file uploading
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And upload the file 'github_logo.xcf' to 'lottie file' configuration
    When wait for file uploading to finish
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    Then the following configurations should be displayed: <displayedConfigurations>

    Examples:
      | tabToOpen | toolbarItem | name     | sectionName | displayedConfigurations                               |
      | Lottie    | Lottie      | LOTTIE_1 | SECTION_1   | Lottie File, Renderer, Autoplay, Reverse, Loop, Speed |

  Scenario Outline: Validate lottie json file uploading
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And upload the file 'lottie.json' to 'lottie file' configuration
    When wait for file uploading to finish
    When get alerts displayed on the page
    Then no alerts should be displayed

    Examples:
      | tabToOpen | toolbarItem | name     | sectionName |
      | Lottie    | Lottie      | LOTTIE_1 | SECTION_1   |

  Scenario Outline: Validate negative empty json file uploading
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And upload the file 'empty_lottie.json' to 'lottie file' configuration
    When wait for file uploading to finish
    Then should see that an error happened while trying to display this element

    Examples:
      | tabToOpen | toolbarItem | name     | sectionName |
      | Lottie    | Lottie      | LOTTIE_1 | SECTION_1   |