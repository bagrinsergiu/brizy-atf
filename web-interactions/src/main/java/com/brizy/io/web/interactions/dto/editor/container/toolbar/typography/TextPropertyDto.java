package com.brizy.io.web.interactions.dto.editor.container.toolbar.typography;

import com.brizy.io.web.interactions.dto.editor.container.toolbar.EditorComponentProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = false)
@Data
@ToString
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@SuperBuilder(toBuilder = true)
public class TextPropertyDto implements EditorComponentProperty {

    TypographyDto typography;

}
