package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.colors.tabs.common;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public abstract class AbstractColorWithGradient extends AbstractColor {

    String type;
    String gradientType;
    String angle;

}
