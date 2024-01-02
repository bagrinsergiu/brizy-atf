package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.calendly.tab;

import com.brizy.io.web.common.dto.element.properties.calendly.calendly.calendly.CalendlyTabProperties;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.TextInput;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.calendly.tabs.calendly.CalendlyTabLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractTabItem;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CalendlyTab extends AbstractTabItem {

    Supplier<TextInput> link;

    public CalendlyTab(CalendlyTabLocators calendlyTabLocators, Frame frame) {
        super(calendlyTabLocators.getConfigurations(), calendlyTabLocators.getSelf(), frame);
        this.link = () -> new TextInput(frame.locator(calendlyTabLocators.getLink()));
    }

    @Override
    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name(Fields.link).element(link).build()
        );
    }

    public CalendlyTabProperties getProperties() {
        open();
        return CalendlyTabProperties.builder()
                .link(link.get().getRawValue())
                .build();
    }

    public void setProperties(CalendlyTabProperties calendlyTabProperties) {
        open();
        if (Objects.nonNull(calendlyTabProperties.getLink())) {
            link.get().fill(calendlyTabProperties.getLink());
        }
    }
}
