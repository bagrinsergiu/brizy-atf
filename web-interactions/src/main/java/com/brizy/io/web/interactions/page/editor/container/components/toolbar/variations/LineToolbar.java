package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations;

import com.brizy.io.web.common.dto.element.properties.common.align.Alignments;
import com.brizy.io.web.common.dto.element.properties.common.settings.pop_up.SettingsWithWidthEffectsAndStylingProperties;
import com.brizy.io.web.common.dto.element.properties.line.LineProperties;
import com.brizy.io.web.interactions.element.composite.EnumerableButton;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.Toolbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.pop_up.SettingsPopUp;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.pop_up.SettingsWithWidthEffectsAndStyling;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.colors.Colors;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.line.pop_up.LinePopUp;
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
public class LineToolbar extends Toolbar<LineProperties> {

    Supplier<EnumerableButton<Alignments>> align;
    Supplier<LinePopUp> line;
    Supplier<Colors> colors;
    Supplier<SettingsPopUp<SettingsWithWidthEffectsAndStylingProperties>> settings;

    public LineToolbar(ToolbarLocators toolbarLocators, Frame frame) {
        super(toolbarLocators, frame);
        this.align = () -> new EnumerableButton<>(Alignments.class, toolbarLocators.getAlign(), frame);
        this.line = () -> new LinePopUp(toolbarLocators.getLine(), frame);
        this.colors = () -> new Colors(toolbarLocators.getColors(), frame);
        this.settings = () -> new SettingsWithWidthEffectsAndStyling(toolbarLocators.getSettings(), frame);
    }

    @Override
    public LineProperties getProperties() {
        return LineProperties.builder()
                .align(align.get().getValue())
                .line(line.get().getProperties())
                .settings(settings.get().getProperties())
                .build();
    }

    @Override
    public void setProperties(LineProperties properties) {
        if (Objects.nonNull(properties.getAlign())) {
            align.get().setValue(properties.getAlign());
        }
        if (Objects.nonNull(properties.getLine())) {
            line.get().applyProperties(properties.getLine());
        }
        if (Objects.nonNull(properties.getSettings())) {
            settings.get().setProperties(properties.getSettings());
        }
    }

    @Override
    public IsToolbarItem openTabbedPopup(String toolbarItemTitle) {
        return API.Match(toolbarItemTitle.toLowerCase()).of(
                API.Case($("style"), line),
                API.Case($(Fields.colors), colors),
                API.Case($(Fields.settings), settings)
        );
    }

}