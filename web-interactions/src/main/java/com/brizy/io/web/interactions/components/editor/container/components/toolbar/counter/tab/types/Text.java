package com.brizy.io.web.interactions.components.editor.container.components.toolbar.counter.tab.types;

import com.brizy.io.web.common.dto.element.properties.counter.Counter;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.counter.CounterPropertyDto;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.counter.TextCounterPropertyDto;
import com.brizy.io.web.interactions.element.NumberInput;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.counter.CounterProperties;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.counter.tabs.CounterTabProperties;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Objects;
import java.util.function.Supplier;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.valueOf;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Text extends AdvancedCounter {

    Supplier<NumberInput> start;
    Supplier<NumberInput> end;
    Supplier<NumberInput> duration;

    public Text(CounterProperties counterProperties, Frame page) {
        super(counterProperties, page);
        CounterTabProperties counterTabProperties = counterProperties.getTabs().getCounter();
        this.start = () -> new NumberInput(page.locator(counterTabProperties.getStart()));
        this.end = () -> new NumberInput(page.locator(counterTabProperties.getEnd()));
        this.duration = () -> new NumberInput(page.locator(counterTabProperties.getDuration()));
    }

    @Override
    public void change(Counter counterProperties) {
        changeToStyle(counterProperties.getStyle());
    }

    @Override
    public CounterPropertyDto getProperties() {
        return TextCounterPropertyDto.builder()
                .start(valueOf(start.get().getText()))
                .end(valueOf(end.get().getText()))
                .duration(parseDouble(duration.get().getText()))
                .advanced(advanced().getProperties())
                .build();
    }

}
