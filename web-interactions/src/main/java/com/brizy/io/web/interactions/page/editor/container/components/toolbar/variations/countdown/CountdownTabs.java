package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.countdown;

import com.brizy.io.web.common.dto.element.properties.countdown.countdown.Countdown;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.countdown.CountdownLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.countdown.tabs.CountdownTabsLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsPopUpTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.countdown.advanced.AdvancedCountdownTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.countdown.timer.CountdownTimerTab;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.Objects;
import java.util.function.Supplier;

import static io.vavr.API.*;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CountdownTabs extends AbstractToolbarItem {

    Supplier<CountdownTimerTab> timer;
    Supplier<AdvancedCountdownTab> advanced;

    public CountdownTabs(CountdownLocators countdown, Frame frame) {
        super(countdown.getSelf(), countdown.getTabs().getSelf(), frame);
        CountdownTabsLocators countdownTabsLocators = countdown.getTabs();
        this.advanced = () -> new AdvancedCountdownTab(countdownTabsLocators.getAdvanced(), frame);
        this.timer = () -> new CountdownTimerTab(countdownTabsLocators.getTimer(), frame);
    }

    @Override
    public IsPopUpTab openTab(String tab) {
        open();
        return Match(tab.toLowerCase()).of(
                Case($(Fields.timer), timer),
                Case($(Fields.advanced), advanced)
        );
    }

    public Countdown getProperties() {
        open();
        return Countdown.builder()
                .advanced(advanced.get().getProperties())
                .timer(timer.get().getProperties())
                .build();
    }

    public void applyProperties(Countdown propertiesCountdown) {
        open();
        if (Objects.nonNull(propertiesCountdown.getAdvanced())) {
            advanced.get().applyProperties(propertiesCountdown.getAdvanced());
        }
        if (Objects.nonNull(propertiesCountdown.getTimer())) {
            timer.get().applyProperties(propertiesCountdown.getTimer());
        }
    }

}
