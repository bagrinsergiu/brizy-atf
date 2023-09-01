package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.image.mask.size;

import com.brizy.io.web.common.dto.element.properties.image.image.mask.size.FillUnits;
import com.brizy.io.web.common.dto.element.properties.image.image.mask.size.ToFill;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.element.RangeInput;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.image.tabs.mask.size.SizeProperties;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SizeInput {

    Supplier<ComboBox> sizeUnit;
    Supplier<RangeInput> sizeValue;

    public SizeInput(SizeProperties size, Frame frame) {
        this.sizeUnit = () -> new ComboBox(frame.locator(size.getUnit()));
        this.sizeValue = () -> new RangeInput(frame.locator(size.getValue()));
    }

    public void setValue(ToFill sizeToFill) {
        if (Objects.nonNull(sizeToFill.getUnit())) {
            sizeUnit.get().selectItemByName(sizeToFill.getUnit().getValue());
        }
        if (Objects.nonNull(sizeToFill.getValue())) {
            sizeValue.get().fill(sizeToFill.getValue());
        }
    }

    public List<Configuration> getConfigurations() {
        return new ArrayList<>() {{
            add(Configuration.builder().name(Fields.sizeUnit).element(sizeUnit).build());
            add(Configuration.builder().name(Fields.sizeValue).element(sizeValue).build());
        }};
    }

    public ToFill getValue() {
        return ToFill.builder()
                .value(sizeValue.get().getValue())
                .unit(sizeUnit.get().getSelectedItem().equalsIgnoreCase("%") ? FillUnits.PERCENT : FillUnits.PX)
                .build();
    }
}
