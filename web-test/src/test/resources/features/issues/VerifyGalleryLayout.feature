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

  Scenario Outline: 26160 - Gallery element wrong size
    When prepare elements properties from the 'VerifyGalleryElement.json' file
    And add the item to the page
    And configure the item added to the page
    When save draft page
    And publish the page
    When on the published page
    And on the '1'st section of the page
    When search for the '1'st 'gallery' component
    And get the dimensions of the published component
    Then the component dimensions satisfies '16:9' aspect ratio

    Examples:
      | name      | sectionName |
      | GALLERY_1 | SECTION_1   |
