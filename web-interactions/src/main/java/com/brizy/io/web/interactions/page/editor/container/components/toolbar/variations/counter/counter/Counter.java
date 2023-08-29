package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.counter.counter;

import com.brizy.io.web.common.dto.element.properties.counter.CounterProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.counter.CounterLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsPopUpTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.counter.counter.tab.AdvancedTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.counter.counter.tab.CounterTab;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.Objects;
import java.util.function.Supplier;

import static io.vavr.API.*;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Counter extends AbstractToolbarItem {

    Supplier<CounterTab> counter;
    Supplier<AdvancedTab> advanced;

    public Counter(CounterLocators counterLocators, Frame frame) {
        super(counterLocators.getSelf(), counterLocators.getTabs().getSelf(), frame);
        this.counter = () -> new CounterTab(counterLocators.getTabs().getCounter(), frame);
        this.advanced = () -> new AdvancedTab(counterLocators.getTabs().getAdvanced(), frame);
    }

    public void applyProperties(CounterProperties counter) {
        open();
        if (Objects.nonNull(counter.getCounter())) {
            this.counter.get().applyProperties(counter.getCounter());
        }
        if (Objects.nonNull(counter.getCounterAdvancedProperties())) {
            this.advanced.get().applyProperties(counter.getCounterAdvancedProperties());
        }

    }

    @Override
    public IsPopUpTab openTab(String tab) {
        open();
        return Match(tab.toLowerCase()).of(
                Case($(Counter.Fields.counter), counter),
                Case($(Counter.Fields.advanced), advanced)
        );
    }
}
