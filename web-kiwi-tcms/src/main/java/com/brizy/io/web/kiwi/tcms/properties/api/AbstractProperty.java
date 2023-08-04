package com.brizy.io.web.kiwi.tcms.properties.api;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class AbstractProperty {

    String filter;
    String create;

}
