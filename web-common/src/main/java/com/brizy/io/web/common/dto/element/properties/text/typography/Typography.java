package com.brizy.io.web.common.dto.element.properties.text.typography;

import com.brizy.io.web.common.dto.element.properties.text.typography.size.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
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
