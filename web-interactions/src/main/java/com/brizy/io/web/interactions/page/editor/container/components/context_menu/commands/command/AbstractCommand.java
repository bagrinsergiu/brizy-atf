package com.brizy.io.web.interactions.page.editor.container.components.context_menu.commands.command;

import com.brizy.io.web.interactions.page.editor.container.components.context_menu.commands.ExecutableCommand;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class AbstractCommand implements ExecutableCommand {

    Locator locator;

    @Override
    public void execute() {
        locator.click();
    }

}
