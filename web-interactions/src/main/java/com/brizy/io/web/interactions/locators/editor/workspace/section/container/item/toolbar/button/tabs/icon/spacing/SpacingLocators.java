package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.button.tabs.icon.spacing;

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
public class SpacingLocators extends AbstractProperty {

    String value;
    String unit;

}
