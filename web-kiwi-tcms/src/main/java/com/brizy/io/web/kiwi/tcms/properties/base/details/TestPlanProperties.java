package com.brizy.io.web.kiwi.tcms.properties.base.details;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class TestPlanProperties {

    String name;
    String product;
    String version;
    Long type;
    String referenceLink;
    String text;
    Boolean notifyAuthor;
    Boolean notifyTestCaseAuthor;
    Boolean notifyDefaultTester;
    Boolean notifyWhenTestPlanIsUpdated;
    Boolean notifyWhenTestCaseAreUpdated;

}
