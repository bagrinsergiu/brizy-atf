package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.item_mover;

import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.mover.MoverLocators;
import com.microsoft.playwright.Frame;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class ItemMover {

    Supplier<Button> moveUp;
    Supplier<Button> moveDown;

    public ItemMover(MoverLocators mover, Frame frame) {
        this.moveUp = () -> new Button(frame.locator(mover.getMoveUp()));
        this.moveDown = () -> new Button(frame.locator(mover.getMoveDown()));
    }

    public void moveElementUp() {
        moveUp.get().click();
    }

    public void moveElementDown() {
        moveDown.get().click();
    }

}
