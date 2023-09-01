package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.colors;

import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.colors.tabs.overlay.OverlayLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.colors.gradient.CanHaveGradient;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Overlay {

    Supplier<CanHaveGradient> gradientColor;

    public Overlay(OverlayLocators overlay, Frame page) {
        this.gradientColor = () -> new CanHaveGradient(overlay, page);
    }

    public void applyProperties(com.brizy.io.web.common.dto.element.properties.image.colors.overlay.Overlay overlay) {
        gradientColor.get().applyColors(overlay);
    }

}
