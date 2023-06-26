package com.brizy.io.web.test.model.page;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

@AllArgsConstructor
@Builder
@Data
@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Item {

    String item;
    String position;
    String parent;
    String name;
    @Builder.Default
    PageItemProperty pageItemProperties = null;

}
