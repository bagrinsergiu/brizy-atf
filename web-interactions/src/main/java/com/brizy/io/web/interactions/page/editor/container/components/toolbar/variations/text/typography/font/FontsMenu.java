package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.text.typography.font;

import com.brizy.io.web.interactions.element.ScrollBar;
import com.brizy.io.web.interactions.element.Span;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.typography.fonts.FontsProperties;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FontsMenu {

    Supplier<ScrollBar> fontBar;
    Supplier<Span> activeFont;

    public FontsMenu(FontsProperties fontsProperties, Frame frame) {
        this.fontBar = () -> new ScrollBar(frame.locator(fontsProperties.getSelf()));
        this.activeFont = () -> new Span(frame.locator(fontsProperties.getActiveFont()));
    }

    public void selectFont(String font) {
        fontBar.get().selectItem(font);
    }

    public String getActiveFont() {
        return activeFont.get().getText();
    }

}
