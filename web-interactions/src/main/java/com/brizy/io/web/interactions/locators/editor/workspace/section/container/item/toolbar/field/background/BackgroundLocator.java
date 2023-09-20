package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.background;

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
public class BackgroundLocator extends AbstractProperty {

    String configurations;
    String size;

}
