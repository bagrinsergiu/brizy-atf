package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations;

import com.brizy.io.web.common.dto.element.properties.common.align.Alignments;
import com.brizy.io.web.common.dto.element.properties.counter.CounterProperties;
import com.brizy.io.web.interactions.element.composite.EnumerableButton;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.Toolbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.counter.counter.Counter;
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
public class CounterToolbar extends Toolbar<CounterProperties> {

    Supplier<Counter> counter;
    //    Supplier<Typography> typography;
//    Supplier<Colors> colors;
    Supplier<EnumerableButton<Alignments>> align;


    public CounterToolbar(ToolbarLocators toolbarLocators, Frame frame) {
        super(toolbarLocators, frame);
        this.counter = () -> new Counter(toolbarLocators.getCounter(), frame);
        this.align = () -> new EnumerableButton<>(Alignments.class, toolbarLocators.getAlign(), frame);
    }

    @Override
    public IsToolbarItem openTabbedPopup(String toolbarItemTitle) {
        return API.Match(toolbarItemTitle.toLowerCase()).of(
                API.Case($(CounterToolbar.Fields.counter), counter)
        );
    }

    @Override
    public CounterProperties getProperties() {
//        counterButton.get().click();
//        return CountersFactory.of(properties.getCounter(), page).getCounter().getProperties();
        return null;
    }

    @Override
    public void setProperties(CounterProperties properties) {
        if (Objects.nonNull(properties)) {
            counter.get().applyProperties(properties);
        }
    }

}