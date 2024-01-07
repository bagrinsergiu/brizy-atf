package com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.pop_up;

import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.effects.EffectsProperties;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.SettingsLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.scrollbar.effects.EffectsTab;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
abstract class AbstractSettingsPopUpWithEffectsAndStyling extends AbstractSettingsPopUpWithStyling {

    Supplier<EffectsTab> effects;
    Supplier<Button> effectsButton;

    public AbstractSettingsPopUpWithEffectsAndStyling(SettingsLocators settingsLocators, Frame frame) {
        super(settingsLocators, frame);
        this.effects = () -> new EffectsTab(getScrollBarLocators().getEffects(), frame.page());
        this.effectsButton = () -> new Button(frame.locator(getSettingsGridLocators().getEffects()));
    }

    public void applyEffectProperties(EffectsProperties settings) {
        if (Objects.nonNull(settings)) {
            openScrollbarItem();
            effects.get().applyProperties(settings);
            close();
        }
    }

    public EffectsProperties getEffectProperties() {
        openScrollbarItem();
        var properties = effects.get().getProperties();
        close();
        return properties;
    }

    private void openScrollbarItem() {
        effectsButton.get().click();
    }


}
