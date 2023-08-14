package com.brizy.io.web.kiwi.tcms.properties.base.details;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class TestCaseProperties {

    Long defaultTester;
    String product;
    Long status;
    Long priority;
    Long manager;
    Boolean notifyAuthor;
    Boolean notifyManagerOfRuns;
    Boolean notifyAssignees;
    Boolean notifyDefaultTester;
    Boolean notifyTesterOfRuns;
    Boolean notifyWhenTestCaseIsUpdated;
    Boolean notifyWhenTestCaseIsDeleted;

}
