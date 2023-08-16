package com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.styling.advanced;

import com.brizy.io.web.interactions.properties.AbstractProperty;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.common.InputLocators;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.common.InputWithPopulationLocators;
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
public class AdvancedStylingLocators extends AbstractProperty {

    String showOnDesktop;
    String zIndex;
    @NestedConfigurationProperty
    InputWithPopulationLocators cssId;
    @NestedConfigurationProperty
    InputWithPopulationLocators cssClass;
    @NestedConfigurationProperty
    InputWithPopulationLocators customAttribute;
    @NestedConfigurationProperty
    InputLocators customCss;
    String hoverTransition;

}
