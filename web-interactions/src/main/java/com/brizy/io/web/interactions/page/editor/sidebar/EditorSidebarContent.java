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
            put(ACCORDION, () -> new Div(page.locator(main.getAccordion())));
            put(ALERT, () -> new Div(page.locator(main.getAlert())));
            put(ASSETS_POSTS, () -> new Div(page.locator(main.getAssetsPost())));
            put(AUDIO, () -> new Div(page.locator(main.getAudio())));
            put(BUTTON, () -> new Div(page.locator(main.getButton())));
            put(CALENDLY, () -> new Div(page.locator(main.getCalendly())));
            put(CAROUSEL, () -> new Div(page.locator(main.getCarousel())));
            put(COLUMNS, () -> new Div(page.locator(main.getColumns())));
            put(COUNTDOWN, () -> new Div(page.locator(main.getCountdown2())));
            put(COUNTER, () -> new Div(page.locator(main.getCounter())));
            put(EMBED_CODE, () -> new Div(page.locator(main.getEmbedCode())));
            put(FORM, () -> new Div(page.locator(main.getForm())));
            put(ICON, () -> new Div(page.locator(main.getIcon())));
            put(ICON_TEXT, () -> new Div(page.locator(main.getIconText())));
            put(IMAGE, () -> new Div(page.locator(main.getImage())));
            put(LINE, () -> new Div(page.locator(main.getLine())));
            put(LOTTIE, () -> new Div(page.locator(main.getLottie())));
            put(MAP, () -> new Div(page.locator(main.getMap())));
            put(MENU_SIMPLE, () -> new Div(page.locator(main.getMenuSimple())));
            put(PLAYLIST, () -> new Div(page.locator(main.getPlaylist())));
            put(POST_TITLE, () -> new Div(page.locator(main.getPostTitle())));
            put(POSTS, () -> new Div(page.locator(main.getPosts())));
            put(PROGRESS, () -> new Div(page.locator(main.getProgressBar())));
            put(RATING, () -> new Div(page.locator(main.getRating())));
            put(ROW, () -> new Div(page.locator(main.getRow())));
            put(SPACER, () -> new Div(page.locator(main.getSpacer())));
            put(TABS, () -> new Div(page.locator(main.getTabs())));
            put(TEXT, () -> new Div(page.locator(main.getText())));
            put(TRANSLATION, () -> new Div(page.locator(main.getTranslation())));
            put(VIDEO, () -> new Div(page.locator(main.getVideo())));
        }};
    }

    public Div getElement(EditorSidebarElement element) {
        return availableElements.get(element).get();
    }

}
