package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.typography.fonts;

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
public class FontsProperties extends AbstractProperty {

    String font;
    String activeFont;
    String newFont;

}
