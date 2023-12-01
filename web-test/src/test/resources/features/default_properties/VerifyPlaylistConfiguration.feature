@Smoke
Feature: Editor Page - Adding an Playlist Element
  As a user
  I want to add an playlist element
  So that I can see some default properties

  Scenario Outline: Add playlist element and validate default properties
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section '<sectionName>' to page
    When prepare the following items to be added to the page:
      | item     | position | parent | name   | sectionName   |
      | PLAYLIST | -        | -      | <name> | <sectionName> |
    When prepare elements properties from the 'VerifyPlaylistElement.json' file
    And add the item to the page
    And configure the item added to the page

    Examples:
      | name       | sectionName |
      | PLAYLIST_1 | SECTION_1   |

  Scenario Outline: Add playlist element and validate sidebar position
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section '<sectionName>' to page
    When prepare the following items to be added to the page:
      | item     | position | parent | name   | sectionName   |
      | PLAYLIST | -        | -      | <name> | <sectionName> |
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get text content of 'position' dropdown
    Then dropdown contains the following values:
      | Horizontal |
      | Vertical   |

    Examples:
      | tabToOpen | toolbarItem | name       | sectionName |
      | Playlist  | Playlist    | PLAYLIST_1 | SECTION_1   |

  Scenario Outline: Add playlist element and validate vertical sidebar position
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section '<sectionName>' to page
    When prepare the following items to be added to the page:
      | item     | position | parent | name   | sectionName   |
      | PLAYLIST | -        | -      | <name> | <sectionName> |
    When prepare elements properties from the 'VerifyPlaylistElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    When get value of the 'columns' input with units
    Then the following number value is set: 2

    Examples:
      | tabToOpen | toolbarItem | name       | sectionName |
      | Playlist  | Playlist    | PLAYLIST_1 | SECTION_1   |

  Scenario Outline: Add playlist element and validate vertical sidebar position
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section '<sectionName>' to page
    When prepare the following items to be added to the page:
      | item     | position | parent | name   | sectionName   |
      | PLAYLIST | -        | -      | <name> | <sectionName> |
    When prepare elements properties from the 'VerifyPlaylistElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get text content of 'thumbs' dropdown
    Then dropdown contains the following values:
      | Top    |
      | Bottom |

    Examples:
      | tabToOpen | toolbarItem | name       | sectionName |
      | Playlist  | Playlist    | PLAYLIST_1 | SECTION_1   |