package com.brizy.io.web.test.listener;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestCaseStarted;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

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