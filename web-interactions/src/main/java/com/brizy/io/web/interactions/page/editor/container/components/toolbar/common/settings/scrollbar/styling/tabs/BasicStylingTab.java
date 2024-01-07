package com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.scrollbar.styling.tabs;

import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.basic.BasicStylingProperties;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.styling.basic.BasicStylingLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.scrollbar.styling.tabs.basic.margin.MarginSettings;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.scrollbar.styling.tabs.basic.padding.PaddingSettings;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.scrollbar.styling.tabs.basic.position.PositionSettings;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class BasicStylingTab {

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
        tabButton.get().click();
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

    public BasicStylingProperties getProperties() {
        tabButton.get().click();
        return BasicStylingProperties.builder()
                .margin(marginSettings.get().getProperties())
                .padding(paddingSettings.get().getProperties())
                .position(positionSettings.get().getProperties())
                .build();
    }
}
