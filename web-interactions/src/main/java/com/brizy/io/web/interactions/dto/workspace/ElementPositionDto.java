package com.brizy.io.web.interactions.dto.workspace;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@Data
@Builder
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class ElementPositionDto {

    Double x;
    Double y;

}
