package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations;

import com.brizy.io.web.common.dto.element.properties.common.align.Alignments;
import com.brizy.io.web.common.dto.element.properties.rating.RatingProperties;
import com.brizy.io.web.interactions.element.composite.EnumerableButton;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.Toolbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.colors.Colors;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.map.settings.Settings;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.rating.Rating;
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
public class RatingToolbar extends Toolbar<RatingProperties> {

    Supplier<Rating> rating;
    Supplier<Colors> colors;
    Supplier<Settings> settingsMenu;
    Supplier<EnumerableButton<Alignments>> align;

    public RatingToolbar(ToolbarLocators properties, Frame frame) {
        super(properties, frame);
        this.rating = () -> new Rating(properties.getRating(), frame);
        this.colors = () -> new Colors(properties.getColors(), frame);
        this.settingsMenu = () -> new Settings(properties.getSettings(), frame);
        this.align = () -> new EnumerableButton<>(Alignments.class, properties.getAlign(), frame);
    }

    @Override
    public RatingProperties getProperties() {
        return RatingProperties.builder()
                .rating(rating.get().getProperties())
                .build();
    }

    @Override
    public void setProperties(RatingProperties properties) {
        if (Objects.nonNull(properties.getRating())) {
            rating.get().applyProperties(properties.getRating());
        }
    }

    @Override
    public IsToolbarItem openTabbedPopup(String toolbarItemTitle) {
        return API.Match(toolbarItemTitle.toLowerCase()).of(
                API.Case($(Fields.rating), rating),
                API.Case($(Fields.colors), colors)
        );
    }

}