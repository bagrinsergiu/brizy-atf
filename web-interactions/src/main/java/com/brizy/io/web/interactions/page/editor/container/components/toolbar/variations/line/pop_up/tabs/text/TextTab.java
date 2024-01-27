package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.line.pop_up.tabs.text;

import com.brizy.io.web.common.dto.element.properties.line.pop_up.tabs.common.LineAlign;
import com.brizy.io.web.common.dto.element.properties.line.pop_up.tabs.text.TextTabProperties;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.composite.InputWithUnits;
import com.brizy.io.web.interactions.element.composite.RadioControl;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.line.tabs.text.TextTabLocators;
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
public class TextTab extends AbstractTabItem {

    Supplier<RadioControl<LineAlign>> align;
    Supplier<InputWithUnits> spacing;

    public TextTab(TextTabLocators lineTabLocators, Frame frame) {
        super(lineTabLocators.getConfigurations(), lineTabLocators.getSelf(), frame);
        this.align = () -> new RadioControl<>(LineAlign.class, lineTabLocators.getAlign(), frame);
        this.spacing = () -> new InputWithUnits(lineTabLocators.getSpacing(), frame);
    }

    public void applyProperties(TextTabProperties lineTabProperties) {
        open();
        if (Objects.nonNull(lineTabProperties.getAlign())) {
            align.get().set(lineTabProperties.getAlign());
        }
        if (Objects.nonNull(lineTabProperties.getSpacing())) {
            spacing.get().setValue(lineTabProperties.getSpacing());
        }
    }

    public TextTabProperties getProperties() {
        open();
        return TextTabProperties.builder()
                .align(align.get().getActiveControl())
                .spacing(spacing.get().getValue())
                .build();
    }

    @Override
    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name(Fields.align).element(align).build(),
                Configuration.builder().name(Fields.spacing).element(spacing).build()
        );
    }

}
