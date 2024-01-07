package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations;

import com.brizy.io.web.common.dto.element.properties.calendly.CalendlyProperties;
import com.brizy.io.web.common.dto.element.properties.common.align.Alignments;
import com.brizy.io.web.common.dto.element.properties.common.settings.pop_up.SettingsWithWidthHeightEffectsAndStylingProperties;
import com.brizy.io.web.interactions.element.composite.EnumerableButton;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.Toolbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.pop_up.SettingsPopUp;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.pop_up.SettingsWithWidthHeightEffectsAndStyling;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.calendly.Calendly;
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
public class CalendlyToolbar extends Toolbar<CalendlyProperties> {

    Supplier<Calendly> calendly;
    Supplier<Colors> colors;
    Supplier<SettingsPopUp<SettingsWithWidthHeightEffectsAndStylingProperties>> settings;
    Supplier<EnumerableButton<Alignments>> align;

    public CalendlyToolbar(ToolbarLocators properties, Frame frame) {
        super(properties, frame);
        this.calendly = () -> new Calendly(properties.getCalendly(), frame);
        this.colors = () -> new Colors(properties.getColors(), frame);
        this.settings = () -> new SettingsWithWidthHeightEffectsAndStyling(properties.getSettings(), frame);
        this.align = () -> new EnumerableButton<>(Alignments.class, properties.getAlign(), frame);
    }

    @Override
    public CalendlyProperties getProperties() {
        return CalendlyProperties.builder()
                .align(align.get().getValue())
                .calendly(calendly.get().getProperties())
                .settings(settings.get().getProperties())
                .build();
    }

    @Override
    public void setProperties(CalendlyProperties properties) {
        if (Objects.nonNull(properties)) {
            if (Objects.nonNull(properties.getCalendly())) {
                calendly.get().setProperties(properties.getCalendly());
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
                API.Case($(Fields.calendly), calendly),
                API.Case($(Fields.colors), colors),
                API.Case($(Fields.settings), settings)
        );
    }

}