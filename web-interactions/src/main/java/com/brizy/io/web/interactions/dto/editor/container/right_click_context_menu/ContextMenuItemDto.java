package com.brizy.io.web.interactions.dto.editor.container.right_click_context_menu;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder(toBuilder = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ContextMenuItemDto {

    String title;
    String keyShortcut;
    Boolean isEnabled;

}
