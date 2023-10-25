Feature: Editor Page - Adding multiple sections with elements
  As a user
  I want to add a button element and set anchor link
  So that I can see scroll action in preview
@Test
  Scenario: Add sections and elements with anchor link
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_1' to page
    When prepare the following items to be added to the page:
      | item   | position | parent   | name     | sectionName |
      | BUTTON | -        | -        | BUTTON_1 | SECTION_1   |
      | MAP    | UP       | BUTTON_1 | MAP_1    | SECTION_1   |
    And add the item to the page
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_2' to page
    When prepare the following items to be added to the page:
      | item  | position | parent | name    | sectionName |
      | IMAGE | -        | -      | IMAGE_1 | SECTION_2   |
    And add the item to the page
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_3' to page
    When prepare the following items to be added to the page:
      | item  | position | parent | name    | sectionName |
      | IMAGE | -        | -      | IMAGE_1 | SECTION_3   |
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_4' to page
    When prepare the following items to be added to the page:
      | item | position | parent | name   | sectionName |
      | TEXT | -        | -      | TEXT_1 | SECTION_4   |
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_5' to page
    When prepare the following items to be added to the page:
      | item   | position | parent   | name     | sectionName |
      | BUTTON | -        | -        | BUTTON_1 | SECTION_5   |
      | BUTTON | DOWN     | BUTTON_1 | BUTTON_2 | SECTION_5   |
    When prepare elements properties from the 'VerifyAnchorLinkScroll.json' file
    And add the item to the page
    And configure the item added to the page
    When save draft page
    And publish the page
    When get published items on section 'SECTION_5'
    Then should have '2' item published
