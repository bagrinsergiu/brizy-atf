package com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.scrollbar.styling.tabs.basic.position;

import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.basic.position.PositionProperties;
import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.basic.position.types.AbsoluteOrFixedPositionProperties;
import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.basic.position.types.NonePositionProperties;
import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.basic.position.types.any.OffsetProperties;
import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.enums.HorizontalOffsetTypes;
import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.enums.VerticalOffsetTypes;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.element.composite.InputWithUnits;
import com.brizy.io.web.interactions.element.composite.RadioControl;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.styling.basic.positionGroup.PositionGroupLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.styling.basic.positionGroup.position.PositionLocators;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PositionSettings {

    Supplier<ComboBox> positions;
    Supplier<InputWithUnits> width;
    Supplier<RadioControl<HorizontalOffsetTypes>> horizontalOffset;
    Supplier<InputWithUnits> horizontalOffsetValue;
    Supplier<RadioControl<VerticalOffsetTypes>> verticalOffset;
    Supplier<InputWithUnits> verticalOffsetValue;

    public PositionSettings(PositionGroupLocators positionGroupLocators, Page frame) {
        PositionLocators positionLocators = positionGroupLocators.getPosition();
        this.positions = () -> new ComboBox(frame.locator(positionLocators.getSelf()));
        this.width = () -> new InputWithUnits(positionLocators.getWidth(), frame);
        this.horizontalOffset = () -> new RadioControl<>(HorizontalOffsetTypes.class, positionLocators.getHorizontalOffset().getItems(), frame);
        this.horizontalOffsetValue = () -> new InputWithUnits(positionLocators.getHorizontalOffsetValue(), frame);
        this.verticalOffset = () -> new RadioControl<>(VerticalOffsetTypes.class, positionLocators.getVerticalOffset().getItems(), frame);
        this.verticalOffsetValue = () -> new InputWithUnits(positionLocators.getVerticalOffsetValue(), frame);
    }

    public void applyProperties(PositionProperties position) {
        if (position instanceof AbsoluteOrFixedPositionProperties absoluteOrFixedPositionProperties) {
            if (Objects.nonNull(absoluteOrFixedPositionProperties.getWidth())) {
                positions.get().selectItemByValue(absoluteOrFixedPositionProperties.getValue());
                width.get().setValue(absoluteOrFixedPositionProperties.getWidth());
            }
            OffsetProperties verticalOffsetToSet = absoluteOrFixedPositionProperties.getVerticalOffset();
            if (Objects.nonNull(verticalOffsetToSet)) {
                if (Objects.nonNull(verticalOffsetToSet.getDirection())) {
                    verticalOffset.get().set(VerticalOffsetTypes.valueOf(verticalOffsetToSet.getDirection().toUpperCase()));
                }
                if (Objects.nonNull(verticalOffsetToSet.getOffset())) {
                    verticalOffsetValue.get().setValue(verticalOffsetToSet.getOffset());
                }
            }
            OffsetProperties horizontalOffsetToSet = absoluteOrFixedPositionProperties.getHorizontalOffset();
            if (Objects.nonNull(horizontalOffsetToSet)) {
                if (Objects.nonNull(horizontalOffsetToSet.getDirection())) {
                    horizontalOffset.get().set(HorizontalOffsetTypes.valueOf(horizontalOffsetToSet.getDirection().toUpperCase()));
                }
                if (Objects.nonNull(horizontalOffsetToSet.getOffset())) {
                    horizontalOffsetValue.get().setValue(horizontalOffsetToSet.getOffset());
                }
            }
        }
    }

    public PositionProperties getProperties() {
        String selectedItem = positions.get().getSelectedItem();
        if (selectedItem.equals("None")) {
            return NonePositionProperties.builder().value(selectedItem).build();
        } else {
            return AbsoluteOrFixedPositionProperties.builder()
                    .horizontalOffset(OffsetProperties.builder()
                            .direction(horizontalOffset.get().getActiveControl().getValue())
                            .offset(horizontalOffsetValue.get().getValue())
                            .build())
                    .value(selectedItem)
                    .verticalOffset(OffsetProperties.builder()
                            .direction(verticalOffset.get().getActiveControl().getValue())
                            .offset(verticalOffsetValue.get().getValue())
                            .build())
                    .width(width.get().getValue())
                    .build();
        }
    }
}
