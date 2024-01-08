package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.line.pop_up.tabs.line;

import com.brizy.io.web.common.dto.element.properties.line.pop_up.tabs.line.LineStyles;
import com.brizy.io.web.common.dto.element.properties.line.pop_up.tabs.line.LineTabProperties;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.element.composite.InputWithUnits;
import com.brizy.io.web.interactions.element.composite.RadioControl;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.line.tabs.line.LineTabLocators;
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
public class LineTab extends AbstractTabItem {

    Supplier<RadioControl<LineStyles>> style;
    Supplier<ComboBox> type;
    Supplier<InputWithUnits> height;

    public LineTab(LineTabLocators lineTabLocators, Frame frame) {
        super(lineTabLocators.getConfigurations(), lineTabLocators.getSelf(), frame);
        this.type = () -> new ComboBox(frame.locator(lineTabLocators.getType()));
        this.style = () -> new RadioControl<>(LineStyles.class, lineTabLocators.getStyle(), frame);
        this.height = () -> new InputWithUnits(lineTabLocators.getHeight(), frame);
    }

    @Override
    public List<String> getWebConfigurations() {
        return getWebConfigurationsWithoutOpening();
    }

    public void applyProperties(LineTabProperties lineTabProperties) {
        if (Objects.nonNull(lineTabProperties.getHeight())) {
            height.get().setValue(lineTabProperties.getHeight());
        }
        if (Objects.nonNull(lineTabProperties.getType())) {
            type.get().selectItemByValue(lineTabProperties.getType());
        }
        if (Objects.nonNull(lineTabProperties.getStyle())) {
            style.get().set(lineTabProperties.getStyle());
        }
    }

    public LineTabProperties getProperties() {
        return LineTabProperties.builder()
                .height(height.get().getValue())
                .style(style.get().getActiveControl())
                .type(type.get().getValueForSelectedItem())
                .build();
    }

    @Override
    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name(Fields.type).element(type).build(),
                Configuration.builder().name(Fields.style).element(style).build(),
                Configuration.builder().name(Fields.height).element(height).build()
        );
    }

}
