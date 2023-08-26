package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.counter.counter.tab;

import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.counter.counter.enums.Types;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.counter.tabs.CounterLocators;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Style {

    Supplier<Map<Types, Locator>> styles;
    Supplier<Locator> stylesParent;

    public Style(CounterLocators counter, Frame page) {
        stylesParent = () -> page.locator(counter.getStyle());
        styles = () -> new HashMap<>() {{
            List<Locator> all = stylesParent.get().all();
            put(Types.TEXT, all.get(0));
            put(Types.CIRCLE_TEXT, all.get(1));
            put(Types.CIRCLE, all.get(2));
            put(Types.PIE, all.get(3));
        }};
    }

    public void change(Types typeToChange) {
        styles.get().get(typeToChange).click();
    }

    public Types getSelected() {
        return styles.get().entrySet().stream()
                .filter(entry -> entry.getValue().getAttribute("class").contains("!bg-brand-primary"))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(Types.TEXT);
    }

}
