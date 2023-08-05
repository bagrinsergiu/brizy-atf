package com.brizy.io.web.interactions.properties.editor.bottomPanel;

import com.brizy.io.web.interactions.properties.AbstractProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class EditorBottomPanelSaveMenu extends AbstractProperty {

    String menuItems;
    String clearLayout;
    String saveLayout;
    String publishPage;
    String switchToDraft;

}
