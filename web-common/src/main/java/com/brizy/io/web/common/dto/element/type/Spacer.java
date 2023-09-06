package com.brizy.io.web.common.dto.element.type;

import com.brizy.io.web.common.dto.element.properties.spacer.SpacerProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public class Spacer extends AbstractPropertyType<SpacerProperties> implements ItemType {

    SpacerProperties properties;

}