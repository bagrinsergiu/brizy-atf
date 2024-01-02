package com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.pop_up;

import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.StylingProperties;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.SettingsLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.scrollbar.styling.StylingTab;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
abstract class AbstractSettingsPopUpWithStyling extends AbstractSettingsPopUpWithScrollbar {

    Supplier<StylingTab> styling;
    Supplier<Button> stylingButton;

    public AbstractSettingsPopUpWithStyling(SettingsLocators settingsLocators, Frame frame) {
        super(settingsLocators, frame);
        this.styling = () -> new StylingTab(getScrollBarLocators().getStyling(), frame.page());
        this.stylingButton = () -> new Button(frame.locator(getSettingsGridLocators().getStyling()));
    }

    public void applyStylingProperties(StylingProperties stylingProperties) {
        if (Objects.nonNull(stylingProperties)) {
            openScrollbarItem();
            styling.get().applyProperties(stylingProperties);
            close();
        }
    }

    public StylingProperties getStylingProperties() {
        openScrollbarItem();
        var properties = styling.get().getProperties();
        close();
        return properties;
    }

    private void openScrollbarItem() {
        stylingButton.get().click();
    }

}
