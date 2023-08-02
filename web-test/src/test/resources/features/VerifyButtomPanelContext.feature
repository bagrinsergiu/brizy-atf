Feature: Editor Page - Verify Bottom Panel Context
  As a user
  I want to verify fixed bottom panel context
  (show hidden elements, undo, redo, preview, publish page, save to draft),
  arrow-up button (Clear Layout, Save Layout, Publish or Switch to Draft)
  So that I can visualize it in preview

  Scenario Outline: In editor page validate bottom panel default properties
    When navigate to home page
    And open dashboard page
    When select 'Project #1' from projects list
    And wait for editor page to load
    Then validate brz-ed-fixed-bottom-panel context:
      | button                 | ico                     | isActive | tooltip                | hover-color |
      | Show Hidden Elements   | icons.svg#nc-eye-ban-18 | true     | Show Hidden Elements   | #3dbfe8     |
      | Undo (ctrl+Z)          | icons.svg#nc-undo       | false    | Undo (ctrl+Z)          | false       |
      | Redo (ctrl+shift+Z)    | icons.svg#nc-redo       | false    | Redo (ctrl+shift+Z)    | false       |
      | Preview (ctrl+shift+P) | icons.svg#nc-preview    | true     | Preview (ctrl+shift+P) | #3dbfe8     |
      | Save Draft             | false                   | false    | false                  | false       |
      | Arrow-up               | icons.svg#nc-arrow-up   | false    | false                  | #fff        |

    When click on arrow-up button
    Then validate arrow-up context
      | item         | ico                       | tooltip      | hover-color |
      | Clear Layout | icons.svg#nc-trash        | Clear Layout | #3dbfe8     |
      | Save Layout  | icons.svg#nc-save-section | Save Layout  | #3dbfe8     |
      | Publish Page | icons.svg#nc-publish      | Publish Page | #3dbfe8     |
