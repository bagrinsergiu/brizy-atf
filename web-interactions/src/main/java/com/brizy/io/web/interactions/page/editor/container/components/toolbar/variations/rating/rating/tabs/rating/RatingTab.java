package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.rating.rating.tabs.rating;

import com.brizy.io.web.common.dto.element.properties.rating.rating.rating.RatingTabProperties;
import com.brizy.io.web.common.dto.element.properties.rating.rating.rating.enums.LabelPositions;
import com.brizy.io.web.common.dto.element.properties.rating.rating.rating.enums.RatingStyles;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.element.composite.InputWithPopulation;
import com.brizy.io.web.interactions.element.composite.InputWithUnits;
import com.brizy.io.web.interactions.element.composite.RadioControl;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.rating.tabs.rating.RatingTabLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractTabItem;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class RatingTab extends AbstractTabItem {

    Supplier<ComboBox> ratingScale;
    Supplier<RadioControl<RatingStyles>> style;
    Supplier<RadioControl<LabelPositions>> label;
    Supplier<InputWithUnits> spacing;
    Supplier<InputWithPopulation> rating;
    Supplier<Boolean> isRatingTabDisplayedOnPopUp;

    public RatingTab(RatingTabLocators ratingTabLocators, Frame frame) {
        super(ratingTabLocators.getConfigurations(), ratingTabLocators.getSelf(), frame);
        this.ratingScale = () -> new ComboBox(frame.locator(ratingTabLocators.getRatingScale()));
        this.style = () -> new RadioControl<>(RatingStyles.class, ratingTabLocators.getStyle(), frame);
        this.label = () -> new RadioControl<>(LabelPositions.class, ratingTabLocators.getLabel(), frame);
        this.spacing = () -> new InputWithUnits(ratingTabLocators.getSpacing(), frame);
        this.rating = () -> new InputWithPopulation(ratingTabLocators.getRating(), frame);
        this.isRatingTabDisplayedOnPopUp = () -> frame.locator(ratingTabLocators.getSelf()).count() > 0;
    }

    public void applyProperties(RatingTabProperties ratingTabProperties) {
        open();
        if (Objects.nonNull(ratingTabProperties.getRatingScale())) {
            ratingScale.get().selectItemByName(ratingTabProperties.getRatingScale());
        }
        if (Objects.nonNull(ratingTabProperties.getLabel())) {
            label.get().set(ratingTabProperties.getLabel());
        }
        if (Objects.nonNull(ratingTabProperties.getRating())) {
            rating.get().setValue(ratingTabProperties.getRating());
        }
        if (Objects.nonNull(ratingTabProperties.getStyle())) {
            style.get().set(ratingTabProperties.getStyle());
        }
        if (Objects.nonNull(ratingTabProperties.getSpacing())) {
            spacing.get().setValue(ratingTabProperties.getSpacing());
        }
    }

    public RatingTabProperties getProperties() {
        open();
        return RatingTabProperties.builder()
                .ratingScale(ratingScale.get().getSelectedItem())
                .style(style.get().getActiveControl())
                .label(label.get().getActiveControl())
                .rating(rating.get().getValue())
                .spacing(spacing.get().getValue())
                .build();
    }

    @Override
    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name(Fields.style).element(style).build(),
                Configuration.builder().name(Fields.spacing).element(spacing).build(),
                Configuration.builder().name(Fields.label).element(label).build(),
                Configuration.builder().name(Fields.rating).element(rating).build(),
                Configuration.builder().name("rating scale").element(ratingScale).build()
        );
    }

    @Override
    public void open() {
        if (isRatingTabDisplayedOnPopUp.get()) {
            super.open();
        }
    }

}
