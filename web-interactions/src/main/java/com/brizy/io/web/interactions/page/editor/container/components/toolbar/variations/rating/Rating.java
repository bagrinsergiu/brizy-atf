package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.rating;

import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.rating.RatingLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsPopUpTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.rating.rating.tabs.icons.IconsTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.rating.rating.tabs.rating.RatingTab;
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
public class Rating extends AbstractToolbarItem {

    Supplier<RatingTab> rating;
    Supplier<IconsTab> icons;

    public Rating(RatingLocators ratingLocators, Frame frame) {
        super(ratingLocators.getSelf(), ratingLocators.getTabs().getSelf(), frame);
        this.rating = () -> new RatingTab(ratingLocators.getTabs().getRating(), frame);
        this.icons = () -> new IconsTab(ratingLocators.getTabs().getIcons(), frame);
    }

    public void applyProperties(com.brizy.io.web.common.dto.element.properties.rating.rating.Rating ratingProperties) {
        open();
        if (Objects.nonNull(ratingProperties.getRating())) {
            rating.get().applyProperties(ratingProperties.getRating());
        }
        if (Objects.nonNull(ratingProperties.getIcons())) {
            icons.get().applyProperties(ratingProperties.getIcons());
        }
    }

    public com.brizy.io.web.common.dto.element.properties.rating.rating.Rating getProperties() {
        open();
        return com.brizy.io.web.common.dto.element.properties.rating.rating.Rating.builder()
                .rating(rating.get().getProperties())
                .icons(icons.get().getProperties())
                .build();
    }

    @Override
    public IsPopUpTab openTab(String tab) {
        open();
        return io.vavr.API.Match(tab.toLowerCase()).of(
                Case($(value -> value.contains("icon")), icons),
                Case($(), rating)
        );
    }
}
