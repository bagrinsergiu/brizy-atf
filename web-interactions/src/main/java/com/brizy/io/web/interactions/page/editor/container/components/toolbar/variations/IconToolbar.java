package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations;

import com.brizy.io.web.common.dto.element.properties.common.align.Alignments;
import com.brizy.io.web.common.dto.element.properties.icon.IconProperties;
import com.brizy.io.web.interactions.element.composite.EnumerableButton;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.ComponentToolbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.link.Link;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.SettingsScrollbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.icon.Icon;
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
public class IconToolbar extends ComponentToolbar<IconProperties> {

    Supplier<Icon> icon;
    Supplier<Colors> colors;
    Supplier<EnumerableButton<Alignments>> align;
    Supplier<Link> link;
    Supplier<SettingsScrollbar> settings;

    public IconToolbar(ToolbarLocators toolbarLocators, Frame page) {
        super(toolbarLocators, page);
        var iconLocators = toolbarLocators.getIcon();
        this.icon = () -> new Icon(iconLocators, page);
        this.colors = () -> new Colors(toolbarLocators.getColors(), page);
        this.align = () -> new EnumerableButton<>(Alignments.class, toolbarLocators.getAlign(), page);
        this.link = () -> new Link(toolbarLocators.getLink(), page);
        this.settings = () -> new SettingsScrollbar(toolbarLocators.getSettings().getScrollBar(), page.page());
    }

    @Override
    public IsToolbarItem openTabbedPopup(String toolbarItemTitle) {
        return API.Match(toolbarItemTitle.toLowerCase()).of(
                API.Case($(IconToolbar.Fields.icon), icon),
                API.Case($(IconToolbar.Fields.colors), colors)
        );
    }

    @Override
    public IconProperties getProperties() {
        IconProperties properties = IconProperties.builder()
                .align(align.get().getValue())
                .icon(icon.get().getProperties())
                .colors(colors.get().getProperties())
                .link(link.get().getProperties())
                .build();
        openSettings();
        properties = properties.toBuilder()
                .settings(settings.get().getProperties())
                .build();
        return properties;
    }

    @Override
    public void setProperties(IconProperties properties) {
        if (Objects.nonNull(properties.getIcon())) {
            icon.get().applyProperties(properties.getIcon());
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

}