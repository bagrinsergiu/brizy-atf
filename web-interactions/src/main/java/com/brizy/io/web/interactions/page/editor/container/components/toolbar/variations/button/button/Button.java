package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button;

import com.brizy.io.web.common.dto.element.properties.button.button.ButtonProperties;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.IsTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.HasTabs;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button.button.ButtonTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button.icon.IconTab;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.button.ButtonLocators;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.button.tabs.TabsProperties;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.Objects;
import java.util.function.Supplier;

import static io.vavr.API.*;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Button implements HasTabs {

    @Getter
    Supplier<Locator> tabsLocator;
    Supplier<ButtonTab> button;
    Supplier<IconTab> icon;
    Supplier<com.brizy.io.web.interactions.element.Button> buttonElementButton;

    public Button(ButtonLocators buttonLocators, Frame frame) {
        TabsProperties tabsProperties = buttonLocators.getTabs();
        this.buttonElementButton = () -> new com.brizy.io.web.interactions.element.Button(frame.locator(buttonLocators.getSelf()));
        this.tabsLocator = () -> frame.locator(tabsProperties.getSelf());
        this.button = () -> new ButtonTab(tabsProperties.getButton(), frame);
        this.icon = () -> new IconTab(tabsProperties.getIcon(), frame);
    }

    public void applyProperties(ButtonProperties propertiesToApply) {
        buttonElementButton.get().click();
        if (Objects.nonNull(propertiesToApply.getButton())) {
            button.get().applyProperties(propertiesToApply.getButton());
        }
        if (Objects.nonNull(propertiesToApply.getIcon())) {
            icon.get().applyProperties(propertiesToApply.getIcon());
        }
    }

    @Override
    public IsTab openTab(String tab) {
        return Match(tab.toLowerCase()).of(
                Case($(Fields.button), () -> {
                    ButtonTab buttonTab = button.get();
                    buttonTab.open();
                    return buttonTab;
                }),
                Case($(Fields.icon), () -> {
                    icon.get().open();
                    return icon.get();
                })
        );
    }

    public ButtonProperties getProperties() {
        buttonElementButton.get().click();
        return ButtonProperties.builder()
                .button(button.get().getProperties())
                .icon(icon.get().getProperties())
                .build();
    }

}
