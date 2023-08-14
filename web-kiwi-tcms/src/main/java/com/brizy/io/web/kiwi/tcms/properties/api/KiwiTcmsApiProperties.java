package com.brizy.io.web.kiwi.tcms.properties.api;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@ConfigurationProperties
public class KiwiTcmsApiProperties {

    @NestedConfigurationProperty
    AuthenticationApiProperties auth;
    @NestedConfigurationProperty
    AbstractProperty classification;
    @NestedConfigurationProperty
    AbstractProperty product;
    @NestedConfigurationProperty
    AbstractProperty version;
    @NestedConfigurationProperty
    TestPlanApiProperties testPlan;
    @NestedConfigurationProperty
    TestRunApiProperties testRun;
    @NestedConfigurationProperty
    TestCaseApiProperties testCase;
    @NestedConfigurationProperty
    TestExecutionApiProperties testExecution;
    @NestedConfigurationProperty
    AbstractProperty build;

}
