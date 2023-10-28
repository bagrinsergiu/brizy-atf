package com.brizy.io.web.interactions.page.editor.sidebar;

import com.brizy.io.web.interactions.element.Div;
import com.brizy.io.web.interactions.enums.EditorSidebarElement;
import com.brizy.io.web.interactions.locators.editor.sidebar.EditorAddItemsSidebarContentMainProperties;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static com.brizy.io.web.interactions.enums.EditorSidebarElement.*;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EditorSidebarContent {

    Map<EditorSidebarElement, Supplier<Div>> availableElements;

    public EditorSidebarContent(EditorAddItemsSidebarContentMainProperties main, Page page) {
        this.availableElements = new HashMap<>() {{
            put(COLUMNS, () -> new Div(page.locator(main.getColumns())));
            put(ROW, () -> new Div(page.locator(main.getRow())));
            put(TEXT, () -> new Div(page.locator(main.getText())));
            put(IMAGE, () -> new Div(page.locator(main.getImage())));
            put(BUTTON, () -> new Div(page.locator(main.getButton())));
            put(ICON, () -> new Div(page.locator(main.getIcon())));
            put(SPACER, () -> new Div(page.locator(main.getSpacer())));
            put(MAP, () -> new Div(page.locator(main.getMap())));
            put(FORM, () -> new Div(page.locator(main.getForm())));
            put(LINE, () -> new Div(page.locator(main.getLine())));
            put(MENU_SIMPLE, () -> new Div(page.locator(main.getMenuSimple())));
            put(GALLERY, () -> new Div(page.locator(main.getGallery())));
            put(TRANSLATION, () -> new Div(page.locator(main.getTranslation())));
            put(VIDEO, () -> new Div(page.locator(main.getVideo())));
            put(AUDIO, () -> new Div(page.locator(main.getAudio())));
            put(ICON_TEXT, () -> new Div(page.locator(main.getIconText())));
            put(EMBED_CODE, () -> new Div(page.locator(main.getEmbedCode())));
            put(ALERT, () -> new Div(page.locator(main.getAlert())));
            put(COUNTER, () -> new Div(page.locator(main.getCounter())));
            put(COUNTDOWN_2, () -> new Div(page.locator(main.getCountdown2())));
            put(PROGRESS_BAR, () -> new Div(page.locator(main.getProgressBar())));
            put(TABS, () -> new Div(page.locator(main.getTabs())));
            put(ACCORDION, () -> new Div(page.locator(main.getAccordion())));
            put(POST_TITLE, () -> new Div(page.locator(main.getPostTitle())));
            put(POSTS, () -> new Div(page.locator(main.getPosts())));
            put(ASSETS_POSTS, () -> new Div(page.locator(main.getAssetsPost())));
        }};
    }

    public Div getElement(EditorSidebarElement element) {
        return availableElements.get(element).get();
    }

}
