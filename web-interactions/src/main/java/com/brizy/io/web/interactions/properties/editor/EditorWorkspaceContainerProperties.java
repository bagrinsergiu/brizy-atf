package com.brizy.io.web.interactions.properties.editor;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class EditorWorkspaceContainerProperties {

    String self;
    String item;

}
