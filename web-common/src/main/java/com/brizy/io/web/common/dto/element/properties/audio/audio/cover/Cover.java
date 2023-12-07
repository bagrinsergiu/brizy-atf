package com.brizy.io.web.common.dto.element.properties.audio.audio.cover;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Cover {

    String image;
    Integer zoom;

}