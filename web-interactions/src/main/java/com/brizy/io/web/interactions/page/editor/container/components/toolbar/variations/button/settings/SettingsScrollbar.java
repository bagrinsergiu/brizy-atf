package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.settings;

import com.brizy.io.web.common.dto.element.properties.button.settings.ButtonSettingsProperties;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.HasTabs;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.IsTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.settings.effects.EffectsTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.settings.styling.StylingTab;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.settings.scrollbar.ScrollBarLocators;
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
public class SettingsScrollbar implements HasTabs {

    @Getter
    Supplier<Locator> tabsLocator;
    Supplier<StylingTab> styling;
    Supplier<EffectsTab> effects;

    public SettingsScrollbar(ScrollBarLocators scrollBarLocators, Page frame) {
        this.tabsLocator = () -> frame.locator(scrollBarLocators.getTabs());
        this.styling = () -> new StylingTab(scrollBarLocators.getStyling(), frame);
        this.effects = () -> new EffectsTab(scrollBarLocators.getEffects(), frame);
    }

    public void applyProperties(ButtonSettingsProperties settings) {
        if (Objects.nonNull(settings.getStyling())) {
            styling.get().applyProperties(settings.getStyling());
        }
        if (Objects.nonNull(settings.getEffects())) {
            effects.get().applyProperties(settings.getEffects());
        }
    }

    @Override
    public IsTab openTab(String tab) {
        return null;
    }

    public ButtonSettingsProperties getProperties() {
        return ButtonSettingsProperties.builder()
                .effects(effects.get().getProperties())
                .styling(styling.get().getProperties())
                .build();
    }
}
