package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations;

import com.brizy.io.web.common.dto.element.properties.common.align.Alignments;
import com.brizy.io.web.common.dto.element.properties.common.list.ListStyles;
import com.brizy.io.web.common.dto.element.properties.text.TextProperties;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.composite.EnumerableButton;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.Toolbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.text.typography.Typography;
import com.microsoft.playwright.Frame;
import io.vavr.API;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.Objects;
import java.util.function.Supplier;

import static io.vavr.API.$;
import static lombok.AccessLevel.PRIVATE;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class TextToolbar extends Toolbar<TextProperties> {

    Supplier<Typography> typography;
    Supplier<EnumerableButton<Alignments>> alignButton;
    Supplier<EnumerableButton<ListStyles>> listButton;
    Supplier<Button> boldButton;
    Supplier<Button> italicButton;
    Supplier<Button> underlineButton;
    Supplier<Button> strikeButton;
    Supplier<Button> uppercaseButton;

    public TextToolbar(ToolbarLocators properties, Frame frame) {
        super(properties, frame);
        this.typography = () -> new Typography(properties.getTypography(), frame);
        this.alignButton = () -> new EnumerableButton<>(Alignments.class,properties.getAlign(), frame);
        this.listButton = () -> new EnumerableButton<>(ListStyles.class, properties.getList(), frame);
        this.boldButton = () -> new Button(frame.locator(properties.getBold()));
        this.italicButton = () -> new Button(frame.locator(properties.getItalic()));
        this.underlineButton = () -> new Button(frame.locator(properties.getUnderline()));
        this.strikeButton = () -> new Button(frame.locator(properties.getStrike()));
        this.uppercaseButton = () -> new Button(frame.locator(properties.getUppercase()));
    }

    @Override
    public IsToolbarItem openTabbedPopup(String toolbarItemTitle) {
        return API.Match(toolbarItemTitle.toLowerCase()).of(
                API.Case($(Fields.typography), typography)
        );
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