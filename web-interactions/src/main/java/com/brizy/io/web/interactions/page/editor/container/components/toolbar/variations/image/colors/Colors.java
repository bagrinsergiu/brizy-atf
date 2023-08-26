package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.colors;

import com.brizy.io.web.common.dto.element.properties.image.colors.HoverColors;
import com.brizy.io.web.common.dto.element.properties.image.colors.ImageColors;
import com.brizy.io.web.common.dto.element.properties.image.colors.NormalColors;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsPopUpTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.map.colors.Border;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.map.colors.Shadow;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.colors.ColorsLocators;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.colors.tabs.TabsLocators;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Colors extends AbstractToolbarItem {

    Supplier<Button> hover;
    Supplier<Button> normal;
    Supplier<Button> overlayButton;
    Supplier<Overlay> overlaySubMenu;
    Supplier<Button> borderButton;
    Supplier<Border> borderSubMenu;
    Supplier<Button> shadowButton;
    Supplier<Shadow> shadowSubMenu;

    public Colors(ColorsLocators colorsLocators, Frame frame) {
        super(colorsLocators.getSelf(), colorsLocators.getTabs().getSelf(), frame);
        TabsLocators tabs = colorsLocators.getTabs();
        this.hover = () -> new Button(frame.locator(colorsLocators.getHover()));
        this.normal = () -> new Button(frame.locator(colorsLocators.getNormal()));
        this.overlayButton = () -> new Button(frame.locator(tabs.getOverlay().getSelf()));
        this.overlaySubMenu = () -> new Overlay(tabs.getOverlay(), frame);
        this.borderButton = () -> new Button(frame.locator(tabs.getBorder().getSelf()));
        this.borderSubMenu = () -> new Border(tabs.getBorder(), frame);
        this.shadowButton = () -> new Button(frame.locator(tabs.getShadow().getSelf()));
        this.shadowSubMenu = () -> new Shadow(tabs.getShadow(), frame);
    }

    @Override
    public IsPopUpTab openTab(String tab) {
        open();
        return null;
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
        open();
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

    public List<ImageColors> getProperties() {
        open();
        return null;
    }
}
