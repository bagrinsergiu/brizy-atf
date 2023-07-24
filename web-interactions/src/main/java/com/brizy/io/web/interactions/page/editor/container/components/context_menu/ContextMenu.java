package com.brizy.io.web.interactions.page.editor.container.components.context_menu;

import com.brizy.io.web.interactions.dto.editor.container.right_click_context_menu.ContextMenuItemDto;
import com.brizy.io.web.interactions.enums.ContextMenuActions;
import com.brizy.io.web.interactions.page.editor.container.components.context_menu.commands.CommandsEngine;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.right_click_context.RightClickContextProperties;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.options.AriaRole;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class ContextMenu {

    CommandsEngine commandsEngine;
    Frame frame;
    RightClickContextProperties properties;

    public ContextMenu(Frame locator, RightClickContextProperties properties) {
        this.commandsEngine = new CommandsEngine(locator, properties);
        this.frame = locator;
        this.properties = properties;
    }

    public void execute(ContextMenuActions contextMenuAction) {
        commandsEngine.doAction(contextMenuAction);
    }

    public List<ContextMenuItemDto> getActions() {
        return frame.locator(properties.getSelf()).getByRole(AriaRole.MENUITEM).all().stream()
                .skip(1)
                .map(locator -> ContextMenuItemDto.builder()
                        .title(locator.locator(properties.getMenuItem().getTitle()).textContent())
                        .keyShortcut(locator.locator(properties.getMenuItem().getKeyShortcut()).textContent())
                        .isEnabled(!locator.isDisabled())
                        .build())
                .collect(Collectors.toList());
    }

}
