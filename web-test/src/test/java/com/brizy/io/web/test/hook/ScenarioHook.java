package com.brizy.io.web.test.hook;

import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.storage.Storage;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class ScenarioHook {

    Storage storage;

    @Before(order = -60)
    public void doGetScenario(Scenario scenario) {
        storage.addValue(StorageKey.CURRENT_SCENARIO, scenario);
    }

}
