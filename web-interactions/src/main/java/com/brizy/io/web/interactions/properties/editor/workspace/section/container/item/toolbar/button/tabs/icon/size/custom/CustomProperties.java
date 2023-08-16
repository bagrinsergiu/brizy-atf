package com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.button.tabs.icon.size.custom;

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
public class CustomProperties extends AbstractProperty {

    String value;

}
