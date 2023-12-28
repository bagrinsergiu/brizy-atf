package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.countdown.advanced;

import com.brizy.io.web.common.dto.element.properties.countdown.countdown.advanced.CountdownAdvancedProperties;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.Slider;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.countdown.tabs.advanced.AdvancedLocators;
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
public class AdvancedCountdownTab extends AbstractTabItem {

    Supplier<Slider> days;
    Supplier<Slider> hours;
    Supplier<Slider> minutes;
    Supplier<Slider> seconds;

    public AdvancedCountdownTab(AdvancedLocators advancedLocators, Frame frame) {
        super(advancedLocators.getConfigurations(), advancedLocators.getSelf(), frame);
        this.days = () -> new Slider(frame.locator(advancedLocators.getDays()));
        this.hours = () -> new Slider(frame.locator(advancedLocators.getHours()));
        this.minutes = () -> new Slider(frame.locator(advancedLocators.getMinutes()));
        this.seconds = () -> new Slider(frame.locator(advancedLocators.getSeconds()));
    }

    @Override
    public List<Configuration> getConfigurations() {
        open();
        return List.of(
                Configuration.builder().name(Fields.days).element(days).build(),
                Configuration.builder().name(Fields.hours).element(hours).build(),
                Configuration.builder().name(Fields.minutes).element(minutes).build(),
                Configuration.builder().name(Fields.seconds).element(seconds).build()
        );
    }

    public CountdownAdvancedProperties getProperties() {
        open();
        return CountdownAdvancedProperties.builder()
                .days(days.get().getState())
                .hours(hours.get().getState())
                .minutes(minutes.get().getState())
                .seconds(seconds.get().getState())
                .build();
    }

    public void applyProperties(CountdownAdvancedProperties countdownAdvancedProperties) {
        open();
        if (Objects.nonNull(countdownAdvancedProperties.getDays())) {
            days.get().switchTo(countdownAdvancedProperties.getDays());
        }
        if (Objects.nonNull(countdownAdvancedProperties.getHours())) {
            hours.get().switchTo(countdownAdvancedProperties.getHours());
        }
        if (Objects.nonNull(countdownAdvancedProperties.getMinutes())) {
            minutes.get().switchTo(countdownAdvancedProperties.getMinutes());
        }
        if (Objects.nonNull(countdownAdvancedProperties.getSeconds())) {
            seconds.get().switchTo(countdownAdvancedProperties.getSeconds());
        }
    }

}


