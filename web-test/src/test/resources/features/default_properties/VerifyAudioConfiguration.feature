Feature: Editor Page - Adding an Audio Element
  As a user
  I want to add an audio element
  So that I can see some default properties

  Background: Add audio element to the page
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_1' to page
    When prepare the following items to be added to the page:
      | item  | position | sibling | name    | sectionName |
      | AUDIO | -        | -      | AUDIO_1 | SECTION_1   |
    And add the item to the page

  Scenario Outline: Validate negative audio configuration inside audio popup in audio tab
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And upload the file 'github_logo.xcf' to 'file' configuration
    When get alerts displayed on the page
    Then no alerts should be displayed

    Examples:
      | tabToOpen | toolbarItem | name    | sectionName |
      | Audio     | Audio       | AUDIO_1 | SECTION_1   |

  Scenario Outline: Add audio element and validate audio source
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get text content of 'audio' dropdown
    Then dropdown contains the following values:
      | SoundCloud |
      | Custom     |

    Examples:
      | tabToOpen | toolbarItem | name    | sectionName |
      | Audio     | Audio       | AUDIO_1 | SECTION_1   |

  Scenario Outline: Add <audioType> audio element and validate <tabToOpen> tab content
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And set '<audioType>' value for 'audio' dropdown
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    Then the following configurations should be displayed: <displayedConfigurations>

    Examples:
      | audioType  | tabToOpen  | toolbarItem | name    | sectionName | displayedConfigurations                  |
      | SoundCloud | Audio      | Audio       | AUDIO_1 | SECTION_1   | Audio, Link, Style, Autoplay             |
      | SoundCloud | Appearence | Audio       | AUDIO_1 | SECTION_1   | Artwork, Comments, Play Counts, Username |
      | SoundCloud | Buttons    | Audio       | AUDIO_1 | SECTION_1   | Like, Buy, Download, Share               |
      | Custom     | Audio      | Audio       | AUDIO_1 | SECTION_1   | Audio, File, Icons, Loop                 |
#      | Custom     | Cover      | Audio       | AUDIO_1 | SECTION_1   | Cover, Zoom                              |
#      | Custom     | Advanced   | Audio       | AUDIO_1 | SECTION_1   | Time, Duration, Progress, Volume         |

  Scenario Outline: Add audio element and validate <tabToOpen> tab default content
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    When get active item from 'style' radio group
    Then the following item is active: STYLE_1
    When get value of the 'link' input with population
    Then the following item is active: https://soundcloud.com/englicious/lord-of-the-flies-audiobook-slightly-sped-up
    When get value of the 'autoplay' slider
    Then the following state is active: false

    Examples:
      | tabToOpen | toolbarItem | name    | sectionName |
      | Audio     | Audio       | AUDIO_1 | SECTION_1   |

  Scenario Outline: Add audio element and validate <tabToOpen> tab default content
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    Then the following configurations should be displayed: <displayedConfigurations>

    Examples:
      | tabToOpen | toolbarItem | name    | sectionName | displayedConfigurations |
      | Settings  | Settings    | AUDIO_1 | SECTION_1   | Width, Height           |

  Scenario Outline: Add audio element and validate <tabToOpen> tab default content
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    When get value of the 'artwork' slider
    Then the following state is active: true
    When get value of the 'comments' slider
    Then the following state is active: true
    When get value of the 'play counts' slider
    Then the following state is active: true
    When get value of the 'username' slider
    Then the following state is active: true

    Examples:
      | tabToOpen  | toolbarItem | name    | sectionName |
      | Appearence | Audio       | AUDIO_1 | SECTION_1   |

  Scenario Outline: Add audio element and validate <tabToOpen> tab default content
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    When get value of the 'like' slider
    Then the following state is active: true
    When get value of the 'buy' slider
    Then the following state is active: true
    When get value of the 'download' slider
    Then the following state is active: true
    When get value of the 'share' slider
    Then the following state is active: true

    Examples:
      | tabToOpen | toolbarItem | name    | sectionName |
      | Buttons   | Audio       | AUDIO_1 | SECTION_1   |
