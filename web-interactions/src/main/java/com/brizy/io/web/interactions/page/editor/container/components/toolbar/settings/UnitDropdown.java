package com.brizy.io.web.interactions.page.editor.container.components.toolbar.settings;

import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.ElementList;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.settings.Unit;
import com.microsoft.playwright.Frame;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Supplier;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class UnitDropdown {

    Supplier<Button> button;
    Supplier<ElementList> list;

    public UnitDropdown(Unit unit, Frame page) {
        this.button = () -> new Button(page.locator(unit.getSelf()));
        this.list = () -> new ElementList(page.locator(unit.getItem()));
    }

    public ElementList get() {
        button.get().click();
        return list.get();
    }

}
