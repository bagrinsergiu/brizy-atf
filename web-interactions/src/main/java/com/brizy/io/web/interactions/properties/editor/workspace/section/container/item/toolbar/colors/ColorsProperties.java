package com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.colors;

import com.brizy.io.web.interactions.properties.AbstractProperty;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.colors.tabs.TabsProperties;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.colors.tabs.common.AbstractColorWithGradient;
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
public class ColorsProperties extends AbstractProperty {

    String normal;
    String hover;
    @NestedConfigurationProperty
    TabsProperties tabs;

}
