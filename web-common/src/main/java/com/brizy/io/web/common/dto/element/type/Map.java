package com.brizy.io.web.common.dto.element.type;

import com.brizy.io.web.common.dto.element.properties.DefaultProperty;
import com.brizy.io.web.common.dto.element.properties.map.MapProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Map extends AbstractPropertyType<MapProperties> implements ItemType {

    @Getter
    MapProperties properties;

    @Override
    public <T extends DefaultProperty> T getDefaultProperties() {
//        TODO need to implement
        return null;
    }
}
