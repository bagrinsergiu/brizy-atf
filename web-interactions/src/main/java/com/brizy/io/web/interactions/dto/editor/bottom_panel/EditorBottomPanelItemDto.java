package com.brizy.io.web.interactions.dto.editor.bottom_panel;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder(toBuilder = true)
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class EditorBottomPanelItemDto {

    String name;
    String tooltip;
    Boolean isEnabled;

}
