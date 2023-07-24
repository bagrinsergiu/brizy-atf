package com.brizy.io.web.kiwi.tcms.properties.base.details;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class KiwiTcmsDetailsProperties {

    @NestedConfigurationProperty
    ManagerProperties manager;
    @NestedConfigurationProperty
    ClassificationProperties classification;
    @NestedConfigurationProperty
    ProductProperties product;
    @NestedConfigurationProperty
    VersionProperties version;
    @NestedConfigurationProperty
    BuildProperties build;
    @NestedConfigurationProperty
    TestPlanProperties testPlan;
    @NestedConfigurationProperty
    TestCaseProperties testCase;
    @NestedConfigurationProperty
    TestRunProperties testRun;

}
