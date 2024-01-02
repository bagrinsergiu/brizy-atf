package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.colors.tabs.border;

import com.brizy.io.web.interactions.locators.AbstractLocator;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class BorderWidthLocators extends AbstractLocator {

    String right;
    String left;
    String up;
    String down;

}
