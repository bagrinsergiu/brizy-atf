package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations;

import com.brizy.io.web.common.dto.element.properties.alert.AlertProperties;
import com.brizy.io.web.common.dto.element.properties.common.align.Alignments;
import com.brizy.io.web.common.dto.element.properties.common.settings.pop_up.SettingsWithWidthEffectsAndStylingProperties;
import com.brizy.io.web.interactions.element.composite.EnumerableButton;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.Toolbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.pop_up.SettingsPopUp;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.pop_up.SettingsWithWidthEffectsAndStyling;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.alert.alert.Alert;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.colors.Colors;
import com.microsoft.playwright.Frame;
import io.vavr.API;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.Objects;
import java.util.function.Supplier;

import static io.vavr.API.$;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@FieldNameConstants
public class AlertToolbar extends Toolbar<AlertProperties> {

    Supplier<Alert> alert;
    Supplier<Colors> colors;
    Supplier<SettingsPopUp<SettingsWithWidthEffectsAndStylingProperties>> settings;
    Supplier<EnumerableButton<Alignments>> align;

    public AlertToolbar(ToolbarLocators toolbarLocators, Frame frame) {
        super(toolbarLocators, frame);
        this.alert = () -> new Alert(toolbarLocators.getAlert(), frame);
        this.settings = () -> new SettingsWithWidthEffectsAndStyling(toolbarLocators.getSettings(), frame);
        this.colors = () -> new Colors(toolbarLocators.getColors(), frame);
        this.align = () -> new EnumerableButton<>(Alignments.class, toolbarLocators.getAlign(), frame);
    }

    @Override
    public AlertProperties getProperties() {
        return AlertProperties.builder()
                .alert(alert.get().getProperties())
                .settings(settings.get().getProperties())
                .build();
    }

    @Override
    public void setProperties(AlertProperties properties) {
        if (Objects.nonNull(properties)) {
            if (Objects.nonNull(properties.getAlert())) {
                alert.get().setProperties(properties.getAlert());
            }
            if (Objects.nonNull(properties.getAlign())) {
                align.get().setValue(properties.getAlign());
            }
            if (Objects.nonNull(properties.getSettings())) {
                settings.get().setProperties(properties.getSettings());
            }
        }
    }

    @Override
    public IsToolbarItem openTabbedPopup(String toolbarItemTitle) {
        return API.Match(toolbarItemTitle.toLowerCase()).of(
                API.Case($(Fields.alert), alert),
                API.Case($(Fields.colors), colors),
                API.Case($(Fields.settings), settings)
        );
    }

}