package com.brizy.io.web.interactions.page.editor.container.components.context_menu.commands;

import com.brizy.io.web.interactions.enums.ContextMenuActions;

public interface ExecutableCommand {

    boolean evaluateAction(ContextMenuActions contextMenuAction);

    void execute();

}
