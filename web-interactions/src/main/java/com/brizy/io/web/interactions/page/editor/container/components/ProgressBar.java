package com.brizy.io.web.interactions.page.editor.container.components;

import com.brizy.io.web.common.dto.element.properties.progress_bar.ProgressBarProperties;
import com.brizy.io.web.common.dto.element.type.Content;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.page.editor.container.components.content.variations.progress_bar.ProgressBarContent;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.ProgressBarToolbar;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public class ProgressBar extends ComponentWithContent<ProgressBarProperties> {

    ProgressBarToolbar toolbar;
    ProgressBarContent progressBarContent;

    public ProgressBar(ItemLocators itemLocators, Frame frame, Locator locator) {
        super(frame, locator, itemLocators);
        this.toolbar = new ProgressBarToolbar(itemLocators.getToolbar(), frame);
        this.progressBarContent = new ProgressBarContent(itemLocators.getContent().getProgress(), locator);
    }

    @Override
    public ProgressBarProperties getEditorProperties() {
        return toolbar.getProperties();
    }

    @Override
    public <Type extends Content> void configureContents(List<Type> content) {
        progressBarContent.setContent(content);
    }

}
