package com.brizy.io.web.interactions.dto.editor.sidebar;

import com.brizy.io.web.interactions.enums.EditorSidebarElement;
import com.brizy.io.web.interactions.enums.ElementPositions;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Data
@Builder(toBuilder = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SidebarItemDto {

    EditorSidebarElement type;
    ElementPositions elementPosition;
    String parentName;
    String elementName;
    Object elementProperties;

}
