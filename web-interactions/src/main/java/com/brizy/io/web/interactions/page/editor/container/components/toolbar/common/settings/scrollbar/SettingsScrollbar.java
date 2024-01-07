package com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.scrollbar;

import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.SettingsProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.scrollbar.ScrollBarLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.scrollbar.effects.EffectsTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.scrollbar.styling.StylingTab;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.Objects;
import java.util.function.Supplier;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SettingsScrollbar {

    @Getter
    Supplier<Locator> tabsLocator;
    Supplier<StylingTab> styling;
    Supplier<EffectsTab> effects;

    public SettingsScrollbar(ScrollBarLocators scrollBarLocators, Page frame) {
        this.tabsLocator = () -> frame.locator(scrollBarLocators.getTabs());
        this.styling = () -> new StylingTab(scrollBarLocators.getStyling(), frame);
        this.effects = () -> new EffectsTab(scrollBarLocators.getEffects(), frame);
    }

    public void applyProperties(SettingsProperties settings) {
        if (Objects.nonNull(settings.getStyling())) {
            styling.get().applyProperties(settings.getStyling());
        }
        if (Objects.nonNull(settings.getEffects())) {
            effects.get().applyProperties(settings.getEffects());
        }
    }

    public SettingsProperties getProperties() {
        return SettingsProperties.builder()
                .effects(effects.get().getProperties())
                .styling(styling.get().getProperties())
                .build();
    }

}
