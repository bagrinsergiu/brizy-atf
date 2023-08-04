package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations;

import com.brizy.io.web.common.dto.element.properties.text.TextProperties;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.EditorComponentProperty;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.typography.TextPropertyDto;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.ComponentToolbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.text.typography.Typography;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.ToolbarProperties;
import com.microsoft.playwright.Frame;

import java.util.Objects;
import java.util.function.Supplier;

public class TextToolbar extends ComponentToolbar<TextProperties> {

    Supplier<Typography> typography;
    Supplier<Button> typographyButton;
    Supplier<Frame> escape;

    public TextToolbar(ToolbarProperties properties, Frame frame) {
        super(properties, frame);
        this.typography = () -> new Typography(properties.getTypography(), frame);
        this.typographyButton = () -> new Button(frame.locator(properties.getTypography().getSelf()));
        this.escape = () -> frame;
    }

    protected void openTypography() {
        typographyButton.get().click();
    }

    @Override
    public void withProperties(TextProperties properties) {
        if (Objects.nonNull(properties) && Objects.nonNull(properties.getTypography())) {
            openTypography();
            typography.get().applyProperties(properties.getTypography());
        }
    }

    @Override
    public EditorComponentProperty getProperties() {
        openTypography();
        TextPropertyDto textProperties = TextPropertyDto.builder()
                .typography(typography.get().getProperties())
                .build();
        escape.get().frameElement().press("Escape");
        return textProperties;
    }

}