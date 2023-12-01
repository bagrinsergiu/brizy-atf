package com.brizy.io.web.test.model.page;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.common.dto.element.type.Content;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.List;

@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Item {

    String item;
    String position;
    String parent;
    String name;
    String sectionName;
    @Builder.Default
    Property properties = null;
    @Builder.Default
    List<Content> content = List.of();

}
