package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.styling.basic.positionGroup.position;

import com.brizy.io.web.interactions.locators.AbstractProperty;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.common.InputWithUnitsLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.common.RadioGroupLocators;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@EqualsAndHashCode(callSuper = false)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class PositionLocators extends AbstractProperty {

    String item;
    @NestedConfigurationProperty
    InputWithUnitsLocators width;
    @NestedConfigurationProperty
    RadioGroupLocators horizontalOffset;
    @NestedConfigurationProperty
    InputWithUnitsLocators horizontalOffsetValue;
    @NestedConfigurationProperty
    RadioGroupLocators verticalOffset;
    @NestedConfigurationProperty
    InputWithUnitsLocators verticalOffsetValue;

}
