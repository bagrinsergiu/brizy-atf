package com.brizy.io.web.interactions.page.editor.container.components.content.variations.alert;

import com.brizy.io.web.common.dto.element.type.Content;
import com.brizy.io.web.interactions.element.Span;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.page.editor.container.components.content.variations.alert.details.description.AlertDescription;
import com.brizy.io.web.interactions.page.editor.container.components.content.variations.alert.details.title.AlertTitle;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AlertContent {

    Supplier<AlertTitle> title;
    Supplier<AlertDescription> description;
    Supplier<Span> closeButton;

    public AlertContent(ItemLocators contentLocators, Frame frame, Locator locator) {
        var alertContentLocators = contentLocators.getContent().getAlert();
        this.closeButton = () -> new Span(frame.locator(alertContentLocators.getClose()));
        this.description = () -> new AlertDescription(contentLocators, frame, frame.locator(alertContentLocators.getDescription()));
        this.title = () -> new AlertTitle(contentLocators, frame, frame.locator(alertContentLocators.getTitle()));
    }

    public <Type extends Content> void setContent(List<Type> content) {
        for (Type item : content) {
            if (item instanceof com.brizy.io.web.common.dto.element.content.alert.details.title.AlertTitle alertTitle) {
                title.get().configureAlertDetails(alertTitle);
            } else if (item instanceof com.brizy.io.web.common.dto.element.content.alert.details.description.AlertDescription alertDescription) {
                description.get().configure(alertDescription.getProperties());
            }
        }
    }
}
