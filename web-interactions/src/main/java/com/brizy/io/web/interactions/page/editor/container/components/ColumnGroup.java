package com.brizy.io.web.interactions.page.editor.container.components;

import com.brizy.io.web.interactions.locators.editor.workspace.section.SectionLocators;
import com.brizy.io.web.interactions.page.editor.container.AbstractContainer;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ColumnGroup extends AbstractContainer {

    public ColumnGroup(Frame frame, Locator componentLocator, SectionLocators sectionLocators) {
        super(sectionLocators, frame, componentLocator);
    }

    public static List<Column> initColumns(Frame frame, Locator componentLocator, SectionLocators sectionLocators) {
        AtomicInteger columnCount = new AtomicInteger(0);
        return componentLocator.locator(sectionLocators.getContainer().getItem().getToolbar().getColumn().getSelf()).all()
                .stream()
                .map(locator -> new Column(frame, locator, sectionLocators, columnCount.incrementAndGet()))
                .toList();
    }

}
