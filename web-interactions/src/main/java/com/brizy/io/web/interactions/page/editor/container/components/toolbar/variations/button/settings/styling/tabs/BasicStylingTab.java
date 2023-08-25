package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.settings.styling.tabs;

import com.brizy.io.web.common.dto.element.properties.button.settings.styling.basic.BasicStylingProperties;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.IsTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.settings.styling.tabs.basic.margin.MarginSettings;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.settings.styling.tabs.basic.padding.PaddingSettings;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.settings.styling.tabs.basic.position.PositionSettings;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.styling.basic.BasicStylingLocators;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class BasicStylingTab implements IsTab {

    @Getter
    Supplier<Button> tabButton;
    Supplier<PaddingSettings> paddingSettings;
    Supplier<MarginSettings> marginSettings;
    Supplier<PositionSettings> positionSettings;

    public BasicStylingTab(BasicStylingLocators basicStylingLocators, Page frame) {
        this.tabButton = () -> new Button(frame.locator(basicStylingLocators.getTab()));
        this.paddingSettings = () -> new PaddingSettings(basicStylingLocators.getPadding(), frame);
        this.marginSettings = () -> new MarginSettings(basicStylingLocators.getMargin(), frame);
        this.positionSettings = () -> new PositionSettings(basicStylingLocators.getPositionGroup(), frame);
    }

    public void applyProperties(BasicStylingProperties basicStylingProperties) {
        open();
        if (Objects.nonNull(basicStylingProperties.getPadding())) {
            paddingSettings.get().applyProperties(basicStylingProperties.getPadding());
        }
        if (Objects.nonNull(basicStylingProperties.getMargin())) {
            marginSettings.get().applyProperties(basicStylingProperties.getMargin());
        }
        if (Objects.nonNull(basicStylingProperties.getPosition())) {
            positionSettings.get().applyProperties(basicStylingProperties.getPosition());
        }
    }

    @Override
    public List<String> getWebConfigurations() {
        return null;
    }

    @Override
    public List<Configuration> getConfigurations() {
        return null;
    }

    public BasicStylingProperties getProperties() {
        open();
        return BasicStylingProperties.builder()
                .margin(marginSettings.get().getProperties())
                .padding(paddingSettings.get().getProperties())
                .position(positionSettings.get().getProperties())
                .build();
    }
}
