package com.brizy.io.web.interactions.element;

import com.microsoft.playwright.Locator;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class NumericInput {

    Locator locator;

    @SneakyThrows
    public void fill(Number value) {
        locator.fill(value.toString());
//        TODO - need to get the value somehow
//        await().alias("Wait for numeric input value to be applied")
//                .atLeast(MIN_TIME_OF_WAITING_FOR_NUMERIC_VALUE_TO_APPLY)
//                .and()
//                .atMost(MAX_TIME_OF_WAITING_FOR_NUMERIC_VALUE_TO_APPLY)
//                .pollInSameThread()
//                .pollInterval(POLL_DELAY_FOR_NUMERIC_VALUE_READ)
//                .until(() -> Integer.valueOf(getText()).equals(value));
    }

    public String getText() {
        return locator.getAttribute("value");
    }

}
