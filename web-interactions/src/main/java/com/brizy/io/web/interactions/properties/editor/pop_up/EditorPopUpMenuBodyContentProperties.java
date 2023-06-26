package com.brizy.io.web.interactions.properties.editor.pop_up;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class EditorPopUpMenuBodyContentProperties {

    String self;
    String createYourOwn;

}
