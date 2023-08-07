package com.brizy.io.web.common.dto.element.properties.toolbar.image.mask.shape;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = NoneMask.class, name = "None"),
        @JsonSubTypes.Type(value = AnyPredefinedMask.class, names = {"Circle", "Rhombus", "Star", "Flower", "Square", "Triangle", "Hexagon", "Blob1", "Blob2", "Blob3", "Blob4", "Brush1", "Brush2", "Brush3", "Brush4", "Poly1", "Poly2", "Poly3", "Poly4"}),
        @JsonSubTypes.Type(value = CustomMask.class, name = "Custom")
})
public interface Shape {


}

