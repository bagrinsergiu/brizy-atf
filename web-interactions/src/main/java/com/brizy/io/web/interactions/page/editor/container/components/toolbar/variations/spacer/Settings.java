package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.spacer;

import com.brizy.io.web.common.dto.element.properties.common.settings.SettingsProperties;
import com.brizy.io.web.interactions.element.composite.InputWithUnits;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.SettingsLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsPopUpTab;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

import static com.brizy.io.web.common.dto.element.properties.common.settings.SettingsProperties.builder;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Settings extends AbstractToolbarItem {

    Supplier<InputWithUnits> height;

    public Settings(SettingsLocators settingsLocators, Frame frame) {
        super(settingsLocators.getSelf(), null, frame);
        this.height = () -> new InputWithUnits(settingsLocators.getHeight(), frame);
    }

    public void applyProperties(SettingsProperties settings) {
        open();
        if (Objects.nonNull(settings.getHeight())) {
            this.height.get().setValue(settings.getHeight());
        }
    }

    @Override
    public IsPopUpTab openTab(String tab) {
        return null;
    }

    @Override
    public List<String> getTabs() {
        return List.of();
    }

    public SettingsProperties getProperties() {
        open();
        return SettingsProperties.builder()
                .height(height.get().getValue())
                .build();
    }

}
