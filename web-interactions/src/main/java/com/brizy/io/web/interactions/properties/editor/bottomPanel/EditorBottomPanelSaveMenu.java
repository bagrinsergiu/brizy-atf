package com.brizy.io.web.interactions.properties.editor.bottomPanel;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class EditorBottomPanelSaveMenu {

    String self;
    String clearLayout;
    String saveLayout;
    String publishPage;

}
