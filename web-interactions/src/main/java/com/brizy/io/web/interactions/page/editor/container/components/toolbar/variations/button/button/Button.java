package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button;

import com.brizy.io.web.common.dto.element.properties.button.button.ButtonProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.button.ButtonLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.button.tabs.ButtonTabsLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsPopUpTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button.button.ButtonTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button.icon.IconTab;
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
public class Button extends AbstractToolbarItem {

    @Getter
    Supplier<ButtonTab> button;
    Supplier<IconTab> icon;

    public Button(ButtonLocators buttonLocators, Frame frame) {
        super(buttonLocators.getSelf(), buttonLocators.getTabs().getSelf(), frame);
        ButtonTabsLocators buttonTabsLocators = buttonLocators.getTabs();
        this.button = () -> new ButtonTab(buttonTabsLocators.getButton(), frame);
        this.icon = () -> new IconTab(buttonTabsLocators.getIcon(), frame);
    }

    public void applyProperties(ButtonProperties propertiesToApply) {
        open();
        if (Objects.nonNull(propertiesToApply.getButton())) {
            button.get().applyProperties(propertiesToApply.getButton());
        }
        if (Objects.nonNull(propertiesToApply.getIcon())) {
            icon.get().applyProperties(propertiesToApply.getIcon());
        }
    }

    @Override
    public IsPopUpTab openTab(String tab) {
        open();
        return Match(tab.toLowerCase()).of(
                Case($(Fields.button), () -> {
                    ButtonTab buttonTab = button.get();
                    buttonTab.open();
                    return buttonTab;
                }),
                Case($(Fields.icon), () -> {
                    IconTab iconTab = icon.get();
                    iconTab.open();
                    return iconTab;
                })
        );
    }

    public ButtonProperties getProperties() {
        open();
        return ButtonProperties.builder()
                .button(button.get().getProperties())
                .icon(icon.get().getProperties())
                .build();
    }

}
