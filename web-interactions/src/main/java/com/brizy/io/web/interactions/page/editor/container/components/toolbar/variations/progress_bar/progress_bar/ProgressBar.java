package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.progress_bar.progress_bar;

import com.brizy.io.web.common.dto.element.properties.progress_bar.progress_bar.ProgressBarProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.progress.ProgressLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsPopUpTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.progress_bar.progress_bar.tabs.ProgressBarTab;
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
public class ProgressBar extends AbstractToolbarItem {

    Supplier<ProgressBarTab> progressBarTab;

    public ProgressBar(ProgressLocators progressLocators, Frame frame) {
        super(progressLocators.getSelf(), progressLocators.getTabs().getSelf(), frame);
        this.progressBarTab = () -> new ProgressBarTab(progressLocators.getTabs().getProgress(), frame);
    }

    @Override
    public IsPopUpTab openTab(String tab) {
        return io.vavr.API.Match(tab.toLowerCase()).of(
                Case($(), progressBarTab)
        );
    }

    public ProgressBarProperties getProperties() {
        return ProgressBarProperties.builder()
                .progress(progressBarTab.get().getProperties())
                .build();
    }

    public void setProperties(ProgressBarProperties progressBarTabsProperties) {
        if (Objects.nonNull(progressBarTabsProperties.getProgress())) {
            progressBarTab.get().setProperties(progressBarTabsProperties.getProgress());
        }
    }
}
