package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.typography.styles.common;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ValueProperties {

    String value;
    String increase;
    String decrease;

}
