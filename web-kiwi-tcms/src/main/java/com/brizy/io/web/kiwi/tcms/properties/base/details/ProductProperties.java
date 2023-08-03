package com.brizy.io.web.kiwi.tcms.properties.base.details;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ProductProperties {

    String name;
    String classification;
    String description;

}
