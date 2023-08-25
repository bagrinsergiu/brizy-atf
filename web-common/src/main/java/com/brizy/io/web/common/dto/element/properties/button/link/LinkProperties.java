package com.brizy.io.web.common.dto.element.properties.button.link;

import com.brizy.io.web.common.dto.element.properties.button.link.url.URL;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LinkProperties {

    URL url;
    Integer block;
    String popUp;
    String file;

}
