Feature: Editor Page - Adding a Video Element
  As a user
  I want to add a spacer element
  So that I can see some default properties

  Background:
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_1' to page
    When prepare the following items to be added to the page:
      | item  | position | parent | name    | sectionName |
      | VIDEO | -        | -      | VIDEO_1 | SECTION_1   |

  Scenario Outline: Add video element and validate default properties
    When prepare elements properties from the 'VerifyVideoElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get editor properties for the '<name>' item from the section '<sectionName>'

    Examples:
      | name    | sectionName |
      | VIDEO_1 | SECTION_1   |

  Scenario Outline: Validate configurations inside video popup in <tabToOpen> tab
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    Then the following configurations should be displayed: <displayedConfigurations>

    Examples:
      | tabToOpen | toolbarItem | name    | sectionName | displayedConfigurations                                  |
      | Video     | Video       | VIDEO_1 | SECTION_1   | Type, Ratio, Link                                        |
      | Playback  | Video       | VIDEO_1 | SECTION_1   | Autoplay, Muted, Loop, Suggested Videos, Start, End      |
      | Player    | Video       | VIDEO_1 | SECTION_1   | Cover Image, Controls, Branding, Lazy Load, Privacy Mode |

  Scenario Outline: Add video element and validate video types
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get selected value of the 'type' dropdown
    Then the following item is active: YouTube
    When get text content of 'type' dropdown
    Then dropdown contains the following values:
      | YouTube      |
      | Vimeo        |
      | Custom Video |
      | URL          |

    Examples:
      | tabToOpen | toolbarItem | name    | sectionName |
      | Video     | Video       | VIDEO_1 | SECTION_1   |

  Scenario Outline: Add video element and validate ratio types
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get selected value of the 'ratio' dropdown
    Then the following item is active: 16:9
    When get text content of 'ratio' dropdown
    Then dropdown contains the following values:
      | 1:1  |
      | 3:2  |
      | 4:3  |
      | 9:16 |
      | 16:9 |
      | 21:9 |

    Examples:
      | tabToOpen | toolbarItem | name    | sectionName |
      | Video     | Video       | VIDEO_1 | SECTION_1   |

  Scenario Outline: Add video element and validate link
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    When get value of the 'link' input with population
    Then the following item is active: https://www.youtube.com/watch?v=4dzj5rEFAdk

    Examples:
      | tabToOpen | toolbarItem | name    | sectionName |
      | Video     | Video       | VIDEO_1 | SECTION_1   |

  Scenario Outline: Add video element and validate <sliderToCheck> value in <tabToOpen> tab
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    When get value of the '<sliderToCheck>' slider
    Then the following state is active: false

    Examples:
      | tabToOpen | toolbarItem | name    | sectionName | sliderToCheck |
      | Playback  | Video       | VIDEO_1 | SECTION_1   | autoplay      |
      | Playback  | Video       | VIDEO_1 | SECTION_1   | muted         |
      | Playback  | Video       | VIDEO_1 | SECTION_1   | loop          |

  Scenario Outline: Add video element and validate suggested videos value in <tabToOpen> tab
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get selected value of the 'suggested videos' dropdown
    Then the following item is active: Current Video Channel
    When get text content of 'suggested videos' dropdown
    Then dropdown contains the following values:
      | Current Video Channel |
      | Any Video             |

    Examples:
      | tabToOpen | toolbarItem | name    | sectionName |
      | Playback  | Video       | VIDEO_1 | SECTION_1   |

  Scenario Outline: Add video element and validate <sliderToCheck> value in <tabToOpen> tab
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    When get value of the '<sliderToCheck>' slider
    Then the following state is active: <defaultValue>

    Examples:
      | tabToOpen | toolbarItem | name    | sectionName | sliderToCheck | defaultValue |
      | Player    | Video       | VIDEO_1 | SECTION_1   | controls      | true         |
      | Player    | Video       | VIDEO_1 | SECTION_1   | branding      | true         |
      | Player    | Video       | VIDEO_1 | SECTION_1   | lazy load     | true         |
      | Player    | Video       | VIDEO_1 | SECTION_1   | privacy mode  | false        |

  Scenario Outline: Validate negative picture configuration inside cover image popup in video tab
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And upload the file 'github_logo.xcf' to 'cover image' configuration
    And get alerts displayed on the page
    Then the following alerts should be displayed:
      | Failed to upload file. Please upload a valid JPG, PNG, SVG or GIF image. |

    Examples:
      | tabToOpen | toolbarItem | name    | sectionName |
      | Player    | Video       | VIDEO_1 | SECTION_1   |

  Scenario Outline: Add video element and validate vimeo default tab configurations
    When prepare elements properties from the 'VerifyVideoElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    Then the following configurations should be displayed: <displayedConfigurations>

    Examples:
      | tabToOpen | toolbarItem | name    | sectionName | displayedConfigurations      |
      | Video     | Video       | VIDEO_1 | SECTION_1   | Type, Ratio, Link            |
      | Playback  | Video       | VIDEO_1 | SECTION_1   | Autoplay, Muted, Loop, Start |
      | Player    | Video       | VIDEO_1 | SECTION_1   | Cover Image, Controls, Intro |

  Scenario Outline: Add video element and validate vimeo ratio configuration
    When prepare elements properties from the 'VerifyVideoElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get selected value of the 'ratio' dropdown
    Then the following item is active: 16:9
    When get text content of 'ratio' dropdown
    Then dropdown contains the following values:
      | 1:1  |
      | 3:2  |
      | 4:3  |
      | 9:16 |
      | 16:9 |
      | 21:9 |

    Examples:
      | tabToOpen | toolbarItem | name    | sectionName |
      | Video     | Video       | VIDEO_1 | SECTION_1   |

  Scenario Outline: Add vimeo video element and validate playback tab sliders
    When prepare elements properties from the 'VerifyVideoElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    When get value of the '<sliderToCheck>' slider
    Then the following state is active: false

    Examples:
      | tabToOpen | toolbarItem | name    | sectionName | sliderToCheck |
      | Playback  | Video       | VIDEO_1 | SECTION_1   | autoplay      |
      | Playback  | Video       | VIDEO_1 | SECTION_1   | muted         |
      | Playback  | Video       | VIDEO_1 | SECTION_1   | loop          |

  Scenario Outline: Add video element and validate custom video default tab configurations
    When prepare elements properties from the 'VerifyVideoElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    Then the following configurations should be displayed: <displayedConfigurations>

    Examples:
      | tabToOpen | toolbarItem | name    | sectionName | displayedConfigurations           |
      | Video     | Video       | VIDEO_1 | SECTION_1   | Type, Ratio, File                 |
      | Playback  | Video       | VIDEO_1 | SECTION_1   | Autoplay, Muted, Loop, Start, End |
      | Player    | Video       | VIDEO_1 | SECTION_1   | Cover Image, Controls, Size       |

  Scenario Outline: Add video element and validate url default tab configurations
    When prepare elements properties from the 'VerifyVideoElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    Then the following configurations should be displayed: <displayedConfigurations>

    Examples:
      | tabToOpen | toolbarItem | name    | sectionName | displayedConfigurations           |
      | Video     | Video       | VIDEO_1 | SECTION_1   | Type, Ratio, Link                 |
      | Playback  | Video       | VIDEO_1 | SECTION_1   | Autoplay, Muted, Loop, Start, End |
      | Player    | Video       | VIDEO_1 | SECTION_1   | Cover Image, Controls             |