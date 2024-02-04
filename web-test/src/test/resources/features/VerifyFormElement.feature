Feature: Editor Page - Adding a Form Element
  As a user
  I want to add a Map element with different properties
  So that I can visualize it in preview

  Background: Add the form item to the page
    When navigate to home page
    And wait for editor page to load
    When clear the layout
    And open editor pop up
    When switch to 'Blocks' tab
    And add section 'SECTION_1' to page

  Scenario Outline: Add form element and validate select
    When prepare the following items to be added to the page:
      | item | position | sibling | name   | sectionName   |
      | FORM | -        | -      | <name> | <sectionName> |
    When prepare elements properties from the 'VerifyFormElement.json' file
    And add the item to the page
    And configure the item added to the page
    When save draft page
    And publish the page
    When get published items on section '<sectionName>'
    Then should have '1' item published
    When get published item of type '<name>'
    And get form select item by placeholder '<fieldToSearchFor>'
    Then should see the following select items:
      | SelectField |
      | MyOpt1      |
      | MyOpt2      |
      | MyOpt3      |

    Examples:
      | name   | sectionName | fieldToSearchFor |
      | FORM_1 | SECTION_1   | SelectField      |


  Scenario Outline: Add form element and validate <field>
    When prepare the following items to be added to the page:
      | item | position | sibling | name   | sectionName   |
      | FORM | -        | -      | <name> | <sectionName> |
    When prepare elements properties from the 'VerifyFormElement.json' file
    And add the item to the page
    And configure the item added to the page
    When save draft page
    And publish the page
    When get published items on section '<sectionName>'
    Then should have '1' item published
    When get published item of type '<name>'
    And get form <field> item by placeholder '<fieldToSearchFor>'
    When should see the following radio items:
      | MyRadOpt1  |
      | MyRadOpt2  |
      | MyRadOpt3  |
      | MyRadOpt4  |
      | MyRadOpt5  |
      | MyRadOpt6  |
      | MyRadOpt7  |
      | MyRadOpt8  |
      | MyRadOpt9  |
      | MyRadOpt10 |

    Examples:
      | name   | sectionName | fieldToSearchFor | field |
      | FORM_1 | SECTION_1   | RadioField       | radio |

  Scenario Outline: Add form element and validate <field>
    When prepare the following items to be added to the page:
      | item | position | sibling | name   | sectionName   |
      | FORM | -        | -      | <name> | <sectionName> |
    When prepare elements properties from the 'VerifyFormElement.json' file
    And add the item to the page
    And configure the item added to the page
    When save draft page
    And publish the page
    When get published items on section '<sectionName>'
    Then should have '1' item published
    When get published item of type '<name>'
    And get form <field> item by placeholder '<fieldToSearchFor>'
    When should see the following check box items:
      | MyCbxOpt1  |
      | MyCbxOpt2  |
      | MyCbxOpt3  |
      | MyCbxOpt4  |
      | MyCbxOpt5  |
      | MyCbxOpt6  |
      | MyCbxOpt7  |
      | MyCbxOpt8  |
      | MyCbxOpt9  |
      | MyCbxOpt10 |

    Examples:
      | name   | sectionName | fieldToSearchFor | field    |
      | FORM_1 | SECTION_1   | CheckboxField    | checkbox |

  Scenario Outline: Add form element and validate <field>
    When prepare the following items to be added to the page:
      | item | position | sibling | name   | sectionName   |
      | FORM | -        | -      | <name> | <sectionName> |
    When prepare elements properties from the 'VerifyFormElement.json' file
    And add the item to the page
    And configure the item added to the page
    When save draft page
    And publish the page
    When get published items on section '<sectionName>'
    Then should have '1' item published
    When get published item of type '<name>'
    And get form <field> item by placeholder '<fieldToSearchFor>'
    When fill text form field with content 'randomSentence'
    And get the content of the form text field
    Then validate form field content

    Examples:
      | name   | sectionName | fieldToSearchFor | field |
      | FORM_1 | SECTION_1   | TextField        | text  |

  Scenario Outline: Add form element and validate <field>
    When prepare the following items to be added to the page:
      | item | position | sibling | name   | sectionName   |
      | FORM | -        | -      | <name> | <sectionName> |
    When prepare elements properties from the 'VerifyFormElement.json' file
    And add the item to the page
    And configure the item added to the page
    When save draft page
    And publish the page
    When get published items on section '<sectionName>'
    Then should have '1' item published
    When get published item of type '<name>'
    And get form <field> item by placeholder '<fieldToSearchFor>'
    When fill email form field with content 'randomEmail'
    And get the content of the form email field
    Then validate form field content

    Examples:
      | name   | sectionName | fieldToSearchFor | field |
      | FORM_1 | SECTION_1   | EmailField       | email |

  Scenario Outline: Add form element and validate <field>
    When prepare the following items to be added to the page:
      | item | position | sibling | name   | sectionName   |
      | FORM | -        | -      | <name> | <sectionName> |
    When prepare elements properties from the 'VerifyFormElement.json' file
    And add the item to the page
    And configure the item added to the page
    When save draft page
    And publish the page
    When get published items on section '<sectionName>'
    Then should have '1' item published
    When get published item of type '<name>'
    And get form <field> item by placeholder '<fieldToSearchFor>'
    When fill number form field with value '4'
    And get the value of the form number field
    Then validate form number field content

    Examples:
      | name   | sectionName | fieldToSearchFor | field  |
      | FORM_1 | SECTION_1   | NumberField      | number |

  Scenario Outline: Add form element and validate <field>
    When prepare the following items to be added to the page:
      | item | position | sibling | name   | sectionName   |
      | FORM | -        | -      | <name> | <sectionName> |
    When prepare elements properties from the 'VerifyFormElement.json' file
    And add the item to the page
    And configure the item added to the page
    When save draft page
    And publish the page
    When get published items on section '<sectionName>'
    Then should have '1' item published
    When get published item of type '<name>'
    And get form <field> item by placeholder '<fieldToSearchFor>'
    When fill date form field with content '2023-10-10'
    And get the content of the form date field
    Then validate form field content

    Examples:
      | name   | sectionName | fieldToSearchFor | field |
      | FORM_1 | SECTION_1   | DateField        | date  |


