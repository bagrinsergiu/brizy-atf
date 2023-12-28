package com.brizy.io.web.common.dto.element.type;

import com.brizy.io.web.common.dto.element.content.alert.AlertContentProperties;
import com.brizy.io.web.common.dto.element.properties.alert.AlertProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public class Alert extends AbstractPropertyType<AlertProperties> implements ItemTypeWithContent {

    AlertProperties properties;

    AlertContentProperties[] content;

}