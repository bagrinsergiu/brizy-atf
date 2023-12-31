@Smoke
Feature: Editor Page - Image Toolbar
  As a user
  I want to customize an image element
  So I need to have a toolbar with different configurations for it

  Background: Navigate to project and create a new one
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_1' to page

  Scenario Outline: Add image element and validate toolbar items
    When prepare the following items to be added to the page:
      | item  | position | parent | name   | sectionName   |
      | IMAGE | -        | -      | <name> | <sectionName> |
    And add the item to the page
    When get the toolbar items for '<name>' item from section '<sectionName>'
    Then the following toolbar items should be displayed:
      | Image     |
      | Colors    |
      | Link      |
      | Align     |
      | Settings  |
      | Duplicate |
      | Delete    |

    Examples:
      | name    | sectionName |
      | IMAGE_1 | SECTION_1   |

  Scenario Outline: Add image element and validate toolbar <toolbarItem> item tabs
    When prepare the following items to be added to the page:
      | item  | position | parent | name   | sectionName   |
      | IMAGE | -        | -      | <name> | <sectionName> |
    And add the item to the page
    When get tabs list from '<toolbarItem>' toolbar item for '<name>' item from section '<sectionName>'
    Then the following tabs should be displayed in the opened popup: <displayedTabs>

    Examples:
      | toolbarItem | name    | sectionName | displayedTabs           |
      | Image       | IMAGE_1 | SECTION_1   | Image, Filters, Mask    |
      | Colors      | IMAGE_1 | SECTION_1   | Overlay, Border, Shadow |
