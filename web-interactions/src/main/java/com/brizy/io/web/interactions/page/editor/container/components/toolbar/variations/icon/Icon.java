package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.icon;

import com.brizy.io.web.common.dto.element.properties.button.button.ButtonProperties;
import com.brizy.io.web.common.dto.element.properties.icon.tabs.IconProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.icon.IconLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.icon.tabs.IconTabsLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsPopUpTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button.button.ButtonTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.icon.background.BackgroundTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.icon.icon.IconTab;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.Objects;
import java.util.function.Supplier;

import static io.vavr.API.*;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Icon extends AbstractToolbarItem {

    @Getter
    Supplier<BackgroundTab> background;
    Supplier<com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.icon.icon.IconTab> icon;

    public Icon(IconLocators buttonLocators, Frame frame) {
        super(buttonLocators.getSelf(), buttonLocators.getTabs().getSelf(), frame);
        IconTabsLocators iconTabsLocators = buttonLocators.getTabs();
        this.background = () -> new BackgroundTab(iconTabsLocators.getBackground(), frame);
        this.icon = () -> new com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.icon.icon.IconTab(iconTabsLocators.getIcon(), frame);
    }

    public void applyProperties(IconProperties propertiesToApply) {
        open();
        if (Objects.nonNull(propertiesToApply.getBackground())) {
            background.get().applyProperties(propertiesToApply.getBackground());
        }
        if (Objects.nonNull(propertiesToApply.getIcon())) {
            icon.get().applyProperties(propertiesToApply.getIcon());
        }
    }

    @Override
    public IsPopUpTab openTab(String tab) {
        open();
        return Match(tab.toLowerCase()).of(
                Case($(Fields.background), () -> {
                    BackgroundTab backgroundTab = background.get();
                    backgroundTab.open();
                    return backgroundTab;
                }),
                Case($(Fields.icon), () -> {
                    IconTab iconTab = icon.get();
                    iconTab.open();
                    return iconTab;
                })
        );
    }

    public IconProperties getProperties() {
        open();
        return IconProperties.builder()
                .background(background.get().getProperties())
                .icon(icon.get().getProperties())
                .build();
    }

}
