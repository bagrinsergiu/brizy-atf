package com.brizy.io.web.interactions.element;

import com.microsoft.playwright.Locator;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;

import static com.brizy.io.web.interactions.constants.TimingConstants.*;
import static lombok.AccessLevel.PRIVATE;
import static org.awaitility.Awaitility.await;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class NumericInput extends AbstractElement {

    public NumericInput(Locator locator) {
        super(locator);
    }

    @SneakyThrows
    public void fill(Number value) {
        locator.fill(value.toString(), new Locator.FillOptions().setForce(true));
//        TODO - need to get the value somehow
//        await().alias("Wait for numeric input value to be applied")
//                .atLeast(MIN_TIME_OF_WAITING_FOR_NUMERIC_VALUE_TO_APPLY)
//                .and()
//                .atMost(MAX_TIME_OF_WAITING_FOR_NUMERIC_VALUE_TO_APPLY)
//                .pollInSameThread()
//                .pollInterval(POLL_DELAY_FOR_NUMERIC_VALUE_READ)
//                .until(() -> Integer.valueOf(getText()).equals(value));
    }

    public void fillAndWaitForValue(Number value) {
        fill(value);
        await().alias("Wait for numeric input value to be applied")
                .atLeast(MIN_TIME_OF_WAITING_FOR_NUMERIC_VALUE_TO_APPLY)
                .and()
                .atMost(MAX_TIME_OF_WAITING_FOR_NUMERIC_VALUE_TO_APPLY)
                .pollInSameThread()
                .pollInterval(POLL_DELAY_FOR_NUMERIC_VALUE_READ)
                .until(() -> getValue().equals(value.toString()));
    }

    public String getText() {
        if (!isVisible()) {
            return null;
        }
        return locator.getAttribute("value");
    }

    public String getValue() {
        return locator.getAttribute("value");
    }

}
