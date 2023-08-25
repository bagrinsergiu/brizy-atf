package com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.styling.basic;

import com.brizy.io.web.interactions.properties.AbstractProperty;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.styling.basic.margin.MarginLocators;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.styling.basic.padding.PaddingLocators;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.styling.basic.positionGroup.PositionGroupLocators;
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
public class BasicStylingLocators extends AbstractProperty {

    String tab;
    @NestedConfigurationProperty
    PaddingLocators padding;
    @NestedConfigurationProperty
    MarginLocators margin;
    @NestedConfigurationProperty
    PositionGroupLocators positionGroup;

}
