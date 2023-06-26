package com.brizy.io.web.interactions.properties.editor.bottomPanel;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class EditorBottomPanel {

    String self;
    String showHiddenElements;
    String undo;
    String redo;
    String preview;
    String saveDraft;
    String saveDraftButton;
    @NestedConfigurationProperty
    EditorBottomPanelSaveMenu saveMenu;

}
