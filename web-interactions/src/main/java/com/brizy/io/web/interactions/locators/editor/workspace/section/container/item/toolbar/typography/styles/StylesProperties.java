package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.typography.styles;

import com.brizy.io.web.interactions.locators.AbstractLocator;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.typography.styles.letterSp.LetterSpProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.typography.styles.lineHgt.LineHgtProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.typography.styles.size.SizeProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.typography.styles.typography.TypographyProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.typography.styles.weight.WeightProperties;
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
public class StylesProperties extends AbstractLocator {

    @NestedConfigurationProperty
    TypographyProperties typography;
    @NestedConfigurationProperty
    SizeProperties size;
    @NestedConfigurationProperty
    WeightProperties weight;
    @NestedConfigurationProperty
    LineHgtProperties lineHgt;
    @NestedConfigurationProperty
    LetterSpProperties letterSp;

}
