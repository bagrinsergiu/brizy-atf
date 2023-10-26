package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations;

import com.brizy.io.web.common.dto.element.properties.button.ButtonProperties;
import com.brizy.io.web.common.dto.element.properties.common.align.Alignments;
import com.brizy.io.web.interactions.element.composite.EnumerableButton;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.ComponentToolbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.link.Link;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.SettingsScrollbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.colors.Colors;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.text.typography.Typography;
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
public class ButtonToolbar extends ComponentToolbar<ButtonProperties> {

    Supplier<com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button.Button> buttonItem;
    Supplier<Typography> typography;
    Supplier<Colors> colors;
    Supplier<EnumerableButton<Alignments>> align;
    Supplier<Link> link;
    Supplier<SettingsScrollbar> settings;

    public ButtonToolbar(ToolbarLocators toolbarLocators, Frame page) {
        super(toolbarLocators, page);
        var buttonLocators = toolbarLocators.getButton();
        this.buttonItem = () -> new com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button.Button(buttonLocators, page);
        this.typography = () -> new Typography(toolbarLocators.getTypography(), page);
        this.colors = () -> new Colors(toolbarLocators.getColors(), page);
        this.align = () -> new EnumerableButton<>(Alignments.class, toolbarLocators.getAlign(), page);
        this.link = () -> new Link(toolbarLocators.getLink(), page);
        this.settings = () -> new SettingsScrollbar(toolbarLocators.getSettings().getScrollBar(), page.page());
    }

    @Override
    public IsToolbarItem openTabbedPopup(String toolbarItemTitle) {
        return API.Match(toolbarItemTitle.toLowerCase()).of(
                API.Case($(ButtonToolbar.Fields.buttonItem), buttonItem.get()),
                API.Case($(ButtonToolbar.Fields.colors), () -> colors.get())
        );
    }

    @Override
    public void setProperties(ButtonProperties properties) {
        if (Objects.nonNull(properties.getButton())) {
            buttonItem.get().applyProperties(properties.getButton());
        }
        if (Objects.nonNull(properties.getTypography())) {
            typography.get().applyProperties(properties.getTypography());
        }
        if (Objects.nonNull(properties.getColors())) {
            colors.get().applyProperties(properties.getColors());
        }
        if (Objects.nonNull(properties.getLink())) {
            link.get().applyProperties(properties.getLink());
        }
        if (Objects.nonNull(properties.getAlign())) {
            align.get().setValue(properties.getAlign());
        }
        if (Objects.nonNull(properties.getSettings())) {
            openSettings();
            settings.get().applyProperties(properties.getSettings());
        }
    }

    @Override
    protected void openSettings() {
        super.openBorderButton();
        super.openSettings();
    }

    @Override
    public ButtonProperties getProperties() {
        ButtonProperties properties = ButtonProperties.builder()
                .align(align.get().getValue())
                .button(buttonItem.get().getProperties())
                .typography(typography.get().getProperties())
                .colors(colors.get().getProperties())
                .link(link.get().getProperties())
                .build();
        openSettings();
        properties = properties.toBuilder()
                .settings(settings.get().getProperties())
                .build();
        return properties;
    }
}