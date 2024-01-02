package com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.pop_up;

import com.brizy.io.web.common.dto.element.properties.common.settings.pop_up.SettingsWithHeightProperties;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.composite.InputWithUnits;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.SettingsLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsPopUpTab;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SettingsWithHeight extends AbstractSettingsPopUp implements SettingsPopUp<SettingsWithHeightProperties> {

    Supplier<InputWithUnits> height;

    public SettingsWithHeight(SettingsLocators settingsLocators, Frame frame) {
        super(settingsLocators, frame);
        this.height = () -> new InputWithUnits(getTabsLocators().getHeight(), frame);
    }

    @Override
    public SettingsWithHeightProperties getProperties() {
        open();
        return SettingsWithHeightProperties.builder()
                .height(height.get().getValue())
                .build();
    }

    @Override
    public void setProperties(SettingsWithHeightProperties properties) {
        open();
        if (Objects.nonNull(properties.getHeight())) {
            height.get().setValue(properties.getHeight());
        }
    }

    @Override
    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name(Fields.height).element(height).build()
        );
    }

    @Override
    public List<String> getTabs() {
        return List.of();
    }

    @Override
    public IsPopUpTab openTab(String tab) {
        return this;
    }
}
