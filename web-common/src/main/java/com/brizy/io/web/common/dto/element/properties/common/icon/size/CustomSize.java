package com.brizy.io.web.common.dto.element.properties.common.icon.size;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder(toBuilder = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CustomSize implements Size{

    Integer size;

}
