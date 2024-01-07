package com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.pop_up;

import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.SettingsLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.scrollbar.ScrollBarLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.tabs.grid.SettingsGridLocators;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
abstract class AbstractSettingsPopUpWithScrollbar extends AbstractSettingsPopUp {

    ScrollBarLocators scrollBarLocators;
    SettingsGridLocators settingsGridLocators;
    Supplier<Frame> frame;

    public AbstractSettingsPopUpWithScrollbar(SettingsLocators settingsLocators, Frame frame) {
        super(settingsLocators, frame);
        this.scrollBarLocators = settingsLocators.getScrollBar();
        this.settingsGridLocators = settingsLocators.getGrid();
        this.frame = () -> frame;
    }

    protected void close() {
        var page = frame.get().page();
        page.mouse().click(100, 100);
    }

}
