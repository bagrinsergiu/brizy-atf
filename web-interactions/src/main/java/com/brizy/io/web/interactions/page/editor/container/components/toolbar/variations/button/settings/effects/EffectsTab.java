package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.settings.effects;

import com.brizy.io.web.common.dto.element.properties.button.settings.effects.EffectsProperties;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.HasTabs;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.IsTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.settings.effects.tabs.EntranceTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.settings.effects.tabs.HoverTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.settings.effects.tabs.ScrollTab;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.effects.EffectsLocators;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EffectsTab implements HasTabs {

    Supplier<Button> tab;
    @Getter
    Supplier<Locator> tabsLocator;
    Supplier<EntranceTab> entrance;
    Supplier<HoverTab> hover;
    Supplier<ScrollTab> scroll;

    public EffectsTab(EffectsLocators effectsLocator, Page page) {
        this.tab = () -> new Button(page.locator(effectsLocator.getSelf()));
        this.tabsLocator = () -> page.locator(effectsLocator.getTabs());
        this.entrance = () -> new EntranceTab(effectsLocator.getEntrance(), page);
        this.hover = () -> new HoverTab(effectsLocator.getHover(), page);
        this.scroll = () -> new ScrollTab(effectsLocator.getScroll(), page);
    }

    public void applyProperties(EffectsProperties effects) {
        tab.get().click();
        if (Objects.nonNull(effects.getEntrance())) {
            entrance.get().applyProperties(effects.getEntrance());
        }
        if (Objects.nonNull(effects.getHover())) {
            hover.get().applyProperties(effects.getHover());
        }
        if (Objects.nonNull(effects.getScroll())) {
            scroll.get().applyProperties(effects.getScroll());
        }
    }

    @Override
    public IsTab openTab(String tab) {
        return null;
    }

    public EffectsProperties getProperties() {
        tab.get().click();
        return EffectsProperties.builder()
                .entrance(entrance.get().getProperties())
                .hover(hover.get().getProperties())
                .scroll(scroll.get().getProperties())
                .build();
    }
}
