package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.icon.background;

import com.brizy.io.web.common.dto.element.properties.common.fill.FillTypes;
import com.brizy.io.web.common.dto.element.properties.icon.tabs.background.BackgroundTabProperties;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.NumericInput;
import com.brizy.io.web.interactions.element.composite.RadioControl;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.icon.tabs.background.BackgroundLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractTabItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button.button.corner.Corner;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class BackgroundTab extends AbstractTabItem {

    Supplier<NumericInput> size;
    Supplier<RadioControl<FillTypes>> fill;
    Supplier<Corner> corner;

    public BackgroundTab(BackgroundLocators buttonLocators, Frame frame) {
        super(buttonLocators.getConfigurations(), buttonLocators.getSelf(), frame);
        this.size = () -> new NumericInput(frame.locator(buttonLocators.getSize().getValue()));
        this.fill = () -> new RadioControl<>(FillTypes.class, buttonLocators.getFill(), frame);
        this.corner = () -> new Corner(buttonLocators.getCorner(), frame);
    }

    public void applyProperties(BackgroundTabProperties propertiesToApply) {
        open();
        size.get().fill(propertiesToApply.getSize());
        fill.get().set(propertiesToApply.getFill());
        corner.get().applyProperties(propertiesToApply.getCorner());
    }

    public BackgroundTabProperties getProperties() {
        open();
        return BackgroundTabProperties.builder()
                .corner(corner.get().getProperties())
                .fill(fill.get().getActiveControl())
                .size(Integer.valueOf(size.get().getText()))
                .build();
    }

    @Override
    public List<Configuration> getConfigurations() {
        var listOfConfigurations = new ArrayList<Configuration>() {{
            add(Configuration.builder().name(Fields.fill).element(fill).build());
            add(Configuration.builder().name(Fields.size).element(size).build());
        }};
        var itemsWereAdded = listOfConfigurations.addAll(corner.get().getConfigurations());
        log.debug("Items from complex corner element were added {}", itemsWereAdded);
        return listOfConfigurations;
    }

}
