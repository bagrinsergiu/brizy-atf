package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.colors.tabs.common;

import com.brizy.io.web.interactions.locators.AbstractProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public abstract class AbstractColor extends AbstractProperty {
    /**
     * Value of the color to be set inside all the tabs
     */
    String value;
    String configurations;

}
