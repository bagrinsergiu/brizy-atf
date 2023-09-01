package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations;

import com.brizy.io.web.common.dto.element.properties.text.TextProperties;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.ComponentToolbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.text.typography.Typography;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.microsoft.playwright.Frame;

import java.util.Objects;
import java.util.function.Supplier;

public class TextToolbar extends ComponentToolbar<TextProperties> {

    Supplier<Typography> typography;
    Supplier<Frame> escape;

    public TextToolbar(ToolbarLocators properties, Frame frame) {
        super(properties, frame);
        this.typography = () -> new Typography(properties.getTypography(), frame);
        this.escape = () -> frame;
    }

    @Override
    public void setProperties(TextProperties properties) {
        if (Objects.nonNull(properties) && Objects.nonNull(properties.getTypography())) {
            typography.get().applyProperties(properties.getTypography());
        }
    }

    @Override
    public TextProperties getProperties() {
        return TextProperties.builder()
                .typography(typography.get().getProperties())
                .build();
    }

}