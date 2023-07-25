package com.brizy.io.web.interactions.page.editor.container.components.context_menu.commands.command;

import com.brizy.io.web.interactions.enums.ContextMenuActions;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import static com.brizy.io.web.interactions.enums.ContextMenuActions.DUPLICATE;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Duplicate extends AbstractCommand {

    public Duplicate(Locator locator) {
        super(locator);
    }

    @Override
    public boolean evaluateAction(ContextMenuActions contextMenuAction) {
        return DUPLICATE.equals(contextMenuAction);
    }

}
