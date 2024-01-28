package com.brizy.io.web.common.dto.element.type;

import com.brizy.io.web.common.dto.element.content.gallery.GalleryContentProperties;
import com.brizy.io.web.common.dto.element.properties.gallery.GalleryProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public class Gallery extends AbstractPropertyType<GalleryProperties> implements ItemTypeWithContent {

    GalleryProperties properties;

    GalleryContentProperties[] content;

}