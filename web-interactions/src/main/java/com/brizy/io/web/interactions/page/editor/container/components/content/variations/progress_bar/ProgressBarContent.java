package com.brizy.io.web.interactions.page.editor.container.components.content.variations.progress_bar;

import com.brizy.io.web.common.dto.element.content.progress_bar.ProgressBarContentProperties;
import com.brizy.io.web.common.dto.element.type.Content;
import com.brizy.io.web.interactions.element.TextInput;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.content.progress_bar.ProgressBarContentLocators;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProgressBarContent {

    Supplier<TextInput> title;

    public ProgressBarContent(ProgressBarContentLocators contentLocators, Locator locator) {
        this.title = () -> new TextInput(locator.locator(contentLocators.getTitle()));
    }

    public <Type extends Content> void setContent(List<Type> content) {
        for (Type item : content) {
            title.get().fill(((ProgressBarContentProperties) item).getTitle());
        }
    }
}
