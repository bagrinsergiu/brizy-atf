package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.counter.counter.tab;

import com.brizy.io.web.common.dto.element.properties.counter.defaults.CounterAdvancedProperties;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.composite.InputWithPopulation;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.counter.tabs.AdvancedCounterLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractTabItem;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AdvancedTab extends AbstractTabItem {

    Supplier<InputWithPopulation> prefix;
    Supplier<InputWithPopulation> suffix;
    Supplier<InputWithPopulation> separator;

    public AdvancedTab(AdvancedCounterLocators advancedTabLocators, Frame frame) {
        super(advancedTabLocators.getConfigurations(), advancedTabLocators.getSelf(), frame);
        this.prefix = () -> new InputWithPopulation(advancedTabLocators.getPrefix(), frame);
        this.suffix = () -> new InputWithPopulation(advancedTabLocators.getSuffix(), frame);
        this.separator = () -> new InputWithPopulation(advancedTabLocators.getSeparator(), frame);
    }

    @Override
    public List<Configuration> getConfigurations() {
        open();
        return List.of(
                Configuration.builder().name(Fields.prefix).element(prefix).build(),
                Configuration.builder().name(Fields.separator).element(separator).build(),
                Configuration.builder().name(Fields.suffix).element(suffix).build()
        );
    }

    public CounterAdvancedProperties getProperties() {
        open();
        return CounterAdvancedProperties.builder()
                .prefix(prefix.get().getValue())
                .suffix(suffix.get().getValue())
                .separator(separator.get().getValue())
                .build();
    }

    public void applyProperties(CounterAdvancedProperties counterAdvancedProperties) {
        open();
        if (Objects.nonNull(counterAdvancedProperties.getPrefix())) {
            prefix.get().setValue(counterAdvancedProperties.getPrefix());
        }
        if (Objects.nonNull(counterAdvancedProperties.getSeparator())) {
            separator.get().setValue(counterAdvancedProperties.getSeparator());
        }
        if (Objects.nonNull(counterAdvancedProperties.getSuffix())) {
            suffix.get().setValue(counterAdvancedProperties.getSuffix());
        }
    }
}
