package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.image.mask.size;

import com.brizy.io.web.common.dto.element.properties.image.image.mask.size.CustomSize;
import com.brizy.io.web.common.dto.element.properties.image.image.mask.size.Size;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.image.tabs.mask.MaskLocators;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Custom extends AbstractFitSize {

    Supplier<SizeInput> size;

    public Custom(MaskLocators mask, Frame frame) {
        super(mask, frame);
        this.size = () -> new SizeInput(mask.getSize(), frame);
    }

    @Override
    public void applyProperties(Size size) {
        CustomSize customSize = (CustomSize) size;
        selectPosition(customSize.getPosition());
        selectRepeat(customSize.getRepeat());
        if (Objects.nonNull(customSize.getFill())) {
            this.size.get().setValue(customSize.getFill());
        }
    }

    public List<Configuration> getConfigurations() {
        List<Configuration> sizeConfigurations = size.get().getConfigurations();
        List<Configuration> customConfigurations = List.of(
                Configuration.builder().name(Fields.repeat).element(repeat).build(),
                Configuration.builder().name(AbstractSize.Fields.position).element(position).build()
        );
        sizeConfigurations.addAll(customConfigurations);
        return sizeConfigurations;
    }

    public CustomSize getProperties() {
        return CustomSize.builder()
                .fill(size.get().getValue())
                .position(position.get().getSelectedItem())
                .repeat(repeat.get().getSelectedItem())
                .build();
    }
}
