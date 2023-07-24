package com.brizy.io.web.interactions.page.editor.container.components.context_menu;

import com.brizy.io.web.interactions.enums.ContextMenuActions;
import com.brizy.io.web.interactions.page.editor.container.components.context_menu.commands.CommandsEngine;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.right_click_context.RightClickContextProperties;
import com.microsoft.playwright.Frame;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class ComponentContextMenu {

    CommandsEngine commandsEngine;

    public ComponentContextMenu(Frame locator, RightClickContextProperties properties) {
        this.commandsEngine = new CommandsEngine(locator, properties);
    }

    public void execute(ContextMenuActions contextMenuAction) {
        commandsEngine.doAction(contextMenuAction);
    }

}
