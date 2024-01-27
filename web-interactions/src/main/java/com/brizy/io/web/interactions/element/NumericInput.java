package com.brizy.io.web.interactions.element;

import com.microsoft.playwright.Locator;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;

import static com.brizy.io.web.interactions.constants.TimingConstants.*;
import static lombok.AccessLevel.PRIVATE;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.awaitility.Awaitility.await;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class NumericInput extends AbstractElement implements Input {

    public NumericInput(Locator locator) {
        super(locator);
    }

    @SneakyThrows
    public void fill(Number value) {
        locator.fill(value.toString(), new Locator.FillOptions().setForce(true));
        locator.dispatchEvent("input");
        locator.dispatchEvent("change");
    }

    public void fillAndWaitForValue(Number value) {
        fill(value);
        await().alias("Wait for numeric input value to be applied")
                .atLeast(MIN_TIME_OF_WAITING_FOR_NUMERIC_VALUE_TO_APPLY)
                .and()
                .atMost(MAX_TIME_OF_WAITING_FOR_NUMERIC_VALUE_TO_APPLY)
                .pollInSameThread()
                .pollInterval(POLL_DELAY_FOR_NUMERIC_VALUE_READ)
                .until(() -> getRawValue().equals(value.toString()));
    }

    public <T> T getRange(Class<T> clazz, String rangeType) {
        return castValue(clazz, locator.getAttribute(rangeType));
    }

    public String getMaxValue() {
        return locator.getAttribute("max");
    }

    public String getText() {
        if (!isVisible()) {
            return null;
        }
        return locator.getAttribute("value");
    }

    private <T> T castValue(Class<T> clazz, String valueToParse) {
        if (clazz.equals(Integer.class)) {
            return clazz.cast(Integer.valueOf(valueToParse));
        }
        if (clazz.equals(Double.class)) {
            return clazz.cast(Double.valueOf(valueToParse));
        }
        return clazz.cast(Long.valueOf(valueToParse));
    }

    public <T> T getValue(Class<T> clazz) {
        String valueToParse = getText().replaceAll(",", EMPTY)
                .replaceAll("%", EMPTY);
        return castValue(clazz, valueToParse);
    }

    @Override
    public String getRawValue() {
        return locator.getAttribute("value");
    }

}
