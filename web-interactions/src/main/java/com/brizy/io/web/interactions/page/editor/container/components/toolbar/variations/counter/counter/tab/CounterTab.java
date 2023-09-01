package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.counter.counter.tab;

import com.brizy.io.web.common.dto.element.properties.counter.defaults.CounterTabProperties;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.RangeInput;
import com.brizy.io.web.interactions.element.composite.InputWithPopulation;
import com.brizy.io.web.interactions.element.composite.RadioControl;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.counter.tabs.CounterLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractTabItem;
import com.brizy.io.web.common.dto.element.properties.counter.enums.CounterType;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CounterTab extends AbstractTabItem {

    Supplier<RadioControl<CounterType>> style;
    Supplier<InputWithPopulation> start;
    Supplier<InputWithPopulation> end;
    Supplier<RangeInput> duration;

    public CounterTab(CounterLocators counter, Frame frame) {
        super(counter.getConfigurations(), counter.getSelf(), frame);
        this.style = () -> new RadioControl<>(CounterType.class, counter.getStyle(), frame);
        this.start = () -> new InputWithPopulation(counter.getStart(), frame);
        this.end = () -> new InputWithPopulation(counter.getEnd(), frame);
        this.duration = () -> new RangeInput(frame.locator(counter.getDuration()));
    }

    @Override
    public List<Configuration> getConfigurations() {
        open();
        return List.of(
                Configuration.builder().name(Fields.duration).element(duration).build(),
                Configuration.builder().name(Fields.start).element(start).build(),
                Configuration.builder().name(Fields.end).element(end).build(),
                Configuration.builder().name(Fields.style).element(style).build()
        );
    }

    public void applyProperties(CounterTabProperties counter) {
        open();
        if (Objects.nonNull(counter.getStyle())) {
            style.get().set(counter.getStyle());
        }
        if (Objects.nonNull(counter.getDuration())) {
            duration.get().fill(counter.getDuration());
        }
        if (Objects.nonNull(counter.getEnd())) {
            end.get().setValue(counter.getEnd());
        }
        if (Objects.nonNull(counter.getStart())) {
            start.get().setValue(counter.getStart());
        }
    }

}
