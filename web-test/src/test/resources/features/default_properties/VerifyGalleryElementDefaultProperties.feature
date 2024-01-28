Feature: Editor Page - Adding a Gallery Element
  As a user
  I want to add a gallery element
  So that I can see some default properties

  Background:
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_1' to page
    When prepare the following items to be added to the page:
      | item    | position | parent | name      | sectionName |
      | GALLERY | -        | -      | GALLERY_1 | SECTION_1   |

  Scenario Outline: Add gallery element and validate default properties
    When prepare elements properties from the 'VerifyGalleryElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get editor properties for the '<name>' item from the section '<sectionName>'
    Then validate default properties of the item '<name>'

    Examples:
      | name      | sectionName |
      | GALLERY_1 | SECTION_1   |

  Scenario Outline: Add gallery element and validate layout dropdown
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get text content of 'layout' dropdown
    Then dropdown contains the following values:
      | Grid      |
      | Justified |
      | Masonry   |
      | Big Image |

    Examples:
      | tabToOpen | toolbarItem | name      | sectionName |
      | Gallery   | Gallery     | GALLERY_1 | SECTION_1   |

  Scenario Outline: Add gallery element and validate aspect ratio dropdown
    When prepare elements properties from the 'VerifyGalleryElement.json' file
    And add the item to the page
    And configure the item added to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And get text content of 'aspect ratio' dropdown
    Then dropdown contains the following values:
      | 1:1  |
      | 3:2  |
      | 4:3  |
      | 9:16 |
      | 16:9 |
      | 21:9 |

    Examples:
      | tabToOpen | toolbarItem | name      | sectionName |
      | Gallery   | Gallery     | GALLERY_1 | SECTION_1   |

  Scenario Outline: Add gallery element and validate configurations for <layout> layout
    When prepare elements properties from the 'VerifyGalleryElement.json' file
    And add the item to the page
    And configure the item added to the page
    And get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    Then the following configurations should be displayed: <displayedConfigurations>

    Examples:
      | tabToOpen | toolbarItem | name      | sectionName | layout    | displayedConfigurations                                     |
      | Gallery   | Gallery     | GALLERY_1 | SECTION_1   | grid      | Images, Layout, Aspect Ratio, Enable Tags, Open in Lightbox |
      | Gallery   | Gallery     | GALLERY_1 | SECTION_1   | justified | Images, Layout, Height, Enable Tags, Open in Lightbox       |
      | Gallery   | Gallery     | GALLERY_1 | SECTION_1   | masonry   | Images, Layout, Enable Tags, Open in Lightbox               |
      | Gallery   | Gallery     | GALLERY_1 | SECTION_1   | big image | Images, Layout,  Open in Lightbox                           |
      | Items     | Gallery     | GALLERY_1 | SECTION_1   | grid      | Columns, Spacing                                            |
      | Items     | Gallery     | GALLERY_1 | SECTION_1   | justified | Spacing                                                     |
      | Items     | Gallery     | GALLERY_1 | SECTION_1   | masonry   | Columns, Spacing                                            |
      | Items     | Gallery     | GALLERY_1 | SECTION_1   | big image | Columns                                                     |

  Scenario Outline: Add gallery element and validate default layout dropdown value
    When add the item to the page
    And get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    When get selected value of the 'layout' dropdown
    Then the following item is active: Masonry

    Examples:
      | tabToOpen | toolbarItem | name      | sectionName |
      | Gallery   | Gallery     | GALLERY_1 | SECTION_1   |

  Scenario Outline: Add gallery element and validate default <sliderToCheck> slider value
    When add the item to the page
    And get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    When get value of the '<sliderToCheck>' slider
    Then the following state is active: <state>

    Examples:
      | tabToOpen | toolbarItem | name      | sectionName | state | sliderToCheck    |
      | Gallery   | Gallery     | GALLERY_1 | SECTION_1   | true  | enable tags      |
      | Gallery   | Gallery     | GALLERY_1 | SECTION_1   | false | open in lightbox |

  Scenario Outline: Add gallery element and validate default height value
    When prepare elements properties from the 'VerifyGalleryElement.json' file
    And add the item to the page
    And configure the item added to the page
    And get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    When get value of the 'height' input with units
    Then the following number value is set: 350

    Examples:
      | tabToOpen | toolbarItem | name      | sectionName |
      | Gallery   | Gallery     | GALLERY_1 | SECTION_1   |

  Scenario Outline: Add gallery element and validate uploading of an invalid image
    When add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And upload the file 'github_logo.xcf' to 'images' configuration
    When wait for an alert popup to show
    And get alerts displayed on the page
    Then the following alerts should be displayed:
      | Failed to upload file. Please upload a valid image |

    Examples:
      | tabToOpen | toolbarItem | name      | sectionName |
      | Gallery   | Gallery     | GALLERY_1 | SECTION_1   |

  Scenario Outline: Add gallery element and validate uploading of a valid image
    When add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    And upload the file 'github_logo.png' to 'images' configuration
    When wait for file uploading to finish
    When get alerts displayed on the page
    Then no alerts should be displayed

    Examples:
      | tabToOpen | toolbarItem | name      | sectionName |
      | Gallery   | Gallery     | GALLERY_1 | SECTION_1   |

  Scenario Outline: Add gallery element and validate configurations for <layout> layout
    When prepare elements properties from the 'VerifyGalleryElement.json' file
    And add the item to the page
    And configure the item added to the page
    And get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    When get value of the '<inputToCheck>' input with units
    Then the following number value is set: <expectedValue>

    Examples:
      | tabToOpen | toolbarItem | name      | sectionName | layout    | inputToCheck | expectedValue |
      | Items     | Gallery     | GALLERY_1 | SECTION_1   | grid      | columns      | 2             |
      | Items     | Gallery     | GALLERY_1 | SECTION_1   | grid      | spacing      | 5             |
      | Items     | Gallery     | GALLERY_1 | SECTION_1   | justified | spacing      | 5             |
      | Items     | Gallery     | GALLERY_1 | SECTION_1   | masonry   | columns      | 2             |
      | Items     | Gallery     | GALLERY_1 | SECTION_1   | masonry   | spacing      | 5             |
      | Items     | Gallery     | GALLERY_1 | SECTION_1   | big image | columns      | 2             |
