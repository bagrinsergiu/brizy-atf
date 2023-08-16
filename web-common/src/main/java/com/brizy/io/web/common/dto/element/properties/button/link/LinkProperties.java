package com.brizy.io.web.common.dto.element.properties.button.link;

import com.brizy.io.web.common.dto.element.properties.button.link.url.URL;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LinkProperties {

    URL url;
    Integer block;
    String popUp;
    String file;

}
