package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.counter.tabs;

import com.brizy.io.web.common.dto.element.properties.common.InputWithPopulationProperties;
import com.brizy.io.web.interactions.locators.AbstractProperty;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.common.InputWithPopulationLocators;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.boot.context.properties.bind.Nested;

@EqualsAndHashCode(callSuper = false)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class AdvancedCounterLocators extends AbstractProperty {

    String configurations;
    @NestedConfigurationProperty
    InputWithPopulationLocators prefix;
    @NestedConfigurationProperty
    InputWithPopulationLocators suffix;
    @NestedConfigurationProperty
    InputWithPopulationLocators separator;

}
