package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.alert.alert.tab;

import com.brizy.io.web.common.dto.element.properties.alert.alert.alert.Alert;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.Slider;
import com.brizy.io.web.interactions.element.composite.InputWithUnits;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.alert.tabs.alert.AlertTabLocators;
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
public class AlertTab extends AbstractTabItem {

    Supplier<Slider> displayCloseButton;
    Supplier<InputWithUnits> delay;
    Supplier<Slider> displayDescription;

    public AlertTab(AlertTabLocators alertTabLocators, Frame frame) {
        super(alertTabLocators.getConfigurations(), alertTabLocators.getSelf(), frame);
        this.delay = () -> new InputWithUnits(alertTabLocators.getDelay(), frame);
        this.displayCloseButton = () -> new Slider(frame.locator(alertTabLocators.getDisplayCloseButton()));
        this.displayDescription = () -> new Slider(frame.locator(alertTabLocators.getDisplayDescription()));
    }

    @Override
    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name(Fields.delay).element(delay).build(),
                Configuration.builder().name("display close button").element(displayCloseButton).build(),
                Configuration.builder().name("display description").element(displayDescription).build()
        );
    }

    public Alert getProperties() {
        open();
        return Alert.builder()
                .delay(delay.get().getValue())
                .displayCloseButton(displayCloseButton.get().getState())
                .displayDescription(displayDescription.get().getState())
                .build();
    }

    public void setProperties(Alert alert) {
        open();
        if (Objects.nonNull(alert.getDelay())) {
            delay.get().setValue(alert.getDelay());
        }
        if (Objects.nonNull(alert.getDisplayDescription())) {
            displayDescription.get().switchTo(alert.getDisplayDescription());
        }
        if (Objects.nonNull(alert.getDisplayCloseButton())) {
            displayCloseButton.get().switchTo(alert.getDisplayCloseButton());
        }
    }
}
