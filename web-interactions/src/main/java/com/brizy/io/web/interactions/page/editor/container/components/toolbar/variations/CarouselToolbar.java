package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations;

import com.brizy.io.web.common.dto.element.properties.carousel.CarouselProperties;
import com.brizy.io.web.common.dto.element.properties.common.settings.pop_up.SettingsWithWidthEffectsAndStylingProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.Toolbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.pop_up.SettingsPopUp;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.pop_up.SettingsWithWidthEffectsAndStyling;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.carousel.pop_up.CarouselPopUp;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.colors.Colors;
import com.microsoft.playwright.Frame;
import io.vavr.API;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.Objects;
import java.util.function.Supplier;

import static io.vavr.API.$;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@FieldNameConstants
public class CarouselToolbar extends Toolbar<CarouselProperties> {

    Supplier<CarouselPopUp> carousel;
    Supplier<Colors> colors;
    Supplier<SettingsPopUp<SettingsWithWidthEffectsAndStylingProperties>> settings;

    public CarouselToolbar(ToolbarLocators toolbarLocators, Frame frame) {
        super(toolbarLocators, frame);
        this.carousel = () -> new CarouselPopUp(toolbarLocators.getCarousel(), frame);
        this.colors = () -> new Colors(toolbarLocators.getColors(), frame);
        this.settings = () -> new SettingsWithWidthEffectsAndStyling(toolbarLocators.getSettings(), frame);
    }

    @Override
    public CarouselProperties getProperties() {
        return CarouselProperties.builder()
                .carousel(carousel.get().getProperties())
                .build();
    }

    @Override
    public void setProperties(CarouselProperties properties) {
        if (Objects.nonNull(properties.getCarousel())) {
            carousel.get().applyProperties(properties.getCarousel());
        }
        if (Objects.nonNull(properties.getSettings())) {
            settings.get().setProperties(properties.getSettings());
        }
    }

    @Override
    public IsToolbarItem openTabbedPopup(String toolbarItemTitle) {
        return API.Match(toolbarItemTitle.toLowerCase()).of(
                API.Case($(Fields.carousel), carousel),
                API.Case($(Fields.colors), colors),
                API.Case($(Fields.settings), settings)
        );
    }

}