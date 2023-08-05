package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.counter.counter.tab.types;

import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.counter.counter.GenericCounter;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.counter.counter.enums.Types;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.counter.counter.tab.Style;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.counter.CounterProperties;
import com.microsoft.playwright.Frame;
import io.vavr.API;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CountersFactory {

    CounterProperties properties;
    Frame frame;

    public static CountersFactory of(CounterProperties counter, Frame frame) {
        return new CountersFactory(counter, frame);
    }

    public GenericCounter getCounter() {
        Types selected = new Style(properties.getTabs().getCounter(), frame).getSelected();
        return API.Match(selected).of(
                API.Case(API.$(Types.TEXT), () -> new Text(properties, frame)),
                API.Case(API.$(Types.CIRCLE_TEXT), () -> new CircleText(properties, frame)),
                API.Case(API.$(Types.CIRCLE), () -> new Circle(properties, frame)),
                API.Case(API.$(Types.PIE), () -> new Pie(properties, frame))
        );
    }

}
