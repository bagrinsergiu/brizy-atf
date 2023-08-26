package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.map.colors;

import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.colors.ColorsLocators;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.colors.tabs.TabsLocators;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Colors {

    Supplier<Button> backgroundButton;
    Supplier<Background> backgroundSubMenu;
    Supplier<Button> borderButton;
    Supplier<Border> borderSubMenu;
    Supplier<Button> shadowButton;
    Supplier<Shadow> shadowSubMenu;

    public Colors(ColorsLocators colorsLocators, Frame page) {
        TabsLocators tabs = colorsLocators.getTabs();
        backgroundButton = () -> new Button(page.locator(tabs.getBackground().getSelf()));
        backgroundSubMenu = () -> new Background(tabs.getBackground(), page);
        borderButton = () -> new Button(page.locator(tabs.getBorder().getSelf()));
        borderSubMenu = () -> new Border(tabs.getBorder(), page);
        shadowButton = () -> new Button(page.locator(tabs.getShadow().getSelf()));
        shadowSubMenu = () -> new Shadow(tabs.getShadow(), page);
    }

    public Background background() {
        backgroundButton.get().click();
        return backgroundSubMenu.get();
    }

    public Border border() {
        borderButton.get().click();
        return borderSubMenu.get();
    }

    public Shadow shadow() {
        shadowButton.get().click();
        return shadowSubMenu.get();
    }

}
