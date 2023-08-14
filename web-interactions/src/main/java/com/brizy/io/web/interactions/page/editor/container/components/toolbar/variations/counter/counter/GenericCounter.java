package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.counter.counter;

import com.brizy.io.web.common.dto.element.properties.counter.Counter;
import com.brizy.io.web.common.dto.element.properties.counter.enums.StypeType;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.counter.CounterPropertyDto;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.counter.counter.enums.Types;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.counter.counter.tab.Style;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.counter.CounterProperties;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.counter.tabs.TabsProperties;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class GenericCounter {

    Supplier<Style> style;
    Supplier<Button> counterButton;

    public GenericCounter(CounterProperties counterProperties, Frame page) {
        TabsProperties tabs = counterProperties.getTabs();
        this.counterButton = () -> new Button(page.locator(tabs.getCounter().getSelf()));
        this.style = () -> new Style(tabs.getCounter(), page);
    }

    public abstract void change(Counter counterProperties);

    public abstract CounterPropertyDto getProperties();

    protected void changeToStyle(StypeType styleToChange) {
        style.get().change(Types.valueOf(styleToChange.name()));
    }

}
