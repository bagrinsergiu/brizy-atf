package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.counter.counter.tab.types;

import com.brizy.io.web.common.dto.element.properties.counter.Counter;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.counter.CounterPropertyDto;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.counter.PieCounterPropertyDto;
import com.brizy.io.web.interactions.element.NumericInput;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.counter.counter.GenericCounter;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.counter.CounterProperties;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.counter.tabs.CounterTabProperties;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Pie extends GenericCounter {

    Supplier<NumericInput> end;
    Supplier<NumericInput> duration;

    public Pie(CounterProperties counter, Frame page) {
        super(counter, page);
        CounterTabProperties counterTabProperties = counter.getTabs().getCounter();
        this.end = () -> new NumericInput(page.locator(counterTabProperties.getEnd()));
        this.duration = () -> new NumericInput(page.locator(counterTabProperties.getDuration()));
    }

    @Override
    public void change(Counter counterProperties) {
        changeToStyle(counterProperties.getStyle());
    }

    @Override
    public CounterPropertyDto getProperties() {
        return PieCounterPropertyDto.builder()
                .duration(Double.parseDouble(duration.get().getText()))
                .end(Integer.parseInt(end.get().getText()))
                .build();
    }

}
