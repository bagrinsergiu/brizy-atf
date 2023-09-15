package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.map.settings;

import com.brizy.io.web.common.dto.element.properties.common.settings.CanHaveSettings;
import com.brizy.io.web.common.dto.element.properties.common.settings.SettingsProperties;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.composite.InputWithUnits;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.SettingsLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.CustomizableSize;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

import static com.brizy.io.web.common.dto.element.properties.common.settings.SettingsProperties.builder;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Settings implements CustomizableSize {

    Supplier<InputWithUnits> width;
    Supplier<InputWithUnits> height;
    Supplier<Button> settingsButton;

    public Settings(SettingsLocators settingsProperties, Frame page) {
        this.settingsButton = () -> new Button(page.locator(settingsProperties.getSelf()));
        this.width = () -> new InputWithUnits(settingsProperties.getWidth(), page);
        this.height = () -> new InputWithUnits(settingsProperties.getHeight(), page);
    }

    @Override
    public void with(CanHaveSettings settingsToApply) {
        settingsButton.get().click();
        width.get().setValue(settingsToApply.getWidth());
        height.get().setValue(settingsToApply.getHeight());
    }

    public SettingsProperties getProperties() {
        settingsButton.get().click();
        return builder()
                .height(height.get().getValue())
                .width(width.get().getValue())
                .build();
    }

}
