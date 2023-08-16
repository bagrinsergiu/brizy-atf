package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations;

import com.brizy.io.web.common.dto.element.properties.button.ButtonProperties;
import com.brizy.io.web.common.dto.element.properties.common.align.Alignments;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.EditorComponentProperty;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.ComponentToolbar;
import com.brizy.io.web.interactions.element.composite.EnumerableButton;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.link.Link;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.colors.Colors;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.text.typography.Typography;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.ToolbarProperties;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@FieldNameConstants
public class ButtonToolbar extends ComponentToolbar<ButtonProperties> {

    Supplier<com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button.Button> buttonItem;
    Supplier<Typography> typography;
    Supplier<Colors> colors;
    Supplier<EnumerableButton<Alignments>> align;
    Supplier<Link> link;

    public ButtonToolbar(ToolbarProperties locators, Frame page) {
        super(locators, page);
        var buttonLocators = locators.getButton();
        this.buttonItem = () -> new com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button.Button(buttonLocators, page);
        this.typography = () -> new Typography(locators.getTypography(), page);
        this.colors = () -> new Colors(locators.getColors(), page);
        this.align = () -> new EnumerableButton<>(Alignments.class, locators.getAlign(), page);
        this.link = () -> new Link(locators.getLink(), page);
    }

    @Override
    public void setProperties(ButtonProperties properties) {
        if (Objects.nonNull(properties.getButton())) {
            buttonItem.get().applyProperties(properties.getButton());
        }
        if (Objects.nonNull(properties.getTypography())) {
            typography.get().applyProperties(properties.getTypography());
        }
        if (Objects.nonNull(properties.getColors())) {
            colors.get().applyProperties(properties.getColors());
        }
        if (Objects.nonNull(properties.getLink())) {
            link.get().applyProperties(properties.getLink());
        }
        if (Objects.nonNull(properties.getAlign())) {
            align.get().setValue(properties.getAlign());
        }
    }

    @Override
    public EditorComponentProperty getProperties() {
        return null;
    }
}