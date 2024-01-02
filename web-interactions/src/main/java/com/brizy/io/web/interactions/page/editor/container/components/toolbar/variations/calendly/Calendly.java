package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.calendly;

import com.brizy.io.web.common.dto.element.properties.calendly.calendly.CalendlyPopUpProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.calendly.CalendlyLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsPopUpTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.calendly.tab.CalendlyTab;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.Objects;
import java.util.function.Supplier;

import static io.vavr.API.$;
import static io.vavr.API.Case;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@FieldNameConstants
public class Calendly extends AbstractToolbarItem {

    Supplier<CalendlyTab> calendly;

    public Calendly(CalendlyLocators calendlyLocators, Frame frame) {
        super(calendlyLocators.getSelf(), calendlyLocators.getTabs().getSelf(), frame);
        this.calendly = () -> new CalendlyTab(calendlyLocators.getTabs().getCalendly(), frame);
    }

    @Override
    public IsPopUpTab openTab(String tab) {
        return io.vavr.API.Match(tab.toLowerCase()).of(
                Case($(), calendly)
        );
    }

    public CalendlyPopUpProperties getProperties() {
        return CalendlyPopUpProperties.builder()
                .calendly(calendly.get().getProperties())
                .build();
    }

    public void setProperties(CalendlyPopUpProperties calendlyTabProperties) {
        if (Objects.nonNull(calendlyTabProperties.getCalendly())) {
            calendly.get().setProperties(calendlyTabProperties.getCalendly());
        }
    }
}
