package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.carousel.pop_up.tabs.carousel;

import com.brizy.io.web.common.dto.element.properties.carousel.pop_up.tabs.carousel.AutoplayProperties;
import com.brizy.io.web.common.dto.element.properties.carousel.pop_up.tabs.carousel.CarouselTabProperties;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.Slider;
import com.brizy.io.web.interactions.element.composite.InputWithUnits;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.carousel.tabs.carousel.CarouselTabLocators;
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
public class CarouselTab extends AbstractTabItem {

    Supplier<Slider> autoplay;
    Supplier<InputWithUnits> speed;
    Supplier<InputWithUnits> stopTime;
    Supplier<InputWithUnits> columns;
    Supplier<InputWithUnits> spacing;

    public CarouselTab(CarouselTabLocators carouselTabLocators, Frame frame) {
        super(carouselTabLocators.getConfigurations(), carouselTabLocators.getSelf(), frame);
        this.autoplay = () -> new Slider(frame.locator(carouselTabLocators.getAutoplay()));
        this.speed = () -> new InputWithUnits(carouselTabLocators.getSpeed(), frame);
        this.stopTime = () -> new InputWithUnits(carouselTabLocators.getStopTime(), frame);
        this.columns = () -> new InputWithUnits(carouselTabLocators.getColumns(), frame);
        this.spacing = () -> new InputWithUnits(carouselTabLocators.getSpacing(), frame);
    }

    public void applyProperties(CarouselTabProperties carouselTabProperties) {
        open();
        if (Objects.nonNull(carouselTabProperties.getAutoplay())) {
            var autoplayProperties = carouselTabProperties.getAutoplay();
            if (Objects.nonNull(autoplayProperties.getState())) {
                autoplay.get().switchTo(autoplayProperties.getState());
            }
            if (Objects.nonNull(autoplayProperties.getSpeed())) {
                speed.get().setValue(autoplayProperties.getSpeed());
            }
            if (Objects.nonNull(autoplayProperties.getStopTime())) {
                stopTime.get().setValue(autoplayProperties.getStopTime());
            }
        }
        if (Objects.nonNull(carouselTabProperties.getSpacing())) {
            spacing.get().setValue(carouselTabProperties.getSpacing());
        }
        if (Objects.nonNull(carouselTabProperties.getColumns())) {
            columns.get().setValue(carouselTabProperties.getColumns());
        }
    }

    public CarouselTabProperties getProperties() {
        open();
        return CarouselTabProperties.builder()
                .autoplay(AutoplayProperties.builder()
                        .state(autoplay.get().getState())
                        .speed(speed.get().getValue())
                        .stopTime(stopTime.get().getValue())
                        .build())
                .columns(columns.get().getValue())
                .spacing(spacing.get().getValue())
                .build();
    }

    @Override
    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name(Fields.autoplay).element(autoplay).build(),
                Configuration.builder().name(Fields.speed).element(speed).build(),
                Configuration.builder().name(Fields.stopTime).element(stopTime).build(),
                Configuration.builder().name(Fields.columns).element(columns).build(),
                Configuration.builder().name(Fields.spacing).element(spacing).build()
        );
    }

}
