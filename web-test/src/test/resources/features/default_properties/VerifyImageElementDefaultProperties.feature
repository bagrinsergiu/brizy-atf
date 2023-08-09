Feature: Editor Page - Image Default Settings
  As a user
  I want to customize an image element
  So I need to have a toolbar with different configurations for it

  Scenario Outline: Add image element and validate items inside image popup
    When navigate to home page
    And open dashboard page
    When select 'Project #1' from projects list
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section '<sectionName>' to page
    When prepare the following items to be added to the page:
      | item  | position | parent | name   | sectionName   |
      | IMAGE | -        | -      | <name> | <sectionName> |
    And add the item to the page
    When get available configurations in the tab '<tabToOpen>' of '<toolbarItem>' toolbar item of the '<name>' item from section '<sectionName>'
    Then the following configurations should be displayed: <displayedConfigurations>

    Examples:
      | tabToOpen | toolbarItem | name    | sectionName | displayedConfigurations       |
      | Image     | Image       | IMAGE_1 | SECTION_1   | Image, Zoom, Open in Lightbox |
      | Mask      | Image       | IMAGE_1 | SECTION_1   | Shape                         |

