package com.brizy.io.web.interactions.dto.editor.container.toolbar.typography;

import com.brizy.io.web.common.dto.element.properties.text.typography.size.Units;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Data
@ToString
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
public class SizeDto {

    Integer size;
    Units unit;

}
