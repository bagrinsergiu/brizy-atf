package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.counter.tabs;

import com.brizy.io.web.interactions.locators.AbstractLocator;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.common.InputWithPopulationLocators;
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
public class AdvancedCounterLocators extends AbstractLocator {

    String configurations;
    @NestedConfigurationProperty
    InputWithPopulationLocators prefix;
    @NestedConfigurationProperty
    InputWithPopulationLocators suffix;
    @NestedConfigurationProperty
    InputWithPopulationLocators separator;

}
