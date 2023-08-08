package com.brizy.io.web.interactions.page.editor.container.components.toolbar.common;

import com.brizy.io.web.common.dto.element.properties.common.colors.border.CanHaveBorders;

public interface CustomizableBorder {

    <T extends CanHaveBorders> void applyProperties(T borders);

}
