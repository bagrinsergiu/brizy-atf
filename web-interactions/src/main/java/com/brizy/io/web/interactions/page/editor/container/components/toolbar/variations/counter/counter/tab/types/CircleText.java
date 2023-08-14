package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.counter.counter.tab.types;

import com.brizy.io.web.common.dto.element.properties.counter.Counter;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.counter.CircleTextCounterPropertyDto;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.counter.CounterPropertyDto;
import com.brizy.io.web.interactions.element.NumericInput;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.counter.CounterProperties;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.counter.tabs.CounterTabProperties;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.valueOf;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CircleText extends AdvancedCounter {

    Supplier<NumericInput> end;
    Supplier<NumericInput> duration;

    public CircleText(CounterProperties counterProperties, Frame page) {
        super(counterProperties, page);
        CounterTabProperties counterTabProperties = counterProperties.getTabs().getCounter();
        this.end = () -> new NumericInput(page.locator(counterTabProperties.getEnd()));
        this.duration = () -> new NumericInput(page.locator(counterTabProperties.getDuration()));
    }

    @Override
    public void change(Counter counterProperties) {
        changeToStyle(counterProperties.getStyle());
    }

    @Override
    public CounterPropertyDto getProperties() {
        return CircleTextCounterPropertyDto.builder()
                .end(valueOf(end.get().getText()))
                .duration(parseDouble(duration.get().getText()))
                .advanced(advanced().getProperties())
                .build();
    }
}
