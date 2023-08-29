package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.map.settings;

import com.brizy.io.web.common.dto.element.properties.common.settings.CanHaveSettings;
import com.brizy.io.web.common.dto.element.properties.common.settings.Size;
import com.brizy.io.web.common.dto.element.properties.common.settings.UnitType;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.element.RangeInput;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.SettingsProperties;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.CustomizableSize;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

import static com.brizy.io.web.common.dto.element.properties.common.settings.Settings.builder;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Settings implements CustomizableSize {

    Supplier<RangeInput> width;
    Supplier<ComboBox> widthUnit;
    Supplier<RangeInput> height;
    Supplier<ComboBox> heightUnit;
    Supplier<Button> settingsButton;

    public Settings(SettingsProperties settingsProperties, Frame page) {
        this.settingsButton = () -> new Button(page.locator(settingsProperties.getSelf()));
        this.width = () -> new RangeInput(page.locator(settingsProperties.getWidth().getValue()));
        this.widthUnit = () -> new ComboBox(page.locator(settingsProperties.getWidth().getUnit().getSelf()));
        this.height = () -> new RangeInput(page.locator(settingsProperties.getHeight().getValue()));
        this.heightUnit = () -> new ComboBox(page.locator(settingsProperties.getHeight().getUnit().getSelf()));
    }

    @Override
    public void with(CanHaveSettings settingsToApply) {
        settingsButton.get().click();
        Size widthToApply = settingsToApply.getWidth();
        widthUnit.get().selectItemByName(widthToApply.getUnit().getValue());
        width.get().fill(widthToApply.getValue());
        Size heightToApply = settingsToApply.getHeight();
        heightUnit.get().selectItemByName(heightToApply.getUnit().getValue());
        height.get().fill(heightToApply.getValue());
    }

    public com.brizy.io.web.common.dto.element.properties.common.settings.Settings getProperties() {
        settingsButton.get().click();
        return builder()
                .height(Size.builder().unit(heightUnit.get().getSelectedItem().equalsIgnoreCase("px") ? UnitType.PIXEL : UnitType.PERCENTAGE).value(height.get().getValue()).build())
                .width(Size.builder().unit(widthUnit.get().getSelectedItem().equalsIgnoreCase("px") ? UnitType.PIXEL : UnitType.PERCENTAGE).value(width.get().getValue()).build())
                .build();
    }

}
