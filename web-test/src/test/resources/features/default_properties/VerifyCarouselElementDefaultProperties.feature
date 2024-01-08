Feature: Editor Page - Adding a Carousel Element
  As a user
  I want to add a carousel element
  So that I can see some default properties

  Background:
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_1' to page
    When prepare the following items to be added to the page:
      | item     | position | parent | name       | sectionName |
      | CAROUSEL | -        | -      | CAROUSEL_1 | SECTION_1   |

  Scenario Outline: Add carousel element and validate default properties
    When prepare elements properties from the 'VerifyCarouselElement.json' file
    And add the item to the page
#    And configure the item added to the page
#    When get editor properties for the '<name>' item from the section '<sectionName>'
#    Then validate default properties of the item '<name>'

    Examples:
      | name       | sectionName |
      | CAROUSEL_1 | SECTION_1   |
