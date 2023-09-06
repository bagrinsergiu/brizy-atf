package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations;

import com.brizy.io.web.common.dto.element.properties.spacer.SpacerProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.ComponentToolbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.spacer.Settings;
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
public class SpacerToolbar extends ComponentToolbar<SpacerProperties> {

    Supplier<Settings> settings;

    public SpacerToolbar(ToolbarLocators properties, Frame frame) {
        super(properties, frame);
        this.settings = () -> new Settings(properties.getSettings(), frame);
    }

    @Override
    public IsToolbarItem openTabbedPopup(String toolbarItemTitle) {
        return API.Match(toolbarItemTitle.toLowerCase()).of(
                API.Case($(Fields.settings), settings)
        );
    }

    @Override
    public SpacerProperties getProperties() {
        return SpacerProperties.builder()
                .settings(settings.get().getProperties())
                .build();
    }

    @Override
    public void setProperties(SpacerProperties properties) {
        if (Objects.nonNull(properties)) {
            settings.get().applyProperties(properties.getSettings());
        }
    }

}