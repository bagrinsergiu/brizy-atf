package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.counter.tabs;

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
public class CounterLocators extends AbstractProperty {

    String configurations;
    String style;
    @NestedConfigurationProperty
    InputWithPopulationLocators start;
    @NestedConfigurationProperty
    InputWithPopulationLocators end;
    String duration;

}
