package com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.colors.tabs;

import com.brizy.io.web.interactions.properties.AbstractProperty;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.colors.tabs.background.BackgroundProperties;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.colors.tabs.border.BorderProperties;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.colors.tabs.shadow.ShadowProperties;
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
public class TabsProperties extends AbstractProperty {

    @NestedConfigurationProperty
    BackgroundProperties background;
    @NestedConfigurationProperty
    BorderProperties border;
    @NestedConfigurationProperty
    ShadowProperties shadow;

}
