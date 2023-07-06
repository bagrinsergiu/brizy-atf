package com.brizy.io.web.interactions.components.editor.container.components.toolbar.settings;

import com.brizy.io.web.common.dto.element.properties.toolbar.settings.Size;
import com.brizy.io.web.interactions.element.RangeInput;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.settings.SettingsProperties;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Settings implements CustomizableSize {

    Supplier<RangeInput> width;
    Supplier<UnitDropdown> widthUnit;
    Supplier<RangeInput> height;
    Supplier<UnitDropdown> heightUnit;

    public Settings(SettingsProperties settingsProperties, Frame page) {
        this.width = () -> new RangeInput(page.locator(settingsProperties.getWidth().getValue()));
        this.widthUnit = () -> new UnitDropdown(settingsProperties.getWidth().getUnit(), page);
        this.height = () -> new RangeInput(page.locator(settingsProperties.getHeight().getValue()));
        this.heightUnit = () -> new UnitDropdown(settingsProperties.getHeight().getUnit(), page);
    }

    @Override
    public void with(com.brizy.io.web.common.dto.element.properties.toolbar.settings.Settings settingsToApply) {
        Size widthToApply = settingsToApply.getWidth();
        width.get().fill(widthToApply.getValue());
        widthUnit.get().get().pickItem(widthToApply.getUnit().getValue());
        Size heightToApply = settingsToApply.getHeight();
        height.get().fill(heightToApply.getValue());
        heightUnit.get().get().pickItem(heightToApply.getUnit().getValue());
    }

}
