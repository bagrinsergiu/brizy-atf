package com.brizy.io.web.common.dto.element.properties.common.typography;

import com.brizy.io.web.common.dto.element.properties.common.typography.size.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Typography {

    String font;
    Size size;
    String typography;
    String weight;
    Double lineHgt;
    Double letterSp;


}
