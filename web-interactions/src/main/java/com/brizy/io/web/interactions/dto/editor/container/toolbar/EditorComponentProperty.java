package com.brizy.io.web.interactions.dto.editor.container.toolbar;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@ToString
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public abstract class EditorComponentProperty {
}
