package com.brizy.io.web.test.hook;

import com.brizy.io.web.test.service.KiwiTcmsService;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

import java.time.Duration;
import java.time.LocalDateTime;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class KiwiTcmsHooks {

    KiwiTcmsService kiwiTcmsService;
    @NonFinal
    Long testCaseId;
    @NonFinal
    Long testExecutionId;
    @NonFinal
    LocalDateTime startTime;

    @Before(order = -200)
    public void doCreateTestCase() {
        testCaseId = kiwiTcmsService.createTestCase();
        startTime = LocalDateTime.now();
    }

    @Before(order = -190)
    public void doAttachTestCaseToTestPlan() {
        kiwiTcmsService.attachTestCastToTestPlan(testCaseId);
    }

    @Before(order = -180)
    public void doAttachTestCaseToTestRun() {
        testExecutionId = kiwiTcmsService.attachTestCastToTestRun(testCaseId);
    }

    @After(order = 200)
    public void doUpdateTestExecution(Scenario scenario) {
        kiwiTcmsService.updateTestExecutionDetails(testExecutionId, scenario);
    }

    @After(order = 190)
    public void doUpdateTestCase(Scenario scenario) {
        kiwiTcmsService.updateTestCaseDuration(testCaseId, Duration.between(startTime, LocalDateTime.now()));
    }

}
