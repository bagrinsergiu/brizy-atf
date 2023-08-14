package com.brizy.io.web.interactions.element;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import static com.brizy.io.web.interactions.constants.TimingConstants.*;
import static lombok.AccessLevel.PRIVATE;
import static org.awaitility.Awaitility.await;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class RangeInput {

    Locator locator;

    public void fill(Integer integer) {
        ElementHandle elementHandle = locator.elementHandle();
        elementHandle.fill(integer.toString());
        await().alias("Wait for numeric input value to be applied")
                .atLeast(MIN_TIME_OF_WAITING_FOR_NUMERIC_VALUE_TO_APPLY)
                .and()
                .atMost(MAX_TIME_OF_WAITING_FOR_NUMERIC_VALUE_TO_APPLY)
                .pollInSameThread()
                .pollInterval(POLL_DELAY_FOR_NUMERIC_VALUE_READ)
                .until(() -> Integer.valueOf(locator.getAttribute("value")).equals(integer));
    }

    public Integer getValue() {
        return Integer.valueOf(locator.inputValue());
    }

}
