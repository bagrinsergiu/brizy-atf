Feature: Editor Page - Bottom Panel Elements
  As a user of Brizy application,
  I want to access and interact with the elements in the bottom panel of the editor page
  So that I can perform various actions and view additional information related to the editor content.

  Background: Navigate to editor
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_1' to page
    When prepare the following items to be added to the page:
      | item | position | parent | name  | sectionName |
      | MAP  | -        | -      | MAP_1 | SECTION_1   |
    And add the item to the page

  @Smoke @tmsLink=1 @Test
  Scenario: Verify Save Menu Items
    When get bottom panel save draft menu items
    Then validate that the following items are displayed on save draft menu:
      | name         | tooltip      | isEnabled |
      | Clear Layout | Clear Layout | true      |
      | Save Layout  | Save Layout  | true      |
      | Publish Page | Publish Page | true      |

  @Ignore
  Scenario: Verify Bottom Panel Elements
    When get bottom panel items
    Then validate that the following panel items are displayed:
      | name               | tooltip                | isEnabled |
      | ShowHiddenElements | Show Hidden Elements   | true      |
      | Undo               | Undo (ctrl+Z)          | false     |
      | Redo               | Redo (ctrl+shift+Z)    | false     |
      | Preview            | Preview (ctrl+shift+P) | false     |