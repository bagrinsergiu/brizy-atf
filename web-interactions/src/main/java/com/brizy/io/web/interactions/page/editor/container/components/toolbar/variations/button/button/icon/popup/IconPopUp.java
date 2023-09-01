package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button.icon.popup;

import com.brizy.io.web.common.dto.element.properties.button.button.icon.picker.IconPickerProperties;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.TextInput;
import com.brizy.io.web.interactions.element.composite.PopUpDropdown;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.button.tabs.icon.icon.picker.pop_up.IconPickerPopupLocators;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class IconPopUp {

    Supplier<Locator> tabsLocator;
    Supplier<TextInput> search;
    Supplier<PopUpDropdown> categories;
    Supplier<IconPickerGrid> grid;
    Supplier<Button> closePopUp;

    public IconPopUp(IconPickerPopupLocators iconPickerPopupLocators, Page page) {
        this.tabsLocator = () -> page.locator(iconPickerPopupLocators.getTabs());
        this.search = () -> new TextInput(page.locator(iconPickerPopupLocators.getSearch()));
        this.categories = () -> new PopUpDropdown(iconPickerPopupLocators.getCategories(), page);
        this.grid = () -> new IconPickerGrid(iconPickerPopupLocators.getGrid(), page);
        this.closePopUp = () -> new Button(page.locator(iconPickerPopupLocators.getCloseButton()));
    }

    public void applyProperties(IconPickerProperties icon) {
        if (Objects.nonNull(icon.getType())) {
            openTab(icon.getType());
        }
        if (Objects.nonNull(icon.getCategory())) {
            categories.get().selectItem(icon.getCategory());
        }
        if (Objects.nonNull(icon.getValue())) {
            grid.get().select(icon.getValue());
        }
    }

    private void openTab(String tab) {
        tabsLocator.get().all().stream()
                .filter(el -> el.textContent().equals(tab))
                .findFirst()
                .ifPresent(Locator::click);
    }

    private String getActiveTab() {
        return tabsLocator.get().all().stream()
                .filter(el -> el.getAttribute("class").contains("active"))
                .findFirst()
                .map(Locator::textContent)
                .orElse(StringUtils.EMPTY);
    }

    public IconPickerProperties getProperties() {
        IconPickerProperties iconPopUpProperties = IconPickerProperties.builder()
                .category(categories.get().getActiveItem())
                .value(grid.get().getActiveItem())
                .type(getActiveTab())
                .build();
        closePopUp.get().click();
        return iconPopUpProperties;
    }
}
