package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button.icon.popup;

import com.brizy.io.web.common.dto.element.properties.button.button.icon.picker.IconPickerProperties;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.button.tabs.icon.icon.IconPickerLocators;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class IconPicker {

    Supplier<Button> picker;
    Supplier<IconPopUp> iconPopUp;

    public IconPicker(IconPickerLocators iconPickerLocators, Frame frame) {
        this.picker = () -> new Button(frame.locator(iconPickerLocators.getPicker().getSelf()));
        this.iconPopUp = () -> new IconPopUp(iconPickerLocators.getPicker().getPopUp(), frame.page());
    }

    public void applyProperties(IconPickerProperties icon) {
        picker.get().click();
        iconPopUp.get().applyProperties(icon);
    }

    public IconPickerProperties getProperties() {
        picker.get().click();
        return iconPopUp.get().getProperties();
    }
}
