package com.brizy.io.web.interactions.page.editor.container.components.toolbar.counter.tab;

import com.brizy.io.web.interactions.dto.editor.container.toolbar.counter.AdvancedCounterPropertyDto;
import com.brizy.io.web.interactions.element.TextInput;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.counter.tabs.AdvancedProperties;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AdvancedTab {

    Supplier<TextInput> prefix;
    Supplier<TextInput> suffix;
    Supplier<TextInput> separator;

    public AdvancedTab(AdvancedProperties advanced, Frame page) {
        this.prefix = () -> new TextInput(page.locator(advanced.getPrefix()));
        this.suffix = () -> new TextInput(page.locator(advanced.getSuffix()));
        this.separator = () -> new TextInput(page.locator(advanced.getSeparator()));
    }

    public AdvancedCounterPropertyDto getProperties() {
        return AdvancedCounterPropertyDto.builder()
                .prefix(prefix.get().getText())
                .suffix(suffix.get().getText())
                .separator(separator.get().getText())
                .build();
    }

}
