Feature: CMS Page
  As a user I want to have a dedicated CMS PopUp
  In order to create new pages, new posts, new pop-up's, new users

  Background:
    When navigate to home page
    And wait for editor page to load

  Scenario Outline: Create a new page in CMS
    When open CMS pop up
    And open CMS 'Assets' tab
    And open 'Pages' assets menu item
    When click on Add New Page button
    And add the following details for the new page:
      | Item | Title               | Slug | Description       | Published |
      | page | testPage@timestamp@ |      | Short description | Published |
    When click on 'Save Changes' button
    And click on 'Back' button
    When get the content of the pages table
    Then the created page must be in the list

    Examples:
      | name      | published | link      | actions               |
      | testPage1 | published | testpage1 | edit,duplicate,delete |

  Scenario Outline: Create a new post in CMS
    When open CMS pop up
    And open CMS assets tab
    And click on Posts
    When click on 'Add new Post'
    And add the following details to the post:
      | item | title     | slug | featuredImage | excerpt               | published |
      | post | testPost1 |      | testimage.jpg | Post short descrition | published |
    When click Save Changes button
    And click on All posts
    Then the created post must be in the list
    Examples:
      | name      | published | link      | actions               |
      | testPost1 | published | testPost1 | edit,duplicate,delete |

  Scenario Outline: Create a new story in CMS
    When open CMS pop up
    And open CMS assets tab
    And click on Stories
    When click on 'Add New Story'
    And add the following details to the story
      | item  | title      | slug | description             | published |
      | story | testStory1 |      | Story short description | published |
    When click on Save Changes button
    And click on Stories
    Then the created story must be in the list
    Examples:
      | name       | link       | published | Actions                 |
      | testStory1 | teststory1 | published | edit, duplicate, delete |

  Scenario Outline: Create a new Popup in CMS
    When open CMS pop up
    And open CMS assets tab
    And click on Popups & Alerts
    When click on 'Add New Popup'
    And add the following details to the popup
      | item  | title      | published |
      | popup | TestPopup1 | published |
    When click on Save Changes button
    And click on Popups & Alerts
    Then created popup must be in the list
    Examples:
      | name       | published | date | type   | actions               |
      | TestPopup1 | published |      | Pop-up | edit,duplicate,delete |

  Scenario Outline: Create a new User in CMS
    When open CMS pop up
    And open CMS assets tab
    And click on Users
    When click on 'Add new User'
    And add the following details to the user:
      | item | firstName     | lastName     | username | email             | roles | phoneNumber |
      | user | FirstTestName | LastTestName | usertest | test@somemail.com |       | +3736666666 |
    When click on Add User button
    And click on All users
    Then the created user must be in the list
    Examples:
      | item | name                       | published | email             | actions      |
      | user | FirstTestName LastTestName | published | test@somemail.com | edit, delete |