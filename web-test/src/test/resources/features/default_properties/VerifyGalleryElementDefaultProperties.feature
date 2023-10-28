@Smoke
Feature: Editor Page - Gallery Default Settings
  As a user
  I want to customize an gallery element
  So I need to have a toolbar with different configurations for it

  Background: Navigate to project and create a new one
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_1' to page

  Scenario Outline: Validate gallery toolbar default settings.
    When prepare the following items to be added to the page:
      | item    | position | parent | name   | sectionName   |
      | GALLERY | -        | -      | <name> | <sectionName> |
    And add the item to the page
    When get the toolbar items for '<name>' item from section '<sectionName>'
    Then the following toolbar items should be displayed:
      | Gallery   |
      | Settings  |
      | Duplicate |
      | Delete    |

    Examples:
      | name      | sectionName |
      | GALLERY_1 | SECTION_1   |

  @Test
  Scenario Outline: Add gallery element and configure default properties.
    When prepare the following items to be added to the page:
      | item    | position | parent | name   | sectionName   |
      | GALLERY | -        | -      | <name> | <sectionName> |
    When prepare elements properties from the 'VerifyGalleryElement.json' file
    And add the item to the page
    And configure the item added to the page

    Examples:
      | name      | sectionName |
      | GALLERY_1 | SECTION_1   |

  Scenario Outline: Validate picture configuration inside image popup in image tab
    When prepare the following items to be added to the page:
      | item  | position | parent | name   | sectionName   |
      | IMAGE | -        | -      | <name> | <sectionName> |
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And upload the file 'github_logo.png' to 'image' configuration
    When get alerts displayed on the page
    Then no alerts should be displayed

    Examples:
      | tabToOpen | toolbarItem | name    | sectionName |
      | Image     | Image       | IMAGE_1 | SECTION_1   |

  Scenario Outline: Add <name> element and validate configurations inside image popup in mask tab
    When prepare the following items to be added to the page:
      | item  | position | parent | name   | sectionName   |
      | IMAGE | -        | -      | <name> | <sectionName> |
    When prepare elements properties from the 'VerifyImageElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    Then the following configurations should be displayed: <displayedConfigurations>

    Examples:
      | tabToOpen | toolbarItem | name    | sectionName | displayedConfigurations       |
      | Mask      | Image       | IMAGE_1 | SECTION_1   | Shape                         |
      | Mask      | Image       | IMAGE_2 | SECTION_1   | Shape, Size, Position         |
      | Mask      | Image       | IMAGE_3 | SECTION_1   | Shape, Size, Position, Repeat |
      | Mask      | Image       | IMAGE_4 | SECTION_1   | Shape, Size, Position, Repeat |
      | Mask      | Image       | IMAGE_5 | SECTION_1   | Shape, Image                  |

  Scenario Outline: Validate shape dropdown items in mask tab
    When prepare the following items to be added to the page:
      | item  | position | parent | name   | sectionName   |
      | IMAGE | -        | -      | <name> | <sectionName> |
    When prepare elements properties from the 'VerifyImageElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get value content of 'shape' dropdown
    Then dropdown contains the following values:
      | none     |
      | circle   |
      | rhombus  |
      | star     |
      | flower   |
      | square   |
      | triangle |
      | hexagon  |
      | blob1    |
      | blob2    |
      | blob3    |
      | blob4    |
      | brush1   |
      | brush2   |
      | brush3   |
      | brush4   |
      | poly1    |
      | poly2    |
      | poly3    |
      | poly4    |
      | custom   |

    Examples:
      | tabToOpen | toolbarItem | name    | sectionName |
      | Mask      | Image       | IMAGE_1 | SECTION_1   |


  Scenario Outline: Validate size dropdown items in mask tab
    When prepare the following items to be added to the page:
      | item  | position | parent | name   | sectionName   |
      | IMAGE | -        | -      | <name> | <sectionName> |
    When prepare elements properties from the 'VerifyImageElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get text content of 'size' dropdown
    Then dropdown contains the following values:
      | Fit    |
      | Fill   |
      | Custom |

    Examples:
      | tabToOpen | toolbarItem | name    | sectionName |
      | Mask      | Image       | IMAGE_4 | SECTION_1   |

  Scenario Outline: Validate position dropdown items in mask tab
    When prepare the following items to be added to the page:
      | item  | position | parent | name   | sectionName   |
      | IMAGE | -        | -      | <name> | <sectionName> |
    When prepare elements properties from the 'VerifyImageElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get text content of 'position' dropdown
    Then dropdown contains the following values:
      | Center Center |
      | Center Left   |
      | Center Right  |
      | Top Center    |
      | Top Right     |
      | Top Left      |
      | Bottom Center |
      | Bottom Left   |
      | Bottom Right  |
      | Custom        |

    Examples:
      | tabToOpen | toolbarItem | name    | sectionName |
      | Mask      | Image       | IMAGE_1 | SECTION_1   |

  Scenario Outline: Validate repeat dropdown items in mask tab
    When prepare the following items to be added to the page:
      | item  | position | parent | name   | sectionName   |
      | IMAGE | -        | -      | <name> | <sectionName> |
    When prepare elements properties from the 'VerifyImageElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get text content of 'repeat' dropdown
    Then dropdown contains the following values:
      | No Repeat |
      | Repeat    |
      | Repeat-X  |
      | Repeat-Y  |
      | Space     |
      | Round     |

    Examples:
      | tabToOpen | toolbarItem | name    | sectionName |
      | Mask      | Image       | IMAGE_2 | SECTION_1   |

  Scenario Outline: Validate size units dropdown items in mask tab
    When prepare the following items to be added to the page:
      | item  | position | parent | name   | sectionName   |
      | IMAGE | -        | -      | <name> | <sectionName> |
    When prepare elements properties from the 'VerifyImageElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get text content of 'sizeUnit' dropdown
    Then dropdown contains the following values:
      | %  |
      | px |

    Examples:
      | tabToOpen | toolbarItem | name    | sectionName |
      | Mask      | Image       | IMAGE_3 | SECTION_1   |