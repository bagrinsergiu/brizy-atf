package com.brizy.io.web.common.dto.element.properties.image.colors;

import com.brizy.io.web.common.dto.element.properties.common.Colors;
import com.brizy.io.web.common.dto.element.properties.common.colors.border.CanHaveBorders;
import com.brizy.io.web.common.dto.element.properties.image.colors.overlay.Overlay;
import com.brizy.io.web.common.dto.element.properties.image.image.shadow.CanHaveShadow;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = HoverColors.class, name = "hover"),
        @JsonSubTypes.Type(value = NormalColors.class, name = "normal")
})
public interface ImageColors extends Colors, CanHaveBorders {

    Overlay getOverlay();

    CanHaveShadow getShadow();

}
