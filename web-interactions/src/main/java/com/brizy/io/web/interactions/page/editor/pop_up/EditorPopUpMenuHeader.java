package com.brizy.io.web.interactions.page.editor.pop_up;

import com.brizy.io.web.interactions.element.TextInput;
import com.brizy.io.web.interactions.exception.TabNotFoundException;
import com.brizy.io.web.interactions.locators.editor.pop_up.EditorPopUpMenuHeaderLocators;
import com.brizy.io.web.interactions.locators.editor.pop_up.EditorPopUpMenuHeaderTabsProperties;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EditorPopUpMenuHeader {

    Supplier<List<Tab>> headerTabs;
    Supplier<TextInput> search;

    public EditorPopUpMenuHeader(EditorPopUpMenuHeaderLocators headerProperties, Page page) {
        this.headerTabs = () -> initTabs(headerProperties.getTabs(), page);
        this.search = () -> new TextInput(page.locator(headerProperties.getSearch()));
    }

    private List<Tab> initTabs(EditorPopUpMenuHeaderTabsProperties tabs, Page page) {
        return page.locator(tabs.getSelf()).all().stream()
                .map(el -> new Tab(tabs.getTab(), el))
                .collect(Collectors.toList());
    }

    public Tab getTab(String tab) {
        return headerTabs.get().stream()
                .filter(el -> el.name().equals(tab))
                .findFirst()
                .orElseThrow(() -> new TabNotFoundException(String.format("Unable to find tab with name %s", tab)));
    }

}
