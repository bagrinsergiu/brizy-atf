package com.brizy.io.web.interactions.page.editor.container.components.context_menu.commands;

import com.brizy.io.web.interactions.enums.ContextMenuActions;
import com.brizy.io.web.interactions.page.editor.container.components.context_menu.commands.command.*;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.right_click_context.RightClickContextProperties;
import com.microsoft.playwright.Frame;

import java.util.ArrayList;
import java.util.List;

/**
 * The CommandsEngine class represents an engine for performing context menu actions on right click menu.
 * It allows you to execute specific actions from a predefined list of available ContextMenuActions.
 */
public class CommandsEngine {

    List<ExecutableCommand> contextMenuActions;

    public CommandsEngine(Frame locator, RightClickContextProperties properties) {
        this.contextMenuActions = new ArrayList<>();
        contextMenuActions.add(new Copy(locator.locator(properties.getCopy())));
        contextMenuActions.add(new Paste(locator.locator(properties.getPaste())));
        contextMenuActions.add(new PasteStyles(locator.locator(properties.getPasteStyles())));
        contextMenuActions.add(new Duplicate(locator.locator(properties.getDuplicate())));
        contextMenuActions.add(new Delete(locator.locator(properties.getDelete())));
    }

    public void doAction(ContextMenuActions contextMenuAction) {
        contextMenuActions.stream()
                .filter(el -> el.evaluateAction(contextMenuAction))
                .findFirst()
                .ifPresent(ExecutableCommand::execute);
    }

}
