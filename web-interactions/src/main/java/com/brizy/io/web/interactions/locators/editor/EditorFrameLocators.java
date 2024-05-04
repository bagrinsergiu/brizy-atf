package com.brizy.io.web.interactions.locators.editor;

import com.brizy.io.web.interactions.locators.editor.cms.EditorCmsPopUpLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.WorkspaceLocators;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class EditorFrameLocators {

    String name;
    String cmsFrame;
    String addButton;
    @NestedConfigurationProperty
    WorkspaceLocators workspace;
    @NestedConfigurationProperty
    EditorCmsPopUpLocators cmsPopup;

}
