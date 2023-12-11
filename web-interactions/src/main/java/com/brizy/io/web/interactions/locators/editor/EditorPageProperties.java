package com.brizy.io.web.interactions.locators.editor;

import com.brizy.io.web.interactions.locators.editor.bottomPanel.EditorBottomPanel;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class EditorPageProperties {

    String alert;
    String error;
    @NestedConfigurationProperty
    EditorFrameProperties frame;
    @NestedConfigurationProperty
    EditorBottomPanel bottomPanel;
    @NestedConfigurationProperty
    EditorSidebarProperties sidebar;
    @NestedConfigurationProperty
    EditorPopUpMenuProperties editorPopUp;
}
