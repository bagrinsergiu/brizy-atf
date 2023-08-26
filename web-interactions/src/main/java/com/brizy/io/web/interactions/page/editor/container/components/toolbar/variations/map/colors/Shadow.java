package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.map.colors;

import com.brizy.io.web.common.dto.element.properties.image.image.shadow.CanHaveShadow;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.colors.tabs.shadow.ShadowLocators;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Shadow {


    public Shadow(ShadowLocators shadow, Frame page) {

    }

    public void applyProperties(CanHaveShadow shadow) {

    }
}
