package com.brizy.io.web.test.listener;

import com.brizy.io.web.test.constants.TestRunDetails;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
import java.util.Map;

import static com.brizy.io.web.test.constants.TestRunDetails.testRunDetails;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TestEventsListener implements ConcurrentEventListener {

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseStarted.class, this::onTestCaseStarted);
    }

    private void onTestCaseStarted(TestCaseStarted testCaseStarted) {
        testRunDetails.put(TestPhase.TEST_CASE_STARTED, testCaseStarted);
    }

}