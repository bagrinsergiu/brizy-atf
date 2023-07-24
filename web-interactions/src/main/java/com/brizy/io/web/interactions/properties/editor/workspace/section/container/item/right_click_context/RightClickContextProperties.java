package com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.right_click_context;

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
public class RightClickContextProperties extends AbstractProperty {

    String elementType;
    String copy;
    String paste;
    String pasteStyles;
    String duplicate;
    String delete;

}
