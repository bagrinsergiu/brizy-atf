package com.brizy.io.web.interactions.dto.editor.container.toolbar.typography;

import com.brizy.io.web.interactions.dto.editor.container.toolbar.EditorComponentProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = false)
@Data
@ToString
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@SuperBuilder(toBuilder = true)
public class TypographyDto {

    String activeFont;
    String typography;
    SizeDto size;
    String weight;
    Double lineHgt;
    Double letterSp;

}
