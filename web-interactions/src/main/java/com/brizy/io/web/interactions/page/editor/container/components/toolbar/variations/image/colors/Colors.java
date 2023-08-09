package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.colors;

import com.brizy.io.web.common.dto.element.properties.image.colors.HoverColors;
import com.brizy.io.web.common.dto.element.properties.image.colors.ImageColors;
import com.brizy.io.web.common.dto.element.properties.image.colors.NormalColors;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.IsTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.IsTabbedPopup;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.map.colors.Border;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.map.colors.Shadow;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.colors.ColorsProperties;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.colors.tabs.TabsProperties;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Colors implements IsTabbedPopup {

    Supplier<Button> hover;
    Supplier<Button> normal;
    Supplier<Button> overlayButton;
    Supplier<Overlay> overlaySubMenu;
    Supplier<Button> borderButton;
    Supplier<Border> borderSubMenu;
    Supplier<Button> shadowButton;
    Supplier<Shadow> shadowSubMenu;
    Supplier<Locator> tabs;

    public Colors(ColorsProperties colorsProperties, Frame page) {
        TabsProperties tabs = colorsProperties.getTabs();
        this.tabs = () -> page.locator(tabs.getSelf());
        this.hover = () -> new Button(page.locator(colorsProperties.getHover()));
        this.normal = () -> new Button(page.locator(colorsProperties.getNormal()));
        this.overlayButton = () -> new Button(page.locator(tabs.getOverlay().getSelf()));
        this.overlaySubMenu = () -> new Overlay(tabs.getOverlay(), page);
        this.borderButton = () -> new Button(page.locator(tabs.getBorder().getSelf()));
        this.borderSubMenu = () -> new Border(tabs.getBorder(), page);
        this.shadowButton = () -> new Button(page.locator(tabs.getShadow().getSelf()));
        this.shadowSubMenu = () -> new Shadow(tabs.getShadow(), page);
    }

    @Override
    public IsTab openTab(String tab) {
        return null;
    }

    @Override
    public List<String> getTabs() {
        return tabs.get().all().stream()
                .map(Locator::textContent)
                .toList();
    }

    public Overlay overlay() {
        overlayButton.get().click();
        return overlaySubMenu.get();
    }

    public Border border() {
        borderButton.get().click();
        return borderSubMenu.get();
    }

    public Shadow shadow() {
        shadowButton.get().click();
        return shadowSubMenu.get();
    }

    public void applyProperties(List<ImageColors> colors) {
        colors.forEach(color -> {
            if (color instanceof NormalColors) {
                normal.get().click();
            }
            if (color instanceof HoverColors) {
                hover.get().click();
            }
            if (Objects.nonNull(color.getOverlay())) {
                overlay().applyProperties(color.getOverlay());
            }
            if (Objects.nonNull(color.getBorder())) {
                border().applyProperties(color.getBorder());
            }
            if (Objects.nonNull(color.getShadow())) {
                shadow().applyProperties(color.getShadow());
            }
        });
    }

}
