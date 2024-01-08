package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.carousel.pop_up;

import com.brizy.io.web.common.dto.element.properties.carousel.pop_up.CarouselPopUpProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.carousel.CarouselLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsPopUpTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.carousel.pop_up.tabs.carousel.CarouselTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.carousel.pop_up.tabs.navigation.NavigationTab;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.Objects;
import java.util.function.Supplier;

import static io.vavr.API.$;
import static io.vavr.API.Case;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CarouselPopUp extends AbstractToolbarItem {

    Supplier<CarouselTab> carousel;
    Supplier<NavigationTab> navigation;

    public CarouselPopUp(CarouselLocators carouselLocators, Frame frame) {
        super(carouselLocators.getSelf(), carouselLocators.getTabs().getSelf(), frame);
        this.carousel = () -> new CarouselTab(carouselLocators.getTabs().getCarousel(), frame);
        this.navigation = () -> new NavigationTab(carouselLocators.getTabs().getNavigation(), frame);
    }

    public void applyProperties(CarouselPopUpProperties carouselProperties) {
        open();
        if (Objects.nonNull(carouselProperties.getCarousel())) {
            carousel.get().applyProperties(carouselProperties.getCarousel());
        }
        if (Objects.nonNull(carouselProperties.getNavigation())) {
            navigation.get().applyProperties(carouselProperties.getNavigation());
        }
    }

    public CarouselPopUpProperties getProperties() {
        open();
        return CarouselPopUpProperties.builder()
                .carousel(carousel.get().getProperties())
                .navigation(navigation.get().getProperties())
                .build();
    }

    @Override
    public IsPopUpTab openTab(String tab) {
        return io.vavr.API.Match(tab.toLowerCase()).of(
                Case($(Fields.carousel), carousel),
                Case($(), navigation)
        );
    }
}
