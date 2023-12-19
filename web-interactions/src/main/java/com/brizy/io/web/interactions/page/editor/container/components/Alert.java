package com.brizy.io.web.interactions.page.editor.container.components;

import com.brizy.io.web.common.dto.element.properties.alert.AlertProperties;
import com.brizy.io.web.common.dto.element.type.Content;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.page.editor.container.components.content.variations.alert.AlertContent;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.AlertToolbar;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public class Alert extends ComponentWithContent<AlertProperties> {

    AlertToolbar toolbar;
    Supplier<Button> borderButton;
    Supplier<AlertContent> alertContent;

    public Alert(ItemLocators itemLocators, Frame frame, Locator locator) {
        super(frame, locator, itemLocators);
        this.toolbar = new AlertToolbar(itemLocators.getToolbar(), frame);
        this.borderButton = () -> new Button(frame.locator(itemLocators.getBorderButton()));
        this.alertContent = () -> new AlertContent(itemLocators, frame, locator);
    }

    @Override
    public AlertProperties getEditorProperties() {
        return toolbar.getProperties();
    }

    @Override
    protected void openToolbar() {
        borderButton.get().click();
    }

    @Override
    public <Type extends Content> void configureContents(List<Type> content) {
        alertContent.get().setContent(content);
    }

}
