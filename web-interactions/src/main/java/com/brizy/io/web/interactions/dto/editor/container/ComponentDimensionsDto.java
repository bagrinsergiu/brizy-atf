package com.brizy.io.web.interactions.dto.editor.container;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@Data
@Builder
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class ComponentDimensionsDto {

    Double width;
    Double height;

}
