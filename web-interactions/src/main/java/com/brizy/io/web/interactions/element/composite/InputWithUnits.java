package com.brizy.io.web.interactions.element.composite;

import com.brizy.io.web.common.dto.element.properties.common.settings.UnitType;
import com.brizy.io.web.common.dto.element.properties.elements.InputWithUnitsProperties;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.element.NumericInput;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.common.InputWithUnitsLocators;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Page;
import io.vavr.control.Try;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.Range;

import java.util.Objects;
import java.util.function.Supplier;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class InputWithUnits {

    Supplier<NumericInput> value;
    Supplier<ComboBox> unit;

    public InputWithUnits(InputWithUnitsLocators locators, Frame frame) {
        this.value = () -> new NumericInput(frame.locator(locators.getValue()));
        this.unit = () -> new ComboBox(frame.locator(locators.getUnit()));
    }

    public InputWithUnits(InputWithUnitsLocators locators, Page page) {
        this.value = () -> new NumericInput(page.locator(locators.getValue()));
        this.unit = () -> new ComboBox(page.locator(locators.getUnit()));
    }

    public InputWithUnitsProperties getValue() {
        return InputWithUnitsProperties.builder()
                .unit(UnitType.getByValue(unit.get().getSelectedItem()))
                .value(getReturnedValue())
                .build();
    }

    public void setValue(InputWithUnitsProperties properties) {
        if (Objects.nonNull(properties.getUnit())) {
            unit.get().selectItemByValue(properties.getUnit().getValue());
        }
        if (Objects.nonNull(properties.getValue())) {
            value.get().fillAndWaitForValue(properties.getValue());
        }
    }

    private Number getReturnedValue() {
        return Try.of(() -> Integer.parseInt(value.get().getText()))
                .map(value -> ((Number) value))
                .getOrElse(() -> Double.parseDouble(value.get().getText()));
    }

    public Range<Integer> getValueRange() {
        return Range.between(value.get().getRange(Integer.class, "min"), value.get().getRange(Integer.class, "max"));
    }

}
