package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations;

import com.brizy.io.web.common.dto.element.properties.common.align.Alignments;
import com.brizy.io.web.common.dto.element.properties.countdown.CountdownProperties;
import com.brizy.io.web.interactions.element.composite.EnumerableButton;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.ComponentToolbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.countdown.CountdownTabs;
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
public class CountdownToolbar extends ComponentToolbar<CountdownProperties> {

    Supplier<CountdownTabs> countdown;
    Supplier<EnumerableButton<Alignments>> align;

    public CountdownToolbar(ToolbarLocators toolbarLocators, Frame frame) {
        super(toolbarLocators, frame);
        this.countdown = () -> new CountdownTabs(toolbarLocators.getCountdown(), frame);
        this.align = () -> new EnumerableButton<>(Alignments.class, toolbarLocators.getAlign(), frame);
    }

    @Override
    public IsToolbarItem openTabbedPopup(String toolbarItemTitle) {
        return API.Match(toolbarItemTitle.toLowerCase()).of(
                API.Case($(Fields.countdown), countdown)
        );
    }

    @Override
    public CountdownProperties getProperties() {
        return CountdownProperties.builder()
                .countdown(countdown.get().getProperties())
                .align(align.get().getValue())
                .build();
    }

    @Override
    public void setProperties(CountdownProperties properties) {
        if (Objects.nonNull(properties)) {
            if (Objects.nonNull(properties.getCountdown())) {
                countdown.get().applyProperties(properties.getCountdown());
            }
            if (Objects.nonNull(properties.getAlign())) {
                align.get().setValue(properties.getAlign());
            }
        }
    }

}