package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.alert.alert;

import com.brizy.io.web.common.dto.element.properties.alert.alert.AlertTabProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.alert.AlertLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsPopUpTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.alert.alert.tab.AlertTab;
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
public class Alert extends AbstractToolbarItem {

    Supplier<AlertTab> alert;

    public Alert(AlertLocators alertLocators, Frame frame) {
        super(alertLocators.getSelf(), alertLocators.getTabs().getSelf(), frame);
        this.alert = () -> new AlertTab(alertLocators.getTabs().getAlert(), frame);
    }

    @Override
    public IsPopUpTab openTab(String tab) {
        return io.vavr.API.Match(tab.toLowerCase()).of(
                Case($(), alert)
        );
    }

    public AlertTabProperties getProperties() {
        return AlertTabProperties.builder()
                .alert(alert.get().getProperties())
                .build();
    }

    public void setProperties(AlertTabProperties alertTabProperties) {
        if (Objects.nonNull(alertTabProperties.getAlert())) {
            alert.get().setProperties(alertTabProperties.getAlert());
        }
    }
}
