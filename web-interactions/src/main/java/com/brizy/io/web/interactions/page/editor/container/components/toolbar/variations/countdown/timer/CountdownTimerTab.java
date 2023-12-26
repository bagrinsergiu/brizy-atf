package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.countdown.timer;

import com.brizy.io.web.common.dto.element.properties.countdown.countdown.timer.CountdownTimerProperties;
import com.brizy.io.web.common.dto.element.properties.countdown.enums.CountdownStyles;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.element.composite.DropdownWithPopulation;
import com.brizy.io.web.interactions.element.composite.InputWithPopulation;
import com.brizy.io.web.interactions.element.composite.RadioControl;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.countdown.tabs.timer.TimerLocators;
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
public class CountdownTimerTab extends AbstractTabItem {

    Supplier<RadioControl<CountdownStyles>> styles;
    Supplier<InputWithPopulation> date;
    Supplier<DropdownWithPopulation> hour;
    Supplier<DropdownWithPopulation> minutes;
    Supplier<ComboBox> timeZone;

    public CountdownTimerTab(TimerLocators timerLocators, Frame frame) {
        super(timerLocators.getConfigurations(), timerLocators.getSelf(), frame);
        this.styles = () -> new RadioControl<>(CountdownStyles.class, timerLocators.getStyle(), frame);
        this.date = () -> new InputWithPopulation(timerLocators.getDate(), frame);
        this.hour = () -> new DropdownWithPopulation(timerLocators.getHour(), frame);
        this.minutes = () -> new DropdownWithPopulation(timerLocators.getMinutes(), frame);
        this.timeZone = () -> new ComboBox(frame.locator(timerLocators.getTimeZone()));
    }

    @Override
    public List<Configuration> getConfigurations() {
        open();
        return List.of(
                Configuration.builder().name(Fields.styles).element(styles).build(),
                Configuration.builder().name(Fields.date).element(date).build(),
                Configuration.builder().name(Fields.hour).element(hour).build(),
                Configuration.builder().name(Fields.minutes).element(minutes).build(),
                Configuration.builder().name("time zone").element(timeZone).build()
        );
    }

    public CountdownTimerProperties getProperties() {
        open();
        return CountdownTimerProperties.builder()
                .style(styles.get().getActiveControl())
                .date(date.get().getValue())
                .hour(hour.get().getValue())
                .minutes(minutes.get().getValue())
                .timeZone(timeZone.get().getSelectedItem())
                .build();
    }

    public void applyProperties(CountdownTimerProperties countdownTimerProperties) {
        open();
        if (Objects.nonNull(countdownTimerProperties.getStyle())) {
            styles.get().set(countdownTimerProperties.getStyle());
        }
        if (Objects.nonNull(countdownTimerProperties.getDate())) {
            date.get().setValue(countdownTimerProperties.getDate());
        }
        if (Objects.nonNull(countdownTimerProperties.getHour())) {
            hour.get().setValue(countdownTimerProperties.getHour());
        }
        if (Objects.nonNull(countdownTimerProperties.getMinutes())) {
            minutes.get().setValue(countdownTimerProperties.getMinutes());
        }
        if (Objects.nonNull(countdownTimerProperties.getTimeZone())) {
            timeZone.get().selectItemByName(countdownTimerProperties.getTimeZone());
        }
    }
}
