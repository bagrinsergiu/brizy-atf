Feature: Editor Page - Adding a Multiple Sections
  As a user
  I want to customize a web page with multiple sections
  So that I can structure the content

  Scenario: Add multiple sections on the page
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_1' to page
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_2' to page
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_3' to page
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_4' to page
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_5' to page
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_6' to page
    When prepare the following items to be added to the page:
      | item   | position | sibling  | name     | sectionName |
      | TEXT   | -        | -        | TEXT_1   | SECTION_1   |
      | BUTTON | UP       | TEXT_1   | BUTTON_2 | SECTION_1   |
      | MAP    | DOWN     | BUTTON_2 | MAP_2    | SECTION_1   |
      | ICON   | UP       | MAP_2    | ICON_2   | SECTION_1   |
      | IMAGE  | DOWN     | ICON_2   | IMAGE_2  | SECTION_1   |
      | FORM   | UP       | IMAGE_2  | FORM_2   | SECTION_1   |
      | TEXT   | -        | -        | TEXT_1   | SECTION_2   |
      | BUTTON | DOWN     | TEXT_1   | BUTTON_2 | SECTION_2   |
      | MAP    | UP       | BUTTON_2 | MAP_2    | SECTION_2   |
      | ICON   | DOWN     | MAP_2    | ICON_2   | SECTION_2   |
      | IMAGE  | UP       | ICON_2   | IMAGE_2  | SECTION_2   |
      | FORM   | DOWN     | IMAGE_2  | FORM_2   | SECTION_2   |
      | TEXT   | -        | -        | TEXT_1   | SECTION_3   |
      | BUTTON | UP       | TEXT_1   | BUTTON_2 | SECTION_3   |
      | MAP    | DOWN     | BUTTON_2 | MAP_2    | SECTION_3   |
      | ICON   | UP       | MAP_2    | ICON_2   | SECTION_3   |
      | IMAGE  | DOWN     | ICON_2   | IMAGE_2  | SECTION_3   |
      | FORM   | UP       | IMAGE_2  | FORM_2   | SECTION_3   |
      | TEXT   | -        | -        | TEXT_1   | SECTION_4   |
      | BUTTON | DOWN     | TEXT_1   | BUTTON_2 | SECTION_4   |
      | MAP    | UP       | BUTTON_2 | MAP_2    | SECTION_4   |
      | ICON   | DOWN     | MAP_2    | ICON_2   | SECTION_4   |
      | IMAGE  | UP       | ICON_2   | IMAGE_2  | SECTION_4   |
      | FORM   | DOWN     | IMAGE_2  | FORM_2   | SECTION_4   |
      | TEXT   | -        | -        | TEXT_1   | SECTION_5   |
      | BUTTON | UP       | TEXT_1   | BUTTON_2 | SECTION_5   |
      | MAP    | DOWN     | BUTTON_2 | MAP_2    | SECTION_5   |
      | ICON   | UP       | MAP_2    | ICON_2   | SECTION_5   |
      | IMAGE  | DOWN     | ICON_2   | IMAGE_2  | SECTION_5   |
      | FORM   | UP       | IMAGE_2  | FORM_2   | SECTION_5   |
      | TEXT   | -        | -        | TEXT_1   | SECTION_6   |
      | BUTTON | DOWN     | TEXT_1   | BUTTON_2 | SECTION_6   |
      | MAP    | UP       | BUTTON_2 | MAP_2    | SECTION_6   |
      | ICON   | DOWN     | MAP_2    | ICON_2   | SECTION_6   |
      | IMAGE  | UP       | ICON_2   | IMAGE_2  | SECTION_6   |
      | FORM   | DOWN     | IMAGE_2  | FORM_2   | SECTION_6   |
    And add the item to the page
    When save draft page
    And publish the page
    When get published items on section 'SECTION_1'
    Then should have '6' item published
    When get published items on section 'SECTION_2'
    Then should have '6' item published
    When get published items on section 'SECTION_3'
    Then should have '6' item published
    When get published items on section 'SECTION_4'
    Then should have '6' item published
    When get published items on section 'SECTION_5'
    Then should have '6' item published
    When get published items on section 'SECTION_6'
    Then should have '6' item published
