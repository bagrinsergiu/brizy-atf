package com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.typography;

import com.brizy.io.web.interactions.properties.AbstractProperty;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.typography.fonts.FontsProperties;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.typography.styles.StylesProperties;
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
public class TypographyProperties extends AbstractProperty {

    @NestedConfigurationProperty
    FontsProperties fonts;
    @NestedConfigurationProperty
    StylesProperties styles;

}
