package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations;

import com.brizy.io.web.common.dto.element.properties.common.align.Alignments;
import com.brizy.io.web.common.dto.element.properties.common.settings.pop_up.SettingsWithWidthEffectsAndStylingProperties;
import com.brizy.io.web.common.dto.element.properties.lottie.LottieProperties;
import com.brizy.io.web.interactions.element.composite.EnumerableButton;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.Toolbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.pop_up.SettingsPopUp;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.pop_up.SettingsWithWidthEffectsAndStyling;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.colors.Colors;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.lottie.Lottie;
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
public class LottieToolbar extends Toolbar<LottieProperties> {

    Supplier<Lottie> lottie;
    Supplier<Colors> colors;
    Supplier<SettingsPopUp<SettingsWithWidthEffectsAndStylingProperties>> settings;
    Supplier<EnumerableButton<Alignments>> align;

    public LottieToolbar(ToolbarLocators toolbarLocators, Frame frame) {
        super(toolbarLocators, frame);
        this.lottie = () -> new Lottie(toolbarLocators.getLottie(), frame);
        this.colors = () -> new Colors(toolbarLocators.getColors(), frame);
        this.settings = () -> new SettingsWithWidthEffectsAndStyling(toolbarLocators.getSettings(), frame);
        this.align = () -> new EnumerableButton<>(Alignments.class, toolbarLocators.getAlign(), frame);
    }

    @Override
    public LottieProperties getProperties() {
        return LottieProperties.builder()
                .align(align.get().getValue())
                .lottie(lottie.get().getProperties())
                .settings(settings.get().getProperties())
                .build();
    }

    @Override
    public void setProperties(LottieProperties properties) {
        if (Objects.nonNull(properties.getLottie())) {
            lottie.get().applyProperties(properties.getLottie());
        }
        if (Objects.nonNull(properties.getSettings())) {
            settings.get().setProperties(properties.getSettings());
        }
        if (Objects.nonNull(properties.getAlign())) {
            align.get().setValue(properties.getAlign());
        }
    }

    @Override
    public IsToolbarItem openTabbedPopup(String toolbarItemTitle) {
        return API.Match(toolbarItemTitle.toLowerCase()).of(
                API.Case($(Fields.lottie), lottie)
        );
    }

}