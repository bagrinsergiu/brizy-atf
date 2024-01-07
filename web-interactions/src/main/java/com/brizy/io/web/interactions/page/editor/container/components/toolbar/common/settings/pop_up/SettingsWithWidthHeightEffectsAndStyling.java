package com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.pop_up;

import com.brizy.io.web.common.dto.element.properties.common.settings.pop_up.SettingsWithWidthHeightEffectsAndStylingProperties;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.composite.InputWithUnits;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.SettingsLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsPopUpTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsToolbarItem;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SettingsWithWidthHeightEffectsAndStyling extends AbstractSettingsPopUpWithEffectsAndStyling implements SettingsPopUp<SettingsWithWidthHeightEffectsAndStylingProperties>, IsToolbarItem {

    Supplier<InputWithUnits> height;
    Supplier<InputWithUnits> width;

    public SettingsWithWidthHeightEffectsAndStyling(SettingsLocators settingsLocators, Frame frame) {
        super(settingsLocators, frame);
        this.height = () -> new InputWithUnits(getTabsLocators().getHeight(), frame);
        this.width = () -> new InputWithUnits(getTabsLocators().getWidth(), frame);
    }

    @Override
    public SettingsWithWidthHeightEffectsAndStylingProperties getProperties() {
        open();
        return SettingsWithWidthHeightEffectsAndStylingProperties.builder()
                .height(height.get().getValue())
                .width(width.get().getValue())
// No need to check
//                .effects(getEffectProperties())
//                .styling(getStylingProperties())
                .build();
    }

    @Override
    public void setProperties(SettingsWithWidthHeightEffectsAndStylingProperties properties) {
        open();
        if (Objects.nonNull(properties.getHeight())) {
            height.get().setValue(properties.getHeight());
        }
        if (Objects.nonNull(properties.getWidth())) {
            width.get().setValue(properties.getWidth());
        }
        if (Objects.nonNull(properties.getEffects())) {
            applyEffectProperties(properties.getEffects());
        }
        if (Objects.nonNull(properties.getStyling())) {
            applyStylingProperties(properties.getStyling());
        }
    }

    @Override
    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name(Fields.height).element(height).build(),
                Configuration.builder().name(Fields.width).element(width).build()
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
