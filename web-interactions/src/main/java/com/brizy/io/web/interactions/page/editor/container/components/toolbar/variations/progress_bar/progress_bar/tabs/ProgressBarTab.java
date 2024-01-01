package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.progress_bar.progress_bar.tabs;

import com.brizy.io.web.common.dto.element.properties.progress_bar.enums.ProgressBarStyles;
import com.brizy.io.web.common.dto.element.properties.progress_bar.progress_bar.progress_bar.ProgressBarTabProperties;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.Slider;
import com.brizy.io.web.interactions.element.composite.InputWithPopulation;
import com.brizy.io.web.interactions.element.composite.RadioControl;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.progress.tabs.progress.ProgressTabLocators;
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
public class ProgressBarTab extends AbstractTabItem {

    Supplier<RadioControl<ProgressBarStyles>> style;
    Supplier<InputWithPopulation> fill;
    Supplier<Slider> title;
    Supplier<Slider> percentage;

    public ProgressBarTab(ProgressTabLocators progressTabLocators, Frame frame) {
        super(progressTabLocators.getConfigurations(), progressTabLocators.getSelf(), frame);
        this.style = () -> new RadioControl<>(ProgressBarStyles.class, progressTabLocators.getStyle(), frame);
        this.fill = () -> new InputWithPopulation(progressTabLocators.getFill(), frame);
        this.title = () -> new Slider(frame.locator(progressTabLocators.getTitle()));
        this.percentage = () -> new Slider(frame.locator(progressTabLocators.getPercentage()));
    }

    @Override
    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name(Fields.style).element(style).build(),
                Configuration.builder().name(Fields.fill).element(fill).build(),
                Configuration.builder().name(Fields.title).element(title).build(),
                Configuration.builder().name(Fields.percentage).element(percentage).build()
        );
    }

    public ProgressBarTabProperties getProperties() {
        open();
        return ProgressBarTabProperties.builder()
                .style(style.get().getActiveControl())
                .fill(fill.get().getValue())
                .title(title.get().getState())
                .percentage(percentage.get().getState())
                .build();
    }

    public void setProperties(ProgressBarTabProperties progressBarProperties) {
        open();
        if (Objects.nonNull(progressBarProperties.getFill())) {
            fill.get().setValue(progressBarProperties.getFill());
        }
        if (Objects.nonNull(progressBarProperties.getStyle())) {
            style.get().set(progressBarProperties.getStyle());
        }
        if (Objects.nonNull(progressBarProperties.getTitle())) {
            title.get().switchTo(progressBarProperties.getTitle());
        }
        if (Objects.nonNull(progressBarProperties.getPercentage())) {
            percentage.get().switchTo(progressBarProperties.getPercentage());
        }
    }
}
