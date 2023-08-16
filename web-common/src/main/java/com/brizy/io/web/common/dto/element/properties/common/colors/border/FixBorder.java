<<<<<<<< HEAD:web-common/src/main/java/com/brizy/io/web/common/dto/element/properties/common/colors/border/FixBorder.java
package com.brizy.io.web.common.dto.element.properties.common.colors.border;
========
package com.brizy.io.web.common.dto.element.properties.common.typography.size;
>>>>>>>> 405f4dbe (* Added new configuration json for button element;):web-common/src/main/java/com/brizy/io/web/common/dto/element/properties/common/typography/size/Size.java

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FixBorder implements BorderSize {

    Integer size;

}
