package com.brizy.io.web.interactions.dto.editor.sidebar;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.common.dto.element.type.Content;
import com.brizy.io.web.interactions.enums.ComponentPositions;
import com.brizy.io.web.interactions.enums.EditorSidebarElement;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@Data
@Builder(toBuilder = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SidebarItemDto {

    EditorSidebarElement type;
    ComponentPositions elementPosition;
    String parentName;
    String elementName;
    String sectionName;
    Property componentProperties;
    List<Content> componentContent;

}
