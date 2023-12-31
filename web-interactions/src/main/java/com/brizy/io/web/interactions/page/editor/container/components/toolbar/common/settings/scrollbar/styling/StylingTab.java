package com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.scrollbar.styling;

import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.StylingProperties;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.styling.StylingLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.scrollbar.styling.tabs.AdvancedStylingTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.scrollbar.styling.tabs.BasicStylingTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsPopUpTab;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.Objects;
import java.util.function.Supplier;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class StylingTab {

    Supplier<Button> tab;
    @Getter
    Supplier<Locator> tabsLocator;
    Supplier<BasicStylingTab> basic;
    Supplier<AdvancedStylingTab> advanced;

    public StylingTab(StylingLocators stylingLocators, Page page) {
        this.tab = () -> new Button(page.locator(stylingLocators.getSelf()));
        this.tabsLocator = () -> page.locator(stylingLocators.getTabs());
        this.basic = () -> new BasicStylingTab(stylingLocators.getBasic(), page);
        this.advanced = () -> new AdvancedStylingTab(stylingLocators.getAdvanced(), page);
    }

    public void applyProperties(StylingProperties styling) {
        tab.get().click();
        if (Objects.nonNull(styling.getBasic())) {
            basic.get().applyProperties(styling.getBasic());
        }
        if (Objects.nonNull(styling.getAdvanced())) {
            advanced.get().applyProperties(styling.getAdvanced());
        }
    }

    public IsPopUpTab openTab(String tab) {
        return null;
    }

    public StylingProperties getProperties() {
        tab.get().click();
        return StylingProperties.builder()
                .advanced(advanced.get().getProperties())
                .basic(basic.get().getProperties())
                .build();
    }
}
