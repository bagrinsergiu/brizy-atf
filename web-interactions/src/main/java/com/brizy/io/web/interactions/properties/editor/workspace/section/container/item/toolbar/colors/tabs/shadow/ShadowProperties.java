package com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.colors.tabs.shadow;

import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.colors.tabs.common.AbstractColor;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ShadowProperties extends AbstractColor {

    String type;
    String blurRadius;
    String verticalOffset;
    String horizontalOffset;
    String spreadRadius;

}
