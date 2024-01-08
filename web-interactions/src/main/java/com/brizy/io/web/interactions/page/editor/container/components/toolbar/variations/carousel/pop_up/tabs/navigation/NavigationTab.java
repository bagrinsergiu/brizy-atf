package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.carousel.pop_up.tabs.navigation;

import com.brizy.io.web.common.dto.element.properties.carousel.pop_up.tabs.navigation.NavigationTabProperties;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.element.composite.InputWithUnits;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.carousel.tabs.navigation.NavigationTabLocators;
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
public class NavigationTab extends AbstractTabItem {

    Supplier<ComboBox> arrows;
    Supplier<InputWithUnits> spacing;
    Supplier<ComboBox> dots;

    public NavigationTab(NavigationTabLocators navigationTabLocators, Frame frame) {
        super(navigationTabLocators.getConfigurations(), navigationTabLocators.getSelf(), frame);
        this.arrows = () -> new ComboBox(frame.locator(navigationTabLocators.getArrows()));
        this.dots = () -> new ComboBox(frame.locator(navigationTabLocators.getDots()));
        this.spacing = () -> new InputWithUnits(navigationTabLocators.getSpacing(), frame);
    }

    public void applyProperties(NavigationTabProperties navigationTabProperties) {
        open();
        if (Objects.nonNull(navigationTabProperties.getArrows())) {
            arrows.get().selectItemByName(navigationTabProperties.getArrows());
        }
        if (Objects.nonNull(navigationTabProperties.getDots())) {
            dots.get().selectItemByName(navigationTabProperties.getDots());
        }
        if (Objects.nonNull(navigationTabProperties.getSpacing())) {
            spacing.get().setValue(navigationTabProperties.getSpacing());
        }
    }

    public NavigationTabProperties getProperties() {
        open();
        return NavigationTabProperties.builder()
                .spacing(spacing.get().getValue())
                .arrows(arrows.get().getSelectedItem())
                .dots(dots.get().getSelectedItem())
                .build();
    }

    @Override
    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name(Fields.arrows).element(arrows).build(),
                Configuration.builder().name(Fields.dots).element(dots).build(),
                Configuration.builder().name(Fields.spacing).element(spacing).build()
        );
    }

}
