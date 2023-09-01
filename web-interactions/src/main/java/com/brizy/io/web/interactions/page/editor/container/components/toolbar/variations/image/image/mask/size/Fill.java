package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.image.mask.size;

import com.brizy.io.web.common.dto.element.properties.image.image.mask.size.FillSize;
import com.brizy.io.web.common.dto.element.properties.image.image.mask.size.Size;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.image.tabs.mask.MaskProperties;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Fill extends AbstractSize {

    public Fill(MaskProperties mask, Frame frame) {
        super(mask, frame);
    }

    @Override
    public void applyProperties(Size size) {
        FillSize fillSize = (FillSize) size;
        selectPosition(fillSize.getPosition());
    }

    public List<Configuration> getConfigurations() {
        return List.of(Configuration.builder().name(Fields.position).element(position).build());
    }

    public FillSize getProperties() {
        return FillSize.builder()
                .position(position.get().getSelectedItem())
                .build();
    }
}
