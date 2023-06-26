package com.brizy.io.web.interactions.dto.editor.pop_up;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EditorPopUpItemDto {

    String src;
    TabDto tab;
    BlockDto block;
    StyleDto style;
    CategoryDto category;

}
