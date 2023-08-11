package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations;

import com.brizy.io.web.common.dto.element.properties.common.list.ListStyles;
import com.brizy.io.web.common.dto.element.properties.text.TextProperties;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.composite.EnumerableButton;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.ComponentToolbar;
import com.brizy.io.web.common.dto.element.properties.common.align.Alignments;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.text.typography.Typography;
import com.microsoft.playwright.Frame;
import java.util.Objects;
import java.util.function.Supplier;

public class TextToolbar extends ComponentToolbar<TextProperties> {

    Supplier<Typography> typography;
    Supplier<Button> typographyButton;
    Supplier<EnumerableButton<Alignments>> alignButton;
    Supplier<EnumerableButton<ListStyles>> listButton;
    Supplier<Button> boldButton;
    Supplier<Button> italicButton;
    Supplier<Button> underlineButton;
    Supplier<Button> strikeButton;
    Supplier<Button> uppercaseButton;
    Supplier<Frame> escape;

    public TextToolbar(ToolbarLocators properties, Frame frame) {
        super(properties, frame);
        this.typography = () -> new Typography(properties.getTypography(), frame);
        this.typographyButton = () -> new Button(frame.locator(properties.getTypography().getSelf()));
        this.alignButton = () -> new EnumerableButton<>(Alignments.class,properties.getAlign(), frame);
        this.listButton = () -> new EnumerableButton<>(ListStyles.class, properties.getList(), frame);
        this.boldButton = () -> new Button(frame.locator(properties.getBold()));
        this.italicButton = () -> new Button(frame.locator(properties.getItalic()));
        this.underlineButton = () -> new Button(frame.locator(properties.getUnderline()));
        this.strikeButton = () -> new Button(frame.locator(properties.getStrike()));
        this.uppercaseButton = () -> new Button(frame.locator(properties.getUppercase()));
        this.escape = () -> frame;
    }

    @Override
    public void setProperties(TextProperties properties) {
        if (Objects.nonNull(properties.getAlign())) {
            alignButton.get().setValue(properties.getAlign());
        }
        if (Objects.nonNull(properties.getList())) {
            listButton.get().setValue(properties.getList());
        }
        if (properties.isBold()) {
            boldButton.get().click();
        }
        if (properties.isItalic()){
            italicButton.get().click();
        }
        if (properties.isUnderline()){
            underlineButton.get().click();
        }
        if (properties.isStrike()){
            strikeButton.get().click();
        }
        if (properties.isUppercase()){
            uppercaseButton.get().click();
        }
        if (Objects.nonNull(properties.getTypography())) {
            typography.get().applyProperties(properties.getTypography());
        }
    }

    @Override
    public TextProperties getProperties() {
        return TextProperties.builder()
                .typography(typography.get().getProperties())
                .strike(strikeButton.get().isActive())
                .uppercase(uppercaseButton.get().isActive())
                .italic(italicButton.get().isActive())
                .underline(underlineButton.get().isActive())
                .bold(boldButton.get().isActive())
                .align(alignButton.get().getValue())
                .list(listButton.get().getValue())
                .build();
    }

}